package com.booking.internalClient;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.booking.common.CustomerRequest;

public class SaveCustomerClient {
	
	/**
	 * RestTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * @param hotel
	 * @return result saveHotelClient method to save new hotel
	 */
	public int saveCustomerClient(CustomerRequest customerRequest) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<CustomerRequest> entity = new HttpEntity<CustomerRequest>(customerRequest, headers);
		int result = restTemplate.exchange("http://localhost:8080/customer/save", HttpMethod.POST, entity, Integer.class)
				.getBody();
		return result;
	}
}
