package com.booking.internalclient;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;


public class GetRoomByIdClientTest {

	@InjectMocks
	GetRoomByIdClient getRoomByIdClient;
	
	@Mock
	RestTemplate restTemplate;
	
	private MockRestServiceServer server;
	
	public void setUp() {
		server = MockRestServiceServer.bindTo(restTemplate).build();
	}
	
	@Test
	public void getRoomByIdClientTest() {
		
		//Mockito.when(restTemplate.exchange(Mockito.anyString(),Mockito.<HttpMethod> any(), Mockito.<HttpEntity<?>> any(),Mockito.<Class<?>> any(),Mockito.anyInt())).thenReturn();
		
		server.expect(requestTo("/room/1")).andExpect(method(HttpMethod.GET))
		.andRespond(withSuccess("{\"1\", \"SINGLE\", \"6000\",\"AVAILABLE\"}", MediaType.APPLICATION_JSON));
		
		
	}
}
