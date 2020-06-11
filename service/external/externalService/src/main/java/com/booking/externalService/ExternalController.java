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

import com.booking.common.BillingRequest;
import com.booking.common.BookingRequest;
import com.booking.common.CustomerResponse;
import com.booking.common.RoomResponse;
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

	/**
	 * @return List of room
	 */
	@GetMapping("/room/get/ec")
	public List<RoomResponse> getAllRoom() {
		return externalService.getAllRoom();

	}

	/**
	 * @return List of customer
	 */
	@GetMapping("/customer/get/ec")
	public List<CustomerResponse> getAllCustomer() {
		return externalService.getAllCustomer();
	}

	/**
	 * @return List of customer
	 */
	@GetMapping("/booking/get/ec")
	public List<BookingRequest> getAllBooking() {
		return externalService.getBooking();
	}

	/**
	 * @param bookingRequest
	 * @return int
	 */
	@PostMapping("/booking/save/ec")
	public int saveBooking(@RequestBody BookingRequest bookingRequest) {
		return externalService.saveBooking(bookingRequest);
	}

	/**
	 * @param id
	 * @return saved details against given id
	 */
	@GetMapping("/hotel/ec/{id}")
	public RoomResponse getRoomById(@PathVariable("id") int id) {
		return externalService.getRoomById(id);
	}

	/**
	 * @param id
	 */
	@DeleteMapping("/hotel/delete/ec/{id}")
	public void deleteBooking(@PathVariable("id") int id) {
		externalService.deleteBooking(id);
	}

	/**
	 * @param billingRequest
	 * @return
	 */
	@PostMapping("/bill/get")
	public double generateBill(@RequestBody BillingRequest billingRequest) {
		return externalService.generateBill(billingRequest);
	}

	public static void main(String[] args) {

		SpringApplication.run(ExternalController.class, args);
	}

}
