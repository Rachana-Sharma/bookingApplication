package com.booking.externalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.common.BilliingAndBookingRequest;
import com.booking.common.BillingAndBookingResponse;
import com.booking.common.BookingResponse;
import com.booking.common.CustomerResponse;
import com.booking.common.RoomModel;
import com.booking.common.RoomResponse;

/**
 * The ExternalController
 * 
 * @author Rachana Sharma
 */
@SpringBootApplication
@RestController
public class ExternalController {

	/**
	 * ExternalService
	 */
	@Autowired
	private ExternalService externalService;

	/**
	 * returns all customer
	 * 
	 * @return List of customer
	 */
	@GetMapping("/customer")
	public CustomerResponse getAllCustomer() {
		return externalService.getAllCustomer();
	}

	/**
	 * returns all booking
	 * 
	 * @return List of booking
	 */
	@GetMapping("/booking")
	public BookingResponse getAllBooking() {
		return externalService.getBooking();
	}

	/**
	 * saves new booking
	 * 
	 * @param bookingRequest
	 * @return total charge
	 */
	@PostMapping("/billing/booking")
	public BillingAndBookingResponse billingAndBooking(@RequestBody BilliingAndBookingRequest bookingRequest) {
		return externalService.billingAndBooking(bookingRequest);
	}

	/**
	 * get room by id
	 * 
	 * @param id
	 * @return saved details against given id
	 */
	@GetMapping("/room/{id}")
	public RoomModel getRoomById(@PathVariable("id") int id) {
		return externalService.getRoomById(id);
	}

	/**
	 * delete booking by id
	 * 
	 * @param id
	 */
	@DeleteMapping("/delete/booking/{id}")
	public void deleteBooking(@PathVariable("id") int id) {
		externalService.deleteBooking(id);
	}

	/**
	 * @return all rooms
	 */
	@GetMapping("/room")
	public RoomResponse getAllRoom() {
		return externalService.getAllRoom();
	}

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ExternalController.class, args);
	}
}
