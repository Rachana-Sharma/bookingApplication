package com.booking.internalclient;

import org.springframework.beans.factory.annotation.Autowired;
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
	 * Client Method to get room by id
	 * 
	 * @param id
	 * @return roomModel
	 */
	public RoomModel getRoomByIdClient(int id) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<RoomModel> responseEntity = restTemplate.exchange("http://localhost:8088/room/{id}",
				HttpMethod.GET, requestEntity, RoomModel.class, id);
		RoomModel roomModel = responseEntity.getBody();
		return roomModel;
	}

	/**
	 * Client Method to delete booking by id
	 * 
	 * @param id
	 */
	public void deleteBookingClient(int id) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		restTemplate.exchange("http://localhost:8088/booking/delete/{id}", HttpMethod.DELETE, requestEntity, void.class,
				id);
	}
}
