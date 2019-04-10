package com.myretailstore.api.onlineorders.dao;

/**
 * This class is used as data access object as well as for API request JSON deserialization.
 * A separate API request class can be created as well when complexity arises and/or incoming
 * request to back-end data model mapping requires some transformation.
 * 
 * @author fahadbinrahat
 *
 */

public class Customer {
	
	private Integer id;
	private String name;
	private Address address;
	private String phone;
	
	/**
	 * 
	 */
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param address
	 * @param phone
	 */
	public Customer(Integer id, String name, Address address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	
	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	

}
