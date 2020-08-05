package com.booking.internalclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.booking.common.RoomModel;

/**
 * The BookingClient
 * 
 * @author Rachana Sharma
 */
public class GetRoomByIdClient {

	/**
	 * RestTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * baseUrl
	 */
	@Value("${base.url}")
	private String baseUrl;

	/**
	 * Client Method to get room by id
	 * 
	 * @param id
	 * @return roomModel
	 */
	public RoomModel getRoomByIdClientMethod(int id) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<RoomModel> responseEntity = restTemplate.exchange(baseUrl+"/room/{id}",
				HttpMethod.GET, requestEntity, RoomModel.class, id);
		RoomModel roomModel = responseEntity.getBody();
		return roomModel;
	}
}
