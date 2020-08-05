package com.booking.internalclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	 * baseUrl
	 */
	@Value("${base.url}")
	private String baseUrl;

	/**
	 * Client Method get all booking
	 * 
	 * @param bookingRequest
	 * @return BookingResponse
	 */
	public BookingResponse getAllBookingClientMethod() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<BookingResponse> responseEntity = restTemplate.exchange(baseUrl+"/booking",
				HttpMethod.GET, requestEntity, BookingResponse.class);
		BookingResponse bookingResponse = responseEntity.getBody();
		return bookingResponse;
	}
}
