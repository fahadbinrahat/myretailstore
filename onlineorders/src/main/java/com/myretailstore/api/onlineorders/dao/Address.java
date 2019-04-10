package com.myretailstore.api.onlineorders.dao;

public class Address {

	private String unitNumber;
	private String streetNumber;
	private String streetName;
	private String streetType;
	private String suburb;
	private String postCode; //Some post codes start with number 0
	private String state;
	private String country;
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param unitNumber
	 * @param streetNumber
	 * @param streetName
	 * @param streetType
	 * @param suburb
	 * @param postCode
	 * @param state
	 * @param country
	 */
	public Address(String unitNumber, String streetNumber, String streetName, String streetType, String suburb,
			String postCode, String state, String country) {
		super();
		this.unitNumber = unitNumber;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.streetType = streetType;
		this.suburb = suburb;
		this.postCode = postCode;
		this.state = state;
		this.country = country;
	}

	/**
	 * @return
	 */
	public String getUnitNumber() {
		return unitNumber;
	}

	/**
	 * @param unitNumber
	 */
	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}

	/**
	 * @return
	 */
	public String getStreetNumber() {
		return streetNumber;
	}

	/**
	 * @param streetNumber
	 */
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	/**
	 * @return
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return
	 */
	public String getStreetType() {
		return streetType;
	}

	/**
	 * @param streetType
	 */
	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}

	/**
	 * @return
	 */
	public String getSuburb() {
		return suburb;
	}

	/**
	 * @param suburb
	 */
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	/**
	 * @return
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [unitNumber=" + unitNumber + ", streetNumber=" + streetNumber + ", streetName=" + streetName
				+ ", streetType=" + streetType + ", suburb=" + suburb + ", postCode=" + postCode + ", state=" + state
				+ ", country=" + country + "]";
	} 
	
	
	
	
	
}
