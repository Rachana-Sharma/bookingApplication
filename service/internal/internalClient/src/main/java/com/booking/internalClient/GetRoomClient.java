package com.booking.internalClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.booking.common.RoomResponse;

/**
 * @author Rachana Sharma The BookingClient
 */
public class GetRoomClient {

	/**
	 * RestTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * @return myList getAllHotelClient method to get list of all clients
	 */
	public List<RoomResponse> getAllRoomClient() {
		ParameterizedTypeReference<List<RoomResponse>> room = new ParameterizedTypeReference<List<RoomResponse>>() {
		};

		ResponseEntity<List<RoomResponse>> response = restTemplate.exchange("http://localhost:8080/room/get",
				HttpMethod.GET, null, room);
		List<RoomResponse> myList = response.getBody();
		return myList;
	}

	/**
	 * @param id
	 * @return saved values from repository against the given id via internal
	 *         service
	 */
	public RoomResponse getRoomByIdClient(int id) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<RoomResponse> responseEntity = restTemplate.exchange("http://localhost:8080/hotel/{id}",
				HttpMethod.GET, requestEntity, RoomResponse.class, id);
		RoomResponse hotel = responseEntity.getBody();
		return hotel;
	}

	public void deleteBookingClient(int id) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		restTemplate.exchange("http://localhost:8080/hotel/delete/{id}", HttpMethod.DELETE, requestEntity, void.class,
				id);
	}
}
