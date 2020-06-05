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

import com.booking.common.BookingRequest;
import com.booking.common.CustomerRequest;
import com.booking.common.HotelRequest;
import com.booking.common.RoomRequest;
import com.booking.internalClient.GetRoomClient;

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
	GetRoomClient bookingCliet;

	public static void main(String[] args) {

		SpringApplication.run(ExternalController.class, args);
	}

	/**
	 * @return List of room
	 */
	@GetMapping("/room/get/ec")
	public List<RoomRequest> getAllRoomES() {
		return externalService.getAllRoomES();

	}

	/**
	 * @param roomRequest
	 * @return saves new room
	 */
	@PostMapping("/room/save/ec")
	public int saveRoomES(@RequestBody RoomRequest roomRequest) {
		return externalService.saveRoomES(roomRequest);
	}

	/**
	 * @return List of customer
	 */
	@GetMapping("/customer/get/ec")
	public List<CustomerRequest> getAllCustomerES() {
		return externalService.getAllCustomerES();
	}

	/**
	 * @param customerRequest
	 * @return saves new customer
	 */
	@PostMapping("/customer/save/ec")
	public int saveCustomerES(@RequestBody CustomerRequest customerRequest) {
		return externalService.saveCustomerES(customerRequest);
	}

	/**
	 * @return List of customer
	 */
	@GetMapping("/booking/get/ec")
	public List<BookingRequest> getAllBookingES() {
		return externalService.getBookingES();
	}

	/**
	 * @param bookingRequest
	 * @return int
	 */
	@PostMapping("/booking/save/ec")
	public int saveBookingES(@RequestBody BookingRequest bookingRequest) {
		return externalService.saveBookingES(bookingRequest);
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
