package com.jdransom.date.calculator.model;

/**
 * @author JacobR
 *
 */
public class DateTimeUnitType extends TypeObject {

	public static final int YEAR_ID = 1;

	public static final int MONTH_ID = 2;

	public static final int WEEK_ID = 3;

	public static final int DAY_ID = 4;

	public static final int HOUR_ID = 5;

	public static final int MINUTE_ID = 6;

	private static final String YEAR_LABEL = "Year";

	private static final String MONTH_LABEL = "Month";

	private static final String WEEK_LABEL = "Week";

	private static final String DAY_LABEL = "Day";

	private static final String HOUR_LABEL = "Hour";

	private static final String MINUTE_LABEL = "Minute";

	public static final DateTimeUnitType YEAR = new DateTimeUnitType(YEAR_ID, YEAR_LABEL);

	public static final DateTimeUnitType MONTH = new DateTimeUnitType(MONTH_ID, MONTH_LABEL);

	public static final DateTimeUnitType WEEK = new DateTimeUnitType(WEEK_ID, WEEK_LABEL);

	public static final DateTimeUnitType DAY = new DateTimeUnitType(DAY_ID, DAY_LABEL);

	public static final DateTimeUnitType HOUR = new DateTimeUnitType(HOUR_ID, HOUR_LABEL);

	public static final DateTimeUnitType MINUTE = new DateTimeUnitType(MINUTE_ID, MINUTE_LABEL);

	/**
	 * @param yearId
	 * @param yearLabel
	 */
	public DateTimeUnitType(Integer typeId, String typeLabel) {
		super(typeId, typeLabel);
	}
}
