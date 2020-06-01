package com.booking.externalService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.booking.common.HotelRequest;
import com.booking.internalClient.BookingClient;

/**
 * @author Rachana Sharma The ExternalController
 */
@SpringBootApplication
@ComponentScan("com.booking")
@RestController
public class ExternalController {
	/**
	 * ExternalService
	 */
	@Autowired
	ExternalService externalService;
	/**
	 * RestTemplate
	 */
	@Autowired
	RestTemplate restTemplate;
	/**
	 * BookingClient
	 */
	@Autowired
	BookingClient bookingCliet;

	public static void main(String[] args) {

		SpringApplication.run(ExternalController.class, args);
	}

	/**
	 * @return List of Hotels
	 */
	@GetMapping("/hotel/get/ec")
	public List<HotelRequest> getAllHotelES() {
		return externalService.getAllHotelES();
	}

	/**
	 * @param hotel
	 * @return saves new Hotels
	 */
	@PostMapping("/hotel/save/ec")
	public int saveHotelES(@RequestBody HotelRequest hotel) {
		return externalService.saveHotelES(hotel);
	}

	/**
	 * @param id
	 * @return saved details against given id
	 */
	@GetMapping("/hotel/ec/{id}")
	public HotelRequest getHotelByIdES(@PathVariable("id") int id) {
		return externalService.getHotelByIdES(id);
	}

	/**
	 * @param id
	 */
	@DeleteMapping("/hotel/delete/ec/{id}")
	public void deleteHotelES(@PathVariable("id") int id) {
		externalService.deleteHotelES(id);
	}

}
