package com.booking.common;

import java.util.Date;

/**
 * @author Rachana Sharma Booking
 */
public class BookingRequest {
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
	private String breakfast;
	
	/**
	 * The start date
	 */
	private Date startDate;
	/**
	 * The end date
	 */
	private Date endDate;
	

	/**
	 * @param bookingId
	 * @param breakfast
	 * @param totalCharge
	 * @param startDate
	 * @param endDate
	 */
	public BookingRequest(int bookingId,int customerId,String customerName, String breakfast, Date startDate, Date endDate) {
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.breakfast = breakfast;
		this.startDate = startDate;
		this.endDate = endDate;
		
	}

	/**
	 * Empty Constructor
	 */
	public BookingRequest() {

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
	 * @return the breakfast
	 */
	public String getBreakfast() {
		return breakfast;
	}

	/**
	 * @param breakfast the breakfast to set
	 */
	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
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
	
}
