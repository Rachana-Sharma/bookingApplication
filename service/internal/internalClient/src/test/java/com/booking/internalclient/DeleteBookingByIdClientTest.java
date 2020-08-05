package com.booking.internalclient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * DeleteBookingByIdClientTest
 * 
 * @author Rachana Sharma
 */
public class DeleteBookingByIdClientTest {

	/**
	 * DeleteBookingByIdClient
	 */
	@InjectMocks
	DeleteBookingByIdClient deleteBookingByIdClient;

	/**
	 * RestTemplate
	 */
	@Mock
	private RestTemplate restTemplate;

	/**
	 * sets up all the values and is executed before the actual test cases runs
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Tests getAllRoomClientMethod
	 * {@link DeleteBookingByIdClientTest#deleteBookingByIdClient}
	 */

	@Test
	public void deleteBookingByIdClientTest() {
		deleteBookingByIdClient.deleteBookingClient(1);
		Mockito.verify(restTemplate).exchange(Matchers.anyString(), Matchers.any(HttpMethod.class),
				Matchers.<HttpEntity<?>>any(), Matchers.<Class<Void>>any(), Matchers.anyInt());
	}
}
