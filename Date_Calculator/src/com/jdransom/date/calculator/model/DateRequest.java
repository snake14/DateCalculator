package com.jdransom.date.calculator.model;

import java.util.Date;

/**
 * @author JacobR
 *
 */
public class DateRequest {

	Date sourceDate;

	Integer numOfMinutes;

	Integer numOfHours;

	Integer numOfDays;

	Integer numOfWeeks;

	Integer numOfMonths;

	Integer numOfYears;

	/**
	 * Default Constructor
	 */
	public DateRequest() {
	}

	public DateRequest(Date sourceDate) {
		this.sourceDate = sourceDate;
	}
}
