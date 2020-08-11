package com.booking.internalclient;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.booking.common.BilliingAndBookingRequest;
import com.booking.common.CustomerModel;
import com.booking.common.CustomerResponse;

/**
 * GetCustomerClientTest
 * 
 * @author Rachana Sharma
 */
public class GetCustomerClientTest {

	/**
	 * GetCustomerClient
	 */
	@InjectMocks
	GetCustomerClient getCustomerClient;

	/**
	 * RestTemplate
	 */
	@Mock
	private RestTemplate restTemplate;

	/**
	 * defining and initializing CustomerModel
	 */
	private CustomerModel customerModel = null;

	/**
	 * defining and initializing CustomerResponse
	 */
	private CustomerResponse customerResponse = null;

	/**
	 * baseUrl
	 */
	private String baseUrl = null;

	/**
	 * sets up all the values and is executed before the actual test cases runs
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(this.getCustomerClient, "baseUrl", baseUrl);

		customerModel = new CustomerModel(1, "chandler");
		customerResponse = new CustomerResponse();
		customerResponse.getCustomerResponse().add(customerModel);
	}

	/**
	 * Tests getAllCustomerClientMethod
	 */
	@Test
	public void getAllCustomerClientMethodTest() {
		ResponseEntity<CustomerResponse> responseEntity = new ResponseEntity<CustomerResponse>(customerResponse,
				HttpStatus.OK);
		Mockito.when(restTemplate.exchange(Matchers.eq(baseUrl + "/customer"), Matchers.eq(HttpMethod.GET),
				Matchers.<HttpEntity<?>>any(), Matchers.<Class<CustomerResponse>>any())).thenReturn(responseEntity);

		CustomerResponse returnedCustomerResponse = getCustomerClient.getAllCustomerClientMethod();

		assertEquals(customerResponse.getCustomerResponse().get(0).getCustomerId(),
				returnedCustomerResponse.getCustomerResponse().get(0).getCustomerId());
		assertEquals(customerResponse.getCustomerResponse().get(0).getCustomerName(),
				returnedCustomerResponse.getCustomerResponse().get(0).getCustomerName());
		Mockito.verify(restTemplate).exchange(Matchers.anyString(), Matchers.any(HttpMethod.class),
				Matchers.<HttpEntity<?>>any(), Matchers.<Class<CustomerResponse>>any());

	}
}
