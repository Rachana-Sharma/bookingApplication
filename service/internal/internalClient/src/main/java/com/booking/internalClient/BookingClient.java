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

import com.booking.common.HotelRequest;

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
	public List<HotelRequest> getAllHotelClient() {
		ParameterizedTypeReference<List<HotelRequest>> hotel = new ParameterizedTypeReference<List<HotelRequest>>() {
		};

		ResponseEntity<List<HotelRequest>> response = restTemplate.exchange("http://localhost:8080/hotel/get", HttpMethod.GET,
				null, hotel);
		List<HotelRequest> myList = response.getBody();
		return myList;
	}

	/**
	 * @param hotel
	 * @return result saveHotelClient method to save new hotel
	 */
	public int saveHotelClient(HotelRequest hotel) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<HotelRequest> entity = new HttpEntity<HotelRequest>(hotel, headers);
		int result = restTemplate.exchange("http://localhost:8080/hotel/save", HttpMethod.POST, entity, Integer.class)
				.getBody();
		return result;
	}
	
	/**
	 * @param id
	 * @return saved values from repository against the given id via internal se-r-vi-ce-
	 */
	public HotelRequest getHotelByIdClient(int id) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> requestEntity= new HttpEntity<String>(headers);
		ResponseEntity<HotelRequest> responseEntity=restTemplate.exchange("http://localhost:8080/hotel/{id}", HttpMethod.GET, requestEntity, HotelRequest.class,id);
		HotelRequest hotel = responseEntity.getBody();
		return hotel;
	}
	
	public void deleteHotelClient(int id) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> requestEntity= new HttpEntity<String>(headers);
		restTemplate.exchange("http://localhost:8080/hotel/delete/{id}", HttpMethod.DELETE, requestEntity, void.class,id);
	}
}
