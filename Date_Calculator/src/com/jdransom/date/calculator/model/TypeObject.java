package com.jdransom.date.calculator.model;

/**
 * Generic Type object that can be extended
 * 
 * @author JacobR
 *
 */
public class TypeObject {

	private int typeId;

	private String typeLabel;

	/**
	 * Construct a type with it's assigned ID and label
	 */
	protected TypeObject(int typeId, String typeLabel) {
		this.typeId = typeId;
		this.typeLabel = typeLabel;
	}

	/**
	 * @return the typeId
	 */
	public int getTypeId() {
		return typeId;
	}

	/**
	 * @return the typeLabel
	 */
	public String getTypeLabel() {
		return typeLabel;
	}
}
