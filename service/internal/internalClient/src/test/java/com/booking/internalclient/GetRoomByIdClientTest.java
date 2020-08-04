package com.booking.internalclient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.booking.common.RoomModel;

public class GetRoomByIdClientTest {

	@InjectMocks
	private GetRoomByIdClient getRoomByIdClient = new GetRoomByIdClient();

	@Mock
	private RestTemplate restTemplate;

	private RoomModel roomModel = null;
	/**
	 * baseUrl
	 */
	private String baseUrl ="http://localhost:8088" ;

	@BeforeEach
	public void setUp() {
				MockitoAnnotations.initMocks(this);
		// ReflectionTestUtils.setField(getRoomByIdClient, "baseUrl",
		// "baseUrl/room/{id}");
				roomModel = new RoomModel(1, "SINGLE", 5000, "AVAILABLE");
	}

	@Test
	public void getRoomByIdClientTest() {

	
			Mockito.when(restTemplate.exchange(ArgumentMatchers.eq(baseUrl+"/room/{id}"), ArgumentMatchers.eq(HttpMethod.GET),
				ArgumentMatchers.any(HttpEntity.class), ArgumentMatchers.eq(RoomModel.class), ArgumentMatchers.eq(1)))
				.thenReturn(new ResponseEntity<RoomModel>(roomModel, HttpStatus.OK));

			//Mockito.when(restTemplate.exchange(ArgumentMatchers.eq("baseUrl/room/1"), ArgumentMatchers.eq(HttpMethod.GET),
			//	ArgumentMatchers.any(HttpEntity.class), ArgumentMatchers.eq(RoomModel.class), ArgumentMatchers.eq(1)).getBody())
			//	.thenReturn(roomModel);
		RoomModel returnedRoomModel = getRoomByIdClient.getRoomByIdClientMethod(1); 
		 Assertions.assertEquals( roomModel,RoomModel.class);
	}
}
