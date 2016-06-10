package com.jdransom.date.calculator.resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.jdransom.date.calculator.model.DateResponse;
import com.jdransom.date.calculator.model.DateTimeUnitType;
import com.jdransom.date.calculator.util.DateTimeHelper;

/**
 * Resource for the RESTful application
 * 
 * @author JacobR
 */
@Path("/calculator/date")
public class DateCalculatorResource {

	/**
	 * @param info
	 * @param request
	 * @return Response
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCalendarList(@Context UriInfo info, @Context HttpServletRequest request) {

		DateResponse result = null;
		ResponseBuilder builder = Response.status(Status.OK).entity(result).type(MediaType.APPLICATION_JSON_TYPE);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date sourceDate = null;
		if (info.getQueryParameters().containsKey("sourceDate")) {
			String tempSource = info.getQueryParameters().getFirst("sourceDate");
			try {
				sourceDate = format.parse(tempSource);
			} catch (ParseException e) {
				builder = Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage())
						.type(MediaType.APPLICATION_JSON_TYPE);
				return builder.build();
			}
		}

		DateTimeUnitType unitType = null;
		if (info.getQueryParameters().containsKey("dateTimeUnit")) {
			String tempUnitType = info.getQueryParameters().getFirst("dateTimeUnit");

			if (DateTimeUnitType.MINUTE.getTypeLabel().equalsIgnoreCase(tempUnitType)) {
				unitType = DateTimeUnitType.MINUTE;
			} else if (DateTimeUnitType.HOUR.getTypeLabel().equalsIgnoreCase(tempUnitType)) {
				unitType = DateTimeUnitType.HOUR;
			} else if (DateTimeUnitType.DAY.getTypeLabel().equalsIgnoreCase(tempUnitType)) {
				unitType = DateTimeUnitType.DAY;
			} else if (DateTimeUnitType.WEEK.getTypeLabel().equalsIgnoreCase(tempUnitType)) {
				unitType = DateTimeUnitType.WEEK;
			} else if (DateTimeUnitType.MONTH.getTypeLabel().equalsIgnoreCase(tempUnitType)) {
				unitType = DateTimeUnitType.MONTH;
			} else if (DateTimeUnitType.YEAR.getTypeLabel().equalsIgnoreCase(tempUnitType)) {
				unitType = DateTimeUnitType.YEAR;
			}
		} else {
			builder = Response.status(Status.INTERNAL_SERVER_ERROR).entity("dateTimeUnit is a required parameter.")
					.type(MediaType.APPLICATION_JSON_TYPE);
			return builder.build();
		}

		Integer numOfUnits = null;
		if (info.getQueryParameters().containsKey("numOfUnits")) {
			String tempNumOfUnits = info.getQueryParameters().getFirst("numOfUnits");
			try {
				numOfUnits = Integer.valueOf(tempNumOfUnits);
			} catch (NumberFormatException e) {
				builder = Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage())
						.type(MediaType.APPLICATION_JSON_TYPE);
				return builder.build();
			}
		}

		if (sourceDate != null && unitType != null && numOfUnits != null) {
			try {
				result = DateTimeHelper.offsetSpecifiedDate(sourceDate, unitType, numOfUnits);
				builder.entity(result);
			} catch (Throwable th) {
				builder = Response.status(Status.INTERNAL_SERVER_ERROR).entity(th.getMessage())
						.type(MediaType.APPLICATION_JSON_TYPE);
			}
		} else {
			// TODO - Reply with error message due to missing parameter(s)
		}

		return builder.build();
	}
}
