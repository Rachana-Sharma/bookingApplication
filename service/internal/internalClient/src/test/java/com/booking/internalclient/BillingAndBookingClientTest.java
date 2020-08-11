package com.booking.internalclient;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.booking.common.BillingAndBookingResponse;

/**
 * BillingAndBookingClientTest
 * 
 * @author Rachana Sharma
 */
public class BillingAndBookingClientTest {

	/**
	 * BillingAndBookingClient
	 */
	@InjectMocks
	BillingAndBookingClient billingAndBookingClient;

	/**
	 * RestTemplate
	 */
	@Mock
	private RestTemplate restTemplate;

	/**
	 * defining and initializing BilliingAndBookingRequest object
	 */
	private BilliingAndBookingRequest billiingAndBookingRequest = null;

	/**
	 * defining and initializing BillingAndBookingResponse object
	 */
	private BillingAndBookingResponse billingAndBookingResponse = null;

	/**
	 * baseUrl
	 */
	private String baseUrl = null;

	/**
	 * sDate
	 */
	private Date sDate;

	/**
	 * eDate
	 */
	private Date eDate;

	/**
	 * sets up all the values and is executed before the actual test cases runs
	 * 
	 * @throws ParseException
	 */
	@BeforeEach
	public void setUp() throws ParseException {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(this.billingAndBookingClient, "baseUrl", baseUrl);

		String startDate = "27-07-2020";
		sDate = new SimpleDateFormat("dd-mm-yyyy").parse(startDate);
		String endDate = "28-07-2020";
		eDate = new SimpleDateFormat("dd-mm-yyyy").parse(endDate);

		billiingAndBookingRequest = new BilliingAndBookingRequest();
		billiingAndBookingRequest.setCustomerName("chandler");
		billiingAndBookingRequest.setStartDate(sDate);
		billiingAndBookingRequest.setEndDate(eDate);
		billiingAndBookingRequest.setBreakfast(true);
		billiingAndBookingRequest.setRoomType("SINGLE");

		billingAndBookingResponse = new BillingAndBookingResponse();
		billingAndBookingResponse.setTotalCharge(6000);
		billingAndBookingResponse.setMessage("Booking Successful");
	}

	/**
	 * Tests billingAndBookingClientMethod
	 */
	@Test
	public void billingAndBookingClientMethodTest() {
		ResponseEntity<BillingAndBookingResponse> responseEntity = new ResponseEntity<BillingAndBookingResponse>(
				billingAndBookingResponse, HttpStatus.OK);
		Mockito.when(restTemplate.exchange(Matchers.eq(baseUrl + "/billing/booking"), Matchers.eq(HttpMethod.POST),
				Matchers.<HttpEntity<?>>any(), Matchers.<Class<BillingAndBookingResponse>>any()))
				.thenReturn(responseEntity);

		BillingAndBookingResponse returnedResponse = billingAndBookingClient
				.billingAndBookingClientMethod(billiingAndBookingRequest);

		assertEquals(billingAndBookingResponse.getTotalCharge(), returnedResponse.getTotalCharge());
		assertEquals(billingAndBookingResponse.getMessage(), returnedResponse.getMessage());

		Mockito.verify(restTemplate).exchange(Matchers.anyString(), Matchers.any(HttpMethod.class),
				Matchers.<HttpEntity<?>>any(), Matchers.<Class<BillingAndBookingResponse>>any());
	}
}
