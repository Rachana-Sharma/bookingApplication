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
import org.springframework.web.client.RestTemplate;

import com.booking.common.BilliingAndBookingRequest;
import com.booking.common.BookingModel;
import com.booking.common.BookingResponse;

/**
 * GetBookingClientTest
 * 
 * @author Rachana Sharma
 */
public class GetBookingClientTest {

	/**
	 * GetBookingClient
	 */
	@InjectMocks
	GetBookingClient getBookingClient;

	/**
	 * RestTemplate
	 */
	@Mock
	private RestTemplate restTemplate;

	/**
	 * defining and initializing BookingModel
	 */
	private BookingModel bookingModel = null;

	/**
	 * defining and initializing BookingResponse
	 */
	private BookingResponse bookingResponse = null;

	/**
	 * the start date
	 */
	private Date sDate;

	/**
	 * the end date
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

		String startDate = "27-07-2020";
		sDate = new SimpleDateFormat("dd-mm-yyyy").parse(startDate);
		String endDate = "28-07-2020";
		eDate = new SimpleDateFormat("dd-mm-yyyy").parse(endDate);

		bookingModel = new BookingModel(1, true, 6000, sDate, eDate);
		bookingResponse = new BookingResponse();
		bookingResponse.getBookingResponse().add(bookingModel);
	}

	/**
	 * Tests getAllBookingClientMethod
	 * {@link GetBookingClient#getAllBookingClientMethod()}
	 */
	@Test
	public void getAllBookingClientMethodTest() {
		ResponseEntity<BookingResponse> responseEntity = new ResponseEntity<BookingResponse>(bookingResponse,
				HttpStatus.OK);
		Mockito.when(restTemplate.exchange(Matchers.anyString(), Matchers.any(HttpMethod.class),
				Matchers.<HttpEntity<?>>any(), Matchers.<Class<BookingResponse>>any())).thenReturn(responseEntity);

		BookingResponse returnedBookingResponse = getBookingClient.getAllBookingClientMethod();

		assertEquals(bookingResponse.getBookingResponse().get(0).getBookingId(),
				returnedBookingResponse.getBookingResponse().get(0).getBookingId());
		assertEquals(bookingResponse.getBookingResponse().get(0).getStartDate(),
				returnedBookingResponse.getBookingResponse().get(0).getStartDate());
		assertEquals(bookingResponse.getBookingResponse().get(0).getEndDate(),
				returnedBookingResponse.getBookingResponse().get(0).getEndDate());
		assertEquals(bookingResponse.getBookingResponse().get(0).isBreakfast(),
				returnedBookingResponse.getBookingResponse().get(0).isBreakfast());
		assertEquals(bookingResponse.getBookingResponse().get(0).getTotalCharge(),
				returnedBookingResponse.getBookingResponse().get(0).getTotalCharge());

		Mockito.verify(restTemplate).exchange(Matchers.anyString(), Matchers.any(HttpMethod.class),
				Matchers.<HttpEntity<?>>any(), Matchers.<Class<BookingResponse>>any());
	}
}
