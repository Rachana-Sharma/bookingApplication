package com.booking.common;

/**
 * @author Rachana Sharma Customer
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

		this.customerId = customerId;
		this.customerName = customerName;
	}

	/**
	 * Empty Constructor
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
