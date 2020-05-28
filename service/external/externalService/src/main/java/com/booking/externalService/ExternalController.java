package com.booking.externalService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.booking.common.Hotel;
import com.booking.internalClient.BookingClient;

/**
 * @author Rachana Sharma The ExternalController
 */
@RestController
public class ExternalController {
	@Autowired
	ExternalService externalService;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	BookingClient bookingCliet;

	/**
	 * @return List of Hotels
	 */
	@GetMapping("/hotel/get/ec")
	public List<Hotel> getAllHotelES() {
		return externalService.getAllHotelES();
	}

	/**
	 * @param hotel
	 * @return saves new Hotels
	 */
	@PostMapping("/hotel/save/ec")
	public int saveHotelES(@RequestBody Hotel hotel) {
		return externalService.saveHotelES(hotel);
	}
}
