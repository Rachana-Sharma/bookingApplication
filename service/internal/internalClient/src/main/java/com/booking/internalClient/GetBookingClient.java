package com.booking.internalClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.booking.common.BookingRequest;

/**
 * @author Rachana Sharma GetBookingClient
 */
public class GetBookingClient {
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * @param bookingRequest
	 * @return List<BookingRequest>
	 */
	public List<BookingRequest> getAllBookingClient() {
		ParameterizedTypeReference<List<BookingRequest>> booking = new ParameterizedTypeReference<List<BookingRequest>>() {
		};

		ResponseEntity<List<BookingRequest>> response = restTemplate.exchange("http://localhost:8080/booking/get",
				HttpMethod.GET, null, booking);
		List<BookingRequest> myList = response.getBody();
		return myList;
	}
}
