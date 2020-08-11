package com.booking.externalservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.booking.common.BilliingAndBookingRequest;
import com.booking.common.BillingAndBookingResponse;
import com.booking.common.BookingModel;
import com.booking.common.BookingResponse;
import com.booking.common.CustomerModel;
import com.booking.common.CustomerResponse;
import com.booking.common.RoomModel;
import com.booking.common.RoomResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ExternalControllerTest
 * 
 * @author Rachana Sharma
 */
@ExtendWith(MockitoExtension.class)
public class ExternalControllerTest {

	/**
	 * ExternalController
	 */
	@InjectMocks
	ExternalController externalController;

	/**
	 * ExternalService
	 */
	@Mock
	ExternalService externalService;

	/**
	 * MockMvc
	 */
	private MockMvc mockMvc;

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
	 * defining and initializing RoomModel object
	 */
	private RoomModel roomModel = null;

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
	 * the id
	 */
	private int id;

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
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(externalController).build();

		id = 1;

		String startDate = "27-07-2020";
		sDate = new SimpleDateFormat("dd-mm-yyyy").parse(startDate);
		String endDate = "28-07-2020";
		eDate = new SimpleDateFormat("dd-mm-yyyy").parse(endDate);

		roomModel = new RoomModel(1, "SINGLE", 5000, "AVAILABLE");
		roomResponse = new RoomResponse();
		roomResponse.getRoomResponse().add(roomModel);

		customerModel = new CustomerModel(1, "chandler");
		customerResponse = new CustomerResponse();
		customerResponse.getCustomerResponse().add(customerModel);

		bookingModel = new BookingModel(1, true, 6000, sDate, eDate);
		bookingResponse = new BookingResponse();
		bookingResponse.getBookingResponse().add(bookingModel);

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
	 * tests getAllRoomById method
	 */
	@Test
	public void getRoomByIdTest() throws Exception {
		Mockito.when(externalService.getRoomById(Mockito.anyInt())).thenReturn(roomModel);

		String URI = "/room/1";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(roomModel);
		String outputInJson = result.getResponse().getContentAsString();
		assertEquals(outputInJson, expectedJson);
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		Mockito.verify(externalService).getRoomById(id);
	}

	/**
	 * tests getAllRoom method
	 */
	@Test
	public void getAllRoomTest() throws Exception {
		Mockito.when(externalService.getAllRoom()).thenReturn(roomResponse);

		String URI = "/room";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(roomResponse);
		String outputInJson = result.getResponse().getContentAsString();
		assertEquals(outputInJson, expectedJson);
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		Mockito.verify(externalService).getAllRoom();
	}

	/**
	 * tests getAllCustomer method
	 */
	@Test
	public void getAllCustomerTest() throws Exception {
		Mockito.when(externalService.getAllCustomer()).thenReturn(customerResponse);

		String URI = "/customer";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(customerResponse);
		String outputInJson = result.getResponse().getContentAsString();
		assertEquals(outputInJson, expectedJson);
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		Mockito.verify(externalService).getAllCustomer();
	}

	/**
	 * tests getAllBooking method
	 */
	@Test
	public void getAllBookingTest() throws Exception {
		Mockito.when(externalService.getBooking()).thenReturn(bookingResponse);

		String URI = "/booking";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(bookingResponse);
		String outputInJson = result.getResponse().getContentAsString();
		assertEquals(outputInJson, expectedJson);
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		Mockito.verify(externalService).getBooking();
	}

	/**
	 * tests deleteBooking method
	 */
	@Test
	public void deleteBookingTest() {
		externalService.deleteBooking(id);
		Mockito.verify(externalService).deleteBooking(id);
	}

	/**
	 * tests billingAndBooking method
	 * 
	 * @throws Exception
	 */
	@Test
	public void billingAndBookingTest() throws Exception {
		Mockito.when(externalService.billingAndBooking(Mockito.any(BilliingAndBookingRequest.class)))
				.thenReturn(billingAndBookingResponse);

		String URI = "/billing/booking";

		String inputJson = this.mapToJson(billiingAndBookingRequest);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).contentType(MediaType.APPLICATION_JSON)
				.content(inputJson);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}

	/**
	 * converts POJO to JSON
	 * 
	 * @param object
	 * @return
	 * @throws JsonProcessingException
	 */
	public String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
