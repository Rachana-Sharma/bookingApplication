package com.booking.common;

import java.util.Date;

/**
 * The BookingModel
 * 
 * @author Rachana Sharma
 */
public class BookingModel {

	/**
	 * The booking id
	 */
	private int bookingId;

	/**
	 * The breakfast
	 */
	private boolean breakfast;

	/**
	 * The total charge
	 */
	private double totalCharge;

	/**
	 * The start date
	 */
	private Date startDate;

	/**
	 * The end date
	 */
	private Date endDate;

	/**
	 * Class constructor
	 */
	public BookingModel() {

	}

	/**
	 * @return the breakfast
	 */
	public boolean isBreakfast() {
		return breakfast;
	}

	/**
	 * Registers the Breakfast to display in BookingModel
	 * 
	 * @param breakfast the breakfast to set
	 */
	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}

	/**
	 * get booking id of this BookingModel
	 * 
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
