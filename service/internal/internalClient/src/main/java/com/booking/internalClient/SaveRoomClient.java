package com.booking.internalClient;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.booking.common.RoomRequest;

public class SaveRoomClient {

	/**
	 * RestTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * @param hotel
	 * @return result saveHotelClient method to save new hotel
	 */
	public int saveRoomClient(RoomRequest roomRequest) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<RoomRequest> entity = new HttpEntity<RoomRequest>(roomRequest, headers);
		int result = restTemplate.exchange("http://localhost:8080/room/save", HttpMethod.POST, entity, Integer.class)
				.getBody();
		return result;
	}
}
