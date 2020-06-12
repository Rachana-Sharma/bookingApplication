package com.booking.internalClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.booking.common.RoomModel;

/**
 * @author Rachana Sharma The BookingClient
 */
public class GetRoomByIdClient {

	/**
	 * RestTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * @param id
	 * @return saved values from repository against the given id via internal
	 *         service
	 */
	public RoomModel getRoomByIdClient(int id) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<RoomModel> responseEntity = restTemplate.exchange("http://localhost:8080/hotel/{id}",
				HttpMethod.GET, requestEntity, RoomModel.class, id);
		RoomModel hotel = responseEntity.getBody();
		return hotel;
	}

	public void deleteBookingClient(int id) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		restTemplate.exchange("http://localhost:8080/hotel/delete/{id}", HttpMethod.DELETE, requestEntity, void.class,
				id);
	}
}
