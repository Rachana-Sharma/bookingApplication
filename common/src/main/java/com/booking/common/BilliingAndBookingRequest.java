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
	private int bookingId;
	
	/**
	 * The customer id
	 */
	private int customerId;
	
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
	 * Empty Constructor
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
	 * @param breakfast the breakfast to set
	 */
	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}

	/**
	 * @return the bookingId
	 */
	public int getBookingId() {
		return bookingId;
	}

	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
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

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
}
