package com.booking.internalclient;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.booking.common.BilliingAndBookingRequest;
import com.booking.common.BillingAndBookingResponse;

/**
 * the BillingAndBookingClient
 * 
 * @author Rachana Sharma
 *
 */
public class BillingAndBookingClient {

	/**
	 * RestTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * saves new booking and generates bill
	 * 
	 * @param bookingRequest
	 * @return result
	 */
	public BillingAndBookingResponse billingAndBookingClient(BilliingAndBookingRequest bookingRequest) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<BilliingAndBookingRequest> entity = new HttpEntity<BilliingAndBookingRequest>(bookingRequest,
				headers);
		BillingAndBookingResponse result = restTemplate.exchange("http://localhost:8080/billing/booking",
				HttpMethod.POST, entity, BillingAndBookingResponse.class).getBody();
		return result;
	}
}
