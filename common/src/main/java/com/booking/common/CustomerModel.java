package com.booking.common;

/**
 * The CustomerModel
 * 
 * @author Rachana Sharma
 */
public class CustomerModel {

	/**
	 * The Customer Id
	 */
	private int customerId;

	/**
	 * The Customer Name
	 */
	private String customerName;

	/**
	 * @param customerId
	 * @param customerName
	 */
	public CustomerModel(int customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}

	/**
	 * Class Constructor
	 */
	public CustomerModel() {

	}

	/**
	 * get customerId of this CustomerModel
	 * 
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Registers the customerId to display in CustomerModel
	 * 
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * get customerName of this CustomerModel
	 * 
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * Registers the customerName to display in CustomerModel
	 * 
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
