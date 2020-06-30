package com.booking.internalclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.booking.common.CustomerResponse;

/**
 * The GetCustomerClient
 * 
 * @author Rachana Sharma
 *
 */
public class GetCustomerClient {

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
	 * Client Method to get all customer
	 * 
	 * @return customerResponse
	 */
	public CustomerResponse getAllCustomerClient() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<CustomerResponse> responseEntity = restTemplate.exchange(baseUrl+"/customer",
				HttpMethod.GET, requestEntity, CustomerResponse.class);
		CustomerResponse customerResponse = responseEntity.getBody();
		return customerResponse;
	}
}
