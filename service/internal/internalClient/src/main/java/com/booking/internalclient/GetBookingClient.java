package com.booking.internalclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.booking.common.BookingResponse;

/**
 * The GetBookingClient
 * 
 * @author Rachana Sharma
 */
public class GetBookingClient {
	/**
	 * RestTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Client Method get all booking
	 * 
	 * @param bookingRequest
	 * @return BookingResponse
	 */
	public BookingResponse getAllBookingClient() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<BookingResponse> responseEntity = restTemplate.exchange("http://localhost:8080/booking/get",
				HttpMethod.GET, requestEntity, BookingResponse.class);
		BookingResponse bookingResponse = responseEntity.getBody();
		return bookingResponse;
	}
}
