package com.booking.internalclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * DeleteBookingByIdClient
 * 
 * @author Rachana Sharma 
 */
public class DeleteBookingByIdClient {

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
	 * Client Method to delete booking by id
	 * 
	 * @param id
	 */
	public void deleteBookingClient(int id) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		restTemplate.exchange(baseUrl + "/booking/delete/{id}", HttpMethod.DELETE, requestEntity, void.class, id);
	}
}
