package com.jdransom.date.calculator.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jdransom.date.calculator.model.ser.DateSerializer;

/**
 * @author JacobR
 *
 */
public class DateResponse {

	@JsonSerialize(using = DateSerializer.class)
	Date responseDate;

	Integer numOfMinutes;

	Integer numOfHours;

	Integer numOfDays;

	Integer numOfWeeks;

	Integer numOfMonths;

	Integer numOfYears;

	/**
	 * Default Constructor
	 */
	public DateResponse() {
	}

	public DateResponse(Date responseDate) {
		this.responseDate = responseDate;
	}

	public DateResponse(DateTimeUnitType unitType, Integer numOfUnits) {
		switch (unitType.getTypeId()) {
		case DateTimeUnitType.MINUTE_ID:
			numOfMinutes = numOfUnits;
			break;
		case DateTimeUnitType.HOUR_ID:
			numOfHours = numOfUnits;
			break;
		case DateTimeUnitType.DAY_ID:
			numOfDays = numOfUnits;
			break;
		case DateTimeUnitType.WEEK_ID:
			numOfWeeks = numOfUnits;
			break;
		case DateTimeUnitType.MONTH_ID:
			numOfMonths = numOfUnits;
			break;
		case DateTimeUnitType.YEAR_ID:
			numOfYears = numOfUnits;
			break;
		}
	}

	/**
	 * @return the responseDate
	 */
	public Date getResponseDate() {
		return responseDate;
	}

	/**
	 * @param responseDate
	 *            the responseDate to set
	 */
	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	/**
	 * @return the numOfMinutes
	 */
	public Integer getNumOfMinutes() {
		return numOfMinutes;
	}

	/**
	 * @param numOfMinutes
	 *            the numOfMinutes to set
	 */
	public void setNumOfMinutes(Integer numOfMinutes) {
		this.numOfMinutes = numOfMinutes;
	}

	/**
	 * @return the numOfHours
	 */
	public Integer getNumOfHours() {
		return numOfHours;
	}

	/**
	 * @param numOfHours
	 *            the numOfHours to set
	 */
	public void setNumOfHours(Integer numOfHours) {
		this.numOfHours = numOfHours;
	}

	/**
	 * @return the numOfDays
	 */
	public Integer getNumOfDays() {
		return numOfDays;
	}

	/**
	 * @param numOfDays
	 *            the numOfDays to set
	 */
	public void setNumOfDays(Integer numOfDays) {
		this.numOfDays = numOfDays;
	}

	/**
	 * @return the numOfWeeks
	 */
	public Integer getNumOfWeeks() {
		return numOfWeeks;
	}

	/**
	 * @param numOfWeeks
	 *            the numOfWeeks to set
	 */
	public void setNumOfWeeks(Integer numOfWeeks) {
		this.numOfWeeks = numOfWeeks;
	}

	/**
	 * @return the numOfMonths
	 */
	public Integer getNumOfMonths() {
		return numOfMonths;
	}

	/**
	 * @param numOfMonths
	 *            the numOfMonths to set
	 */
	public void setNumOfMonths(Integer numOfMonths) {
		this.numOfMonths = numOfMonths;
	}

	/**
	 * @return the numOfYears
	 */
	public Integer getNumOfYears() {
		return numOfYears;
	}

	/**
	 * @param numOfYears
	 *            the numOfYears to set
	 */
	public void setNumOfYears(Integer numOfYears) {
		this.numOfYears = numOfYears;
	}
}
