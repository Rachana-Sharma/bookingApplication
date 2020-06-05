package com.booking.internalModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Rachana Sharma Customer
 */
@Entity
@Table
public class Customer {
	/**
	 * The Customer Id
	 */
	@Id
	@Column
	private int customerId;
	/**
	 * The Customer Name
	 */
	@Column
	private String customerName;

	/**
	 * @param customerId
	 * @param customerName
	 */
	public Customer(int customerId, String customerName) {

		this.customerId = customerId;
		this.customerName = customerName;
	}

	/**
	 * Empty Constructor
	 */
	public Customer() {

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
