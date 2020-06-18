package com.booking.internalClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.booking.common.RoomResponse;

/**
 * The GetAllRoomClient
 * 
 * @author Rachana Sharma
 *
 */
public class GetAllRoomClient {
	/**
	 * RestTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Client Method to get all rooms
	 * 
	 * @return roomResponse
	 */
	public RoomResponse getAllRoomClientMethod() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<RoomResponse> responseEntity = restTemplate.exchange("http://localhost:8080/room",
				HttpMethod.GET, requestEntity, RoomResponse.class);
		RoomResponse roomResponse = responseEntity.getBody();
		return roomResponse;
	}
}
