package com.booking.common;

public class BillingAndBookingResponse {
	private double totalCharge;

	/**
	 * @param totalCharge
	 */
	public BillingAndBookingResponse(double totalCharge) {
		this.totalCharge = totalCharge;
	}

	/**
	 * 
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
