package com.booking.internalservice;

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
import com.booking.internalmodel.BookingEntity;
import com.booking.internalmodel.CustomerEntity;
import com.booking.internalmodel.RoomEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class InternalControllerTest {

	@InjectMocks
	private InternalController internalController;

	@Mock
	private InternalService internalService;

	private MockMvc mockMvc;

	private RoomEntity roomEntity = null;

	private RoomResponse roomResponse = null;

	private CustomerResponse customerResponse = null;

	private BookingResponse bookingResponse = null;

	private CustomerModel customerModel = null;

	private RoomModel roomModel = null;

	private BookingModel bookingModel = null;

	private BilliingAndBookingRequest billiingAndBookingRequest = null;
	
	private BillingAndBookingResponse billingAndBookingResponse = null;
	
	private int id;

	private Date sDate;

	private Date eDate;

	/**
	 * sets up all the values and is executed before the actual test cases runs
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {

		mockMvc = MockMvcBuilders.standaloneSetup(internalController).build();

		id = 1;

		String startDate = "27-07-2020";
		sDate = new SimpleDateFormat("dd-mm-yyyy").parse(startDate);
		String endDate = "28-07-2020";
		eDate = new SimpleDateFormat("dd-mm-yyyy").parse(endDate);

		roomEntity = new RoomEntity();
		roomEntity.setRoomId(1);
		roomEntity.setRoomPrice(5000);
		roomEntity.setRoomStatus("AVAILABLE");
		roomEntity.setRoomType("SINGLE");

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
	 * {@link InternalController#getRoomById(int)}
	 * 
	 * @throws Exception
	 */
	@Test
	public void getRoomByIdTest() throws Exception {

		Mockito.when(internalService.getRoomById(Mockito.anyInt())).thenReturn(roomEntity);

		String URI = "/room/1";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(roomEntity);
		String outputInJson = result.getResponse().getContentAsString();
		assertEquals(outputInJson, expectedJson);
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		Mockito.verify(internalService).getRoomById(id);
	}

	/**
	 * {@link InternalController#getAllRoom()}
	 * 
	 * @throws Exception
	 */
	@Test
	public void getAllRoomTest() throws Exception {

		Mockito.when(internalService.getAllRoom()).thenReturn(roomResponse);

		String URI = "/room";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(roomResponse);
		String outputInJson = result.getResponse().getContentAsString();
		assertEquals(outputInJson, expectedJson);
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		Mockito.verify(internalService).getAllRoom();
	}

	/**
	 * {@link InternalController#getAllCustomer()}
	 * 
	 * @throws Exception
	 */
	@Test
	public void getAllCustomerTest() throws Exception {

		Mockito.when(internalService.getAllCustomer()).thenReturn(customerResponse);

		String URI = "/customer";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(customerResponse);
		String outputInJson = result.getResponse().getContentAsString();
		assertEquals(outputInJson, expectedJson);
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		Mockito.verify(internalService).getAllCustomer();
	}

	/**
	 * {@link InternalController#getAllBooking()}
	 * 
	 * @throws Exception
	 */
	@Test
	public void getAllBookingTest() throws Exception {

		Mockito.when(internalService.getAllBooking()).thenReturn(bookingResponse);

		String URI = "/booking";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(bookingResponse);
		String outputInJson = result.getResponse().getContentAsString();
		assertEquals(outputInJson, expectedJson);
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		Mockito.verify(internalService).getAllBooking();
	}

	/**
	 * {@link InternalController#deleteBooking(int)}
	 * @throws Exception 
	 */
	@Test
	public void deleteBookingTest() throws Exception {		
		String URI ="/booking/delete/1";
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete(URI)).andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		Mockito.verify(internalService).deleteBooking(id);
	}
	
	/**
	 * {@link InternalController#billingAndBooking(com.booking.common.BilliingAndBookingRequest)}
	 * @throws Exception 
	 */
	@Test
	public void billingAndBookingTest() throws Exception {
		Mockito.when(internalService.billingAndBooking(Mockito.any(BilliingAndBookingRequest.class))).thenReturn(billingAndBookingResponse);
		
		String URI = "/billing/booking";
		
		String inputJson = this.mapToJson(billiingAndBookingRequest);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).contentType(MediaType.APPLICATION_JSON).content(inputJson);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}
	
	/**
	 * converts POJO into JSON
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
