package com.booking.internalClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.booking.common.CustomerResponse;

/**
 * @author Rachana Sharma GetCustomerClient
 *
 */
public class GetCustomerClient {

	/**
	 * RestTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * @return List<CustomerRequest>
	 */
	public List<CustomerResponse> getAllCustomerClient() {
		ParameterizedTypeReference<List<CustomerResponse>> customer = new ParameterizedTypeReference<List<CustomerResponse>>() {
		};

		ResponseEntity<List<CustomerResponse>> response = restTemplate.exchange("http://localhost:8080/customer/get",
				HttpMethod.GET, null, customer);
		List<CustomerResponse> myList = response.getBody();
		return myList;
	}
}
