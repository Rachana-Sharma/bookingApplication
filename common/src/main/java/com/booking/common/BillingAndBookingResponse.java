package com.booking.common;

/**
 * The BillingAndBookingResponse
 * 
 * @author Rachana Sharma
 *
 */
public class BillingAndBookingResponse {
	
	/**
	 * the total charge
	 */
	private double totalCharge;

	/**
	 * @param totalCharge
	 */
	public BillingAndBookingResponse(double totalCharge) {
		this.totalCharge = totalCharge;
	}

	/**
	 * empty  constructor
	 */
	public BillingAndBookingResponse() {
	}

	/**
	 * @return the totalCharge
	 */
	public double getTotalCharge() {
		return totalCharge;
	}

	/**
	 * @param totalCharge the totalCharge to set
	 */
	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
	}
}
