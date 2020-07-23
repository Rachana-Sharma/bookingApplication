package com.booking.internalservice;

import static org.junit.Assert.assertEquals;

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

import com.booking.common.BookingModel;
import com.booking.common.BookingResponse;
import com.booking.common.CustomerModel;
import com.booking.common.CustomerResponse;
import com.booking.common.RoomModel;
import com.booking.common.RoomResponse;
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

	private int id;

	private Date sDate;

	private Date eDate;

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
	}

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
	}

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
	}

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
	}

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
	}

	public String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
