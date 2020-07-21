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
	 * @param bookingId
	 * @param breakfast
	 * @param totalCharge
	 * @param startDate
	 * @param endDate
	 */
	public BookingModel(int bookingId, boolean breakfast, double totalCharge, Date startDate, Date endDate) {
		super();
		this.bookingId = bookingId;
		this.breakfast = breakfast;
		this.totalCharge = totalCharge;
		this.startDate = startDate;
		this.endDate = endDate;
	}

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
	 * Registers the bookingId to display in BookingModel
	 * 
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * get totalCharge of this BookingModel
	 * 
	 * @return the totalCharge
	 */
	public double getTotalCharge() {
		return totalCharge;
	}

	/**
	 * Registers the totalCharge to display in BookingModel
	 * 
	 * @param totalCharge the totalCharge to set
	 */
	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
	}

	/**
	 * get startDate of this BookingModel
	 * 
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Registers the startDate to display in BookingModel
	 * 
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * get endDate of this BookingModel
	 * 
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Registers the endDate to display in BookingModel
	 * 
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
