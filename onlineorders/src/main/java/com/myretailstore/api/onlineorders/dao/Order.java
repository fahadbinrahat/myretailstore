package com.myretailstore.api.onlineorders.dao;

import java.util.Date;

/**
 * This class is used as data access object as well as for API request JSON deserialization.
 * A separate API request class can be created as well when complexity arises and/or incoming
 * request to back-end data model mapping requires some transformation.
 * 
 * @author fahadbinrahat
 *
 */
public class Order {

	public enum orderStatus {

		RECEIVED, IN_PROGRESS, PROCESSED, COMPLETED
	};

	private Integer id;
	private String description;
	private orderStatus status;
	private Date creationTime;
	
	private Customer customer;
	private Product product;
	
	
	
	/**
	 * 
	 */
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param description
	 * @param status
	 * @param creationTime
	 * @param customer
	 * @param product
	 */
	public Order(Integer id, String description, orderStatus status, Date creationTime, Customer customer, Product product) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
		this.creationTime = creationTime;
		this.customer = customer;
		this.product = product;
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
	public String getDescription() {
		return description;
	}
	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return
	 */
	public orderStatus getStatus() {
		return status;
	}
	/**
	 * @param status
	 */
	public void setStatus(orderStatus status) {
		this.status = status;
	}
	/**
	 * @return
	 */
	public Date getCreationTime() {
		return creationTime;
	}
	/**
	 * @param creationTime
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	/**
	 * @return
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * @return
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @param product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", description=" + description + ", status=" + status + ", creationTime="
				+ creationTime + ", customer=" + customer + ", product=" + product + "]";
	}
	
	

}
