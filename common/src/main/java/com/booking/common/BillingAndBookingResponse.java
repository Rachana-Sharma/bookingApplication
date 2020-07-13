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
	 * the message
	 */
	private String message;

	/**
	 * @param totalCharge
	 * @param message
	 */
	public BillingAndBookingResponse(double totalCharge, String message) {
		this.totalCharge = totalCharge;
		this.message = message;
	}

	/**
	 * Class constructor
	 */
	public BillingAndBookingResponse() {
	}

	/**
	 * get totalCharge of this BillingAndBookingResponse
	 * 
	 * @return the totalCharge
	 */
	public double getTotalCharge() {
		return totalCharge;
	}

	/**
	 * Registers the totalCharge to display in BillingAndBookingResponse
	 * 
	 * @param totalCharge the totalCharge to set
	 */
	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
	}

	/**
	 * get message of this BillingAndBookingResponse
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Registers the message to display in BillingAndBookingResponse
	 * 
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
