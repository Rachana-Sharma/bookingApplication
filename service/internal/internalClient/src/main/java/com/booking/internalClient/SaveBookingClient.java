package com.booking.internalClient;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.booking.common.BookingRequest;

public class SaveBookingClient {

	/**
	 * RestTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	public int saveBookingClient(BookingRequest bookingRequest) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<BookingRequest> entity = new HttpEntity<BookingRequest>(bookingRequest,headers);
		int result=restTemplate.exchange("http://localhost:8080/booking/save", HttpMethod.POST, entity, Integer.class).getBody();
		return result;
	}
}
