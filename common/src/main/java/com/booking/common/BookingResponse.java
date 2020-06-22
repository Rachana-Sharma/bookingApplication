package com.booking.common;

import java.util.ArrayList;
import java.util.List;

/**
 * The BookingResponse
 * 
 * @author Rachana Sharma
 *
 */
public class BookingResponse {
	/**
	 * The bookingResponse
	 */
	private List<BookingModel> bookingResponse = new ArrayList<>();

	/**
	 * @param bookingResponse
	 */
	public BookingResponse(List<BookingModel> bookingResponse) {
		this.bookingResponse = bookingResponse;
	}

	/**
	 * Class constructor
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
