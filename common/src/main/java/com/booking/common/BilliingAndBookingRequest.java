package com.booking.common;

import java.util.Date;

/**
 * The BilliingAndBookingRequest
 * 
 * @author Rachana Sharma
 */
public class BilliingAndBookingRequest {

	/**
	 * The booking id
	 */
	private String customerName;

	/**
	 * The breakfast
	 */
	private boolean breakfast;

	/**
	 * The start date
	 */
	private Date startDate;

	/**
	 * The end date
	 */
	private Date endDate;

	/**
	 * The room status
	 */
	private String roomType;

	/**
	 * Class Constructor
	 */
	public BilliingAndBookingRequest() {

	}

	/**
	 * @return the breakfast
	 */
	public boolean isBreakfast() {
		return breakfast;
	}

	/**
	 * Registers the breakfast to display in BilliingAndBookingRequest
	 * 
	 * @param breakfast the breakfast to set
	 */
	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}

	/**
	 * get customerName of this BilliingAndBookingRequest
	 * 
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * Registers the customerName to display in BilliingAndBookingRequest
	 * 
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * get startDate of this BilliingAndBookingRequest
	 * 
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Registers the startDate to display in BilliingAndBookingRequest
	 * 
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * get endDate of this BilliingAndBookingRequest
	 * 
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Registers the endDate to display in BilliingAndBookingRequest
	 * 
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * get roomType of this BilliingAndBookingRequest
	 * 
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * Registers the roomType to display in BilliingAndBookingRequest
	 * 
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
}
