package com.booking.internalclient;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

import com.booking.common.RoomModel;

/**
 * GetRoomByIdClientTest
 * 
 * @author Rachana Sharma
 */

public class GetRoomByIdClientTest {

	/**
	 * GetRoomByIdClient
	 */
	@InjectMocks
	private GetRoomByIdClient getRoomByIdClient;

	/**
	 * RestTemplate
	 */
	@Mock
	private RestTemplate restTemplate;

	/**
	 * defining and initializing RoomModel object
	 */
	private RoomModel roomModel = null;

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
		ReflectionTestUtils.setField(this.getRoomByIdClient, "baseUrl", baseUrl);

		roomModel = new RoomModel(1, "SINGLE", 5000, "AVAILABLE");
	}

	/**
	 * Tests getRoomByIdClientMethod
	 */
	@Test
	public void getRoomByIdClientTest() {
		ResponseEntity<RoomModel> responseEntity = new ResponseEntity<RoomModel>(roomModel, HttpStatus.OK);
		Mockito.when(restTemplate.exchange(Matchers.eq(baseUrl + "/room/{id}"), Matchers.eq(HttpMethod.GET),
				Matchers.<HttpEntity<?>>any(), Matchers.<Class<RoomModel>>any(), Matchers.anyInt()))
				.thenReturn(responseEntity);

		RoomModel returnedRoomModel = getRoomByIdClient.getRoomByIdClientMethod(1);

		assertEquals(roomModel.getRoomId(), returnedRoomModel.getRoomId());
		assertEquals(roomModel.getRoomPrice(), returnedRoomModel.getRoomPrice());
		assertEquals(roomModel.getRoomStatus(), returnedRoomModel.getRoomStatus());
		assertEquals(roomModel.getRoomType(), returnedRoomModel.getRoomType());

		Mockito.verify(restTemplate).exchange(Matchers.anyString(), Matchers.any(HttpMethod.class),
				Matchers.<HttpEntity<?>>any(), Matchers.<Class<RoomModel>>any(), Matchers.anyInt());
	}
}
