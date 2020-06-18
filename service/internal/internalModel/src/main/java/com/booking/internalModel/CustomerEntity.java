package com.booking.internalModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The CustomerEntity
 * 
 * @author Rachana Sharma
 */
@Entity
@Table
public class CustomerEntity {
	/**
	 * The Customer Id
	 */
	@Id
	@SequenceGenerator(initialValue = 1, allocationSize = 3, name = "mySeqGen")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int customerId;
	/**
	 * The Customer Name
	 */
	@Column
	private String customerName;

	/**
	 * Class Constructor
	 */
	public CustomerEntity() {

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
