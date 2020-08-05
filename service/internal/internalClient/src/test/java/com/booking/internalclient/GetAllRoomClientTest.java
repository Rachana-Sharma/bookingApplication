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
import org.springframework.web.client.RestTemplate;

import com.booking.common.BilliingAndBookingRequest;
import com.booking.common.RoomModel;
import com.booking.common.RoomResponse;

/**
 * GetAllRoomClientTest
 * 
 * @author Rachana Sharma
 */
public class GetAllRoomClientTest {

	/**
	 * GetAllRoomClient
	 */
	@InjectMocks
	GetAllRoomClient getAllRoomClient;

	/**
	 * RestTemplate
	 */
	@Mock
	private RestTemplate restTemplate;

	/**
	 * defining and initializing RoomModel
	 */
	private RoomModel roomModel = null;

	/**
	 * defining and initializing RoomResponse
	 */
	private RoomResponse roomResponse = null;

	/**
	 * sets up all the values and is executed before the actual test cases runs
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		roomModel = new RoomModel(1, "SINGLE", 5000, "AVAILABLE");
		roomResponse = new RoomResponse();
		roomResponse.getRoomResponse().add(roomModel);
	}

	/**
	 * Tests billingAndBookingClientMethod
	 * {@link GetAllRoomClient#getAllRoomClientMethod()}
	 */
	@Test
	public void getAllRoomClientMethodTest() {

		ResponseEntity<RoomResponse> responseEntity = new ResponseEntity<RoomResponse>(roomResponse, HttpStatus.OK);
		Mockito.when(restTemplate.exchange(Matchers.anyString(), Matchers.any(HttpMethod.class),
				Matchers.<HttpEntity<?>>any(), Matchers.<Class<RoomResponse>>any())).thenReturn(responseEntity);

		RoomResponse returnedRoomResponse = getAllRoomClient.getAllRoomClientMethod();

		assertEquals(roomResponse.getRoomResponse().get(0).getRoomId(),
				returnedRoomResponse.getRoomResponse().get(0).getRoomId());
		assertEquals(roomResponse.getRoomResponse().get(0).getRoomPrice(),
				returnedRoomResponse.getRoomResponse().get(0).getRoomPrice());
		assertEquals(roomResponse.getRoomResponse().get(0).getRoomStatus(),
				returnedRoomResponse.getRoomResponse().get(0).getRoomStatus());
		assertEquals(roomResponse.getRoomResponse().get(0).getRoomType(),
				returnedRoomResponse.getRoomResponse().get(0).getRoomType());

		Mockito.verify(restTemplate).exchange(Matchers.anyString(), Matchers.any(HttpMethod.class),
				Matchers.<HttpEntity<?>>any(), Matchers.<Class<RoomResponse>>any());
	}
}
