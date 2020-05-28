package com.booking.internalClient;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.booking.common.Hotel;

/**
 * @author Rachana Sharma The BookingClient
 */
public class BookingClient {

	/**
	 * RestTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * @return myList getAllHotelClient method to get list of all clients
	 */
	public List<Hotel> getAllHotelClient() {
		ParameterizedTypeReference<List<Hotel>> hotel = new ParameterizedTypeReference<List<Hotel>>() {
		};

		ResponseEntity<List<Hotel>> response = restTemplate.exchange("http://localhost:8080/hotel/get", HttpMethod.GET,
				null, hotel);
		List<Hotel> myList = response.getBody();
		return myList;
	}

	/**
	 * @param hotel
	 * @return result saveHotelClient method to save new hotel
	 */
	public int saveHotelClient(Hotel hotel) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Hotel> entity = new HttpEntity<Hotel>(hotel, headers);
		int result = restTemplate.exchange("http://localhost:8080/hotel/save", HttpMethod.POST, entity, Integer.class)
				.getBody();
		return result;
	}
}
