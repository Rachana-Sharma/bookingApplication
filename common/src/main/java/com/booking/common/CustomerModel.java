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
	 * Class Constructor
	 */
	public CustomerModel() {

	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
