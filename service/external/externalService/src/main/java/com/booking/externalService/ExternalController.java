package com.booking.externalService;

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

import com.booking.common.BilliingAndBookingRequest;
import com.booking.common.BillingAndBookingResponse;
import com.booking.common.BookingResponse;
import com.booking.common.CustomerResponse;
import com.booking.common.RoomModel;
import com.booking.common.RoomResponse;
import com.booking.internalClient.GetRoomByIdClient;

/**
 * The ExternalController
 * 
 * @author Rachana Sharma
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
	GetRoomByIdClient bookingCliet;

	/**
	 * returns all customer
	 * 
	 * @return List of customer
	 */
	@GetMapping("/customer/get/ec")
	public CustomerResponse getAllCustomer() {
		return externalService.getAllCustomer();
	}

	/**
	 * returns all booking
	 * 
	 * @return List of booking
	 */
	@GetMapping("/booking/get/ec")
	public BookingResponse getAllBooking() {
		return externalService.getBooking();
	}

	/**
	 * saves new booking
	 * 
	 * @param bookingRequest
	 * @return total charge
	 */
	@PostMapping("/billing/booking/ec")
	public BillingAndBookingResponse BillingAndBooking(@RequestBody BilliingAndBookingRequest bookingRequest) {
		return externalService.BillingAndBooking(bookingRequest);
	}

	/**
	 * get room by id
	 * 
	 * @param id
	 * @return saved details against given id
	 */
	@GetMapping("/room/ec/{id}")
	public RoomModel getRoomById(@PathVariable("id") int id) {
		return externalService.getRoomById(id);
	}

	/**
	 * delete booking by id
	 * 
	 * @param id
	 */
	@DeleteMapping("/booking/delete/ec/{id}")
	public void deleteBooking(@PathVariable("id") int id) {
		externalService.deleteBooking(id);
	}

	/**
	 * @return all rooms
	 */
	@GetMapping("/room/response")
	public RoomResponse getAllRoom() {
		return externalService.getAllRoom();
	}

	public static void main(String[] args) {

		SpringApplication.run(ExternalController.class, args);
	}

}
