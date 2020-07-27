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

import com.booking.common.BookingModel;
import com.booking.common.BookingResponse;
import com.booking.common.CustomerModel;
import com.booking.common.CustomerResponse;
import com.booking.common.RoomModel;
import com.booking.common.RoomResponse;
import com.booking.internalclient.GetAllRoomClient;
import com.booking.internalclient.GetBookingClient;
import com.booking.internalclient.GetCustomerClient;
import com.booking.internalclient.GetRoomByIdClient;

public class ExternalServiceTest {

	@InjectMocks
	ExternalService externalService;

	@Mock
	GetRoomByIdClient getRoomByIdClient;

	@Mock
	GetAllRoomClient getAllRoomClient;

	@Mock
	GetBookingClient getBookingClient;

	@Mock
	GetCustomerClient getCustomerClient;

	private RoomModel roomModel = null;

	private RoomResponse roomResponse = null;

	private CustomerResponse customerResponse = null;

	private BookingResponse bookingResponse = null;

	private CustomerModel customerModel = null;

	private BookingModel bookingModel = null;

	private Date sDate;

	private Date eDate;

	@BeforeEach
	public void setUp() throws ParseException {
		MockitoAnnotations.initMocks(this);

		String startDate = "27-08-2020";
		sDate = new SimpleDateFormat("dd-mm-yyyy").parse(startDate);
		String endDate = "28-08-2020";
		eDate = new SimpleDateFormat("dd-mm-yyyy").parse(endDate);

		roomModel = new RoomModel(1, "SINGLE", 5000, "AVAILABLE");
		roomResponse = new RoomResponse();
		roomResponse.getRoomResponse().add(roomModel);

		bookingModel = new BookingModel(1, true, 6000, sDate, eDate);
		bookingResponse = new BookingResponse();
		bookingResponse.getBookingResponse().add(bookingModel);

		customerModel = new CustomerModel(1, "chandler");
		customerResponse = new CustomerResponse();
		customerResponse.getCustomerResponse().add(customerModel);
	}

	@Test
	public void getRoomByIdTest() {
		Mockito.when(getRoomByIdClient.getRoomByIdClient(Mockito.anyInt())).thenReturn(roomModel);
		RoomModel rm = getRoomByIdClient.getRoomByIdClient(1);
		assertEquals(1, rm.getRoomId());
		assertEquals("SINGLE", rm.getRoomType());
		assertEquals(5000, rm.getRoomPrice());
		assertEquals("AVAILABLE", rm.getRoomStatus());
		Mockito.verify(getRoomByIdClient).getRoomByIdClient(Mockito.anyInt());
	}

	@Test
	public void getAllRoomTest() {
		Mockito.when(getAllRoomClient.getAllRoomClientMethod()).thenReturn(roomResponse);
		RoomResponse response = getAllRoomClient.getAllRoomClientMethod();
		assertEquals(1, response.getRoomResponse().get(0).getRoomId());
		assertEquals("SINGLE", response.getRoomResponse().get(0).getRoomType());
		assertEquals(5000, response.getRoomResponse().get(0).getRoomPrice());
		assertEquals("AVAILABLE", response.getRoomResponse().get(0).getRoomStatus());
		Mockito.verify(getAllRoomClient).getAllRoomClientMethod();
	}

	@Test
	public void getBookingTest() {
		Mockito.when(getBookingClient.getAllBookingClient()).thenReturn(bookingResponse);

		BookingResponse response = getBookingClient.getAllBookingClient();
		assertEquals(1, response.getBookingResponse().get(0).getBookingId());
		assertEquals(true, response.getBookingResponse().get(0).isBreakfast());
		assertEquals(sDate, response.getBookingResponse().get(0).getStartDate());
		assertEquals(eDate, response.getBookingResponse().get(0).getEndDate());
		assertEquals(6000, response.getBookingResponse().get(0).getTotalCharge());
		Mockito.verify(getBookingClient).getAllBookingClient();
	}

	@Test
	public void getAllCustomerTest() {
		Mockito.when(getCustomerClient.getAllCustomerClient()).thenReturn(customerResponse);
		CustomerResponse response = getCustomerClient.getAllCustomerClient();
		assertEquals(1, response.getCustomerResponse().get(0).getCustomerId());
		assertEquals("chandler", response.getCustomerResponse().get(0).getCustomerName());
		Mockito.verify(getCustomerClient).getAllCustomerClient();
	}
}
