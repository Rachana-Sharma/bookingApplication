package com.booking.common;

import java.util.ArrayList;
import java.util.List;

/**
 * The CustomerResponse
 * 
 * @author Rachana Sharma
 */
public class CustomerResponse {

	/**
	 * The customer response
	 */
	private List<CustomerModel> customerResponse = new ArrayList<>();

	/**
	 * @param customerResponse
	 */
	public CustomerResponse(List<CustomerModel> customerResponse) {
		this.customerResponse = customerResponse;
	}

	/**
	 * @param customerResponse
	 */
	public CustomerResponse() {

	}

	/**
	 * get customerResponse of this CustomerResponse
	 * 
	 * @return the customerResponse
	 */
	public List<CustomerModel> getCustomerResponse() {
		return customerResponse;
	}

	/**
	 * Registers the customerResponse to display in CustomerResponse
	 * 
	 * @param customerResponse the customerResponse to set
	 */
	public void setCustomerResponse(List<CustomerModel> customerResponse) {
		this.customerResponse = customerResponse;
	}
}
