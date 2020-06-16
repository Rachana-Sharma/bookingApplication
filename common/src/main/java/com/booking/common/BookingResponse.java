package com.booking.common;

import java.util.List;

public class BookingResponse {
	List<BookingModel> bookingResponse;

	/**
	 * @param bookingResponse
	 */
	public BookingResponse(List<BookingModel> bookingResponse) {
		this.bookingResponse = bookingResponse;
	}

	/**
	 * 
	 */
	public BookingResponse() {
	}

	/**
	 * @return the bookingResponse
	 */
	public List<BookingModel> getBookingResponse() {
		return bookingResponse;
	}

	/**
	 * @param bookingResponse the bookingResponse to set
	 */
	public void setBookingResponse(List<BookingModel> bookingResponse) {
		this.bookingResponse = bookingResponse;
	}
}
