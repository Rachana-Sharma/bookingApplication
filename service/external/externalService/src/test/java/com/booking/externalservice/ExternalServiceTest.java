package com.booking.externalservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.booking.common.BilliingAndBookingRequest;
import com.booking.common.BillingAndBookingResponse;
import com.booking.common.BookingModel;
import com.booking.common.BookingResponse;
import com.booking.common.CustomerModel;
import com.booking.common.CustomerResponse;
import com.booking.common.RoomModel;
import com.booking.common.RoomResponse;
import com.booking.internalclient.BillingAndBookingClient;
import com.booking.internalclient.DeleteBookingByIdClient;
import com.booking.internalclient.GetAllRoomClient;
import com.booking.internalclient.GetBookingClient;
import com.booking.internalclient.GetCustomerClient;
import com.booking.internalclient.GetRoomByIdClient;

/**
 * ExternalServiceTest
 * 
 * @author Rachana Sharma
 */
public class ExternalServiceTest {

	/**
	 * ExternalService
	 */
	@InjectMocks
	ExternalService externalService;

	/**
	 * GetRoomByIdClient
	 */
	@Mock
	GetRoomByIdClient getRoomByIdClient;

	/**
	 * GetAllRoomClient
	 */
	@Mock
	GetAllRoomClient getAllRoomClient;

	/**
	 * GetBookingClient
	 */
	@Mock
	GetBookingClient getBookingClient;

	/**
	 * DeleteBookingByIdClient
	 */
	@Mock
	DeleteBookingByIdClient deleteBookingByIdClient;

	/**
	 * GetCustomerClient
	 */
	@Mock
	GetCustomerClient getCustomerClient;

	/**
	 * BillingAndBookingClient
	 */
	@Mock
	BillingAndBookingClient billingAndBookingClient;

	/**
	 * defining and initializing RoomModel object
	 */
	private RoomModel roomModel = null;

	/**
	 * defining and initializing RoomResponse object
	 */
	private RoomResponse roomResponse = null;

	/**
	 * defining and initializing CustomerResponse object
	 */
	private CustomerResponse customerResponse = null;

	/**
	 * defining and initializing BookingResponse object
	 */
	private BookingResponse bookingResponse = null;

	/**
	 * defining and initializing CustomerModel object
	 */
	private CustomerModel customerModel = null;

	/**
	 * defining and initializing BookingModel object
	 */
	private BookingModel bookingModel = null;

	/**
	 * defining and initializing BilliingAndBookingRequest object
	 */
	private BilliingAndBookingRequest billiingAndBookingRequest = null;

	/**
	 * defining and initializing BillingAndBookingResponse object
	 */
	private BillingAndBookingResponse billingAndBookingResponse = null;

	/**
	 * the start date
	 */
	private Date sDate;

	/**
	 * the end date
	 */
	private Date eDate;

	/**
	 * the id
	 */
	private int id;

	/**
	 * sets up all the values and is executed before the actual test cases runs
	 * 
	 * @throws ParseException
	 */
	@BeforeEach
	public void setUp() throws ParseException {
		MockitoAnnotations.initMocks(this);

		id = 1;
		sDate = new Date(2020, 7, 22);
		eDate = new Date(2020, 7, 24);

		roomModel = new RoomModel(1, "SINGLE", 5000, "AVAILABLE");
		roomResponse = new RoomResponse();
		roomResponse.getRoomResponse().add(roomModel);

		bookingModel = new BookingModel(1, true, 6000, sDate, eDate);
		bookingResponse = new BookingResponse();
		bookingResponse.getBookingResponse().add(bookingModel);

		customerModel = new CustomerModel(1, "chandler");
		customerResponse = new CustomerResponse();
		customerResponse.getCustomerResponse().add(customerModel);

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
	 * tests getRoomById method
	 */
	@Test
	public void getRoomByIdTest() {
		Mockito.when(getRoomByIdClient.getRoomByIdClientMethod(Mockito.anyInt())).thenReturn(roomModel);

		RoomModel rm = externalService.getRoomById(1);
		assertEquals(1, rm.getRoomId());
		assertEquals("SINGLE", rm.getRoomType());
		assertEquals(5000, rm.getRoomPrice());
		assertEquals("AVAILABLE", rm.getRoomStatus());
		Mockito.verify(getRoomByIdClient).getRoomByIdClientMethod(Mockito.anyInt());
	}

	/**
	 * tests getAllRoom method
	 */
	@Test
	public void getAllRoomTest() {
		Mockito.when(getAllRoomClient.getAllRoomClientMethod()).thenReturn(roomResponse);

		RoomResponse response = externalService.getAllRoom();
		assertEquals(1, response.getRoomResponse().get(0).getRoomId());
		assertEquals("SINGLE", response.getRoomResponse().get(0).getRoomType());
		assertEquals(5000, response.getRoomResponse().get(0).getRoomPrice());
		assertEquals("AVAILABLE", response.getRoomResponse().get(0).getRoomStatus());
		Mockito.verify(getAllRoomClient).getAllRoomClientMethod();
	}

	/**
	 * tests getBooking method
	 */
	@Test
	public void getBookingTest() {
		Mockito.when(getBookingClient.getAllBookingClientMethod()).thenReturn(bookingResponse);

		BookingResponse response = externalService.getBooking();
		assertEquals(1, response.getBookingResponse().get(0).getBookingId());
		assertEquals(true, response.getBookingResponse().get(0).isBreakfast());
		assertEquals(sDate, response.getBookingResponse().get(0).getStartDate());
		assertEquals(eDate, response.getBookingResponse().get(0).getEndDate());
		assertEquals(6000, response.getBookingResponse().get(0).getTotalCharge());
		Mockito.verify(getBookingClient).getAllBookingClientMethod();
	}

	/**
	 * tests getAllCustomer method
	 */
	@Test
	public void getAllCustomerTest() {
		Mockito.when(getCustomerClient.getAllCustomerClientMethod()).thenReturn(customerResponse);

		CustomerResponse response = externalService.getAllCustomer();
		assertEquals(1, response.getCustomerResponse().get(0).getCustomerId());
		assertEquals("chandler", response.getCustomerResponse().get(0).getCustomerName());
		Mockito.verify(getCustomerClient).getAllCustomerClientMethod();
	}

	/**
	 * tests deleteBooking method
	 */
	@Test
	public void deleteBookingTest() {
		deleteBookingByIdClient.deleteBookingClient(id);
		Mockito.verify(deleteBookingByIdClient).deleteBookingClient(id);
	}

	/**
	 * tests billingAndBooking method
	 * 
	 * @throws Exception
	 */
	@Test
	public void billingAndBookingTest() throws Exception {
		Mockito.when(billingAndBookingClient.billingAndBookingClientMethod(billiingAndBookingRequest))
				.thenReturn(billingAndBookingResponse);

		BillingAndBookingResponse response = externalService.billingAndBooking(billiingAndBookingRequest);
		assertEquals(6000, response.getTotalCharge());
		assertEquals("Booking Successful", response.getMessage());
		Mockito.verify(billingAndBookingClient).billingAndBookingClientMethod(billiingAndBookingRequest);
	}
}
