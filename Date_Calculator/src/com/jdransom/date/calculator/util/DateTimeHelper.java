/**
 * 
 */
package com.jdransom.date.calculator.util;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.jdransom.date.calculator.model.DateResponse;
import com.jdransom.date.calculator.model.DateTimeUnitType;

/**
 * @author JacobR
 *
 */
public class DateTimeHelper {

	public static DateResponse calculateDayOffsetDate(Date sourceDate) {
		DateResponse result = null;

		Date currentDate = new Date();

		Long diffMillis = currentDate.getTime() - sourceDate.getTime();

		Long diffDays = TimeUnit.DAYS.convert(diffMillis, TimeUnit.MILLISECONDS);

		result = new DateResponse(DateTimeUnitType.DAY, diffDays.intValue());

		return result;
	}

	public static DateResponse calculateWeekOffsetDate(Date sourceDate) {
		DateResponse result = null;

		Date currentDate = new Date();

		Long diffMillis = currentDate.getTime() - sourceDate.getTime();

		Long diffDays = TimeUnit.DAYS.convert(diffMillis, TimeUnit.MILLISECONDS);

		result = new DateResponse(DateTimeUnitType.DAY, diffDays.intValue() / 7);

		return result;
	}

	public static DateResponse offsetSpecifiedDate(Date sourceDate, DateTimeUnitType unitType, Integer numOfUnits) {
		DateResponse result = null;

		Calendar c = Calendar.getInstance();
		c.setTime(sourceDate);
		switch (unitType.getTypeId()) {
		case DateTimeUnitType.MINUTE_ID:
			c.add(Calendar.MINUTE, numOfUnits);
			break;
		case DateTimeUnitType.HOUR_ID:
			c.add(Calendar.HOUR, numOfUnits);
			break;
		case DateTimeUnitType.DAY_ID:
			c.add(Calendar.DATE, numOfUnits);
			break;
		case DateTimeUnitType.WEEK_ID:
			c.add(Calendar.DATE, numOfUnits * 7);
			break;
		case DateTimeUnitType.MONTH_ID:
			c.add(Calendar.MONTH, numOfUnits);
			break;
		case DateTimeUnitType.YEAR_ID:
			c.add(Calendar.YEAR, numOfUnits);
			break;
		}

		result = new DateResponse(c.getTime());

		return result;
	}
}
