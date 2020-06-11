package com.booking.common;

/**
 * @author Rachana Sharma BillingRequest
 *
 */
public class BillingRequest {

	private int bookingId;
	private int roomId;
	private boolean breakfast;
	/**
	 * @param bookingId
	 * @param roomId
	 * @param breakfast
	 */
	public BillingRequest(int bookingId, int roomId, boolean breakfast) {
		this.bookingId = bookingId;
		this.roomId = roomId;
		this.breakfast = breakfast;
	}
	/**
	 * 
	 */
	public BillingRequest() {
		
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
	 * @return the roomId
	 */
	public int getRoomId() {
		return roomId;
	}
	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(int roomId) {
		this.roomId = roomId;
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

	

}
