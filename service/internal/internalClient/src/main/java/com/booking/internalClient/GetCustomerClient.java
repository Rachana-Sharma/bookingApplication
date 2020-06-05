package com.booking.internalClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.booking.common.CustomerRequest;

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
	public List<CustomerRequest> getAllCustomerClient() {
		ParameterizedTypeReference<List<CustomerRequest>> customer = new ParameterizedTypeReference<List<CustomerRequest>>() {
		};

		ResponseEntity<List<CustomerRequest>> response = restTemplate.exchange("http://localhost:8080/customer/get",
				HttpMethod.GET, null, customer);
		List<CustomerRequest> myList = response.getBody();
		return myList;
	}
}
