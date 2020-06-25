package com.booking.internalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
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
import com.booking.common.RoomResponse;
import com.booking.internalmodel.RoomEntity;

/**
 * @author Rachana Sharma The InternalController
 */
@SpringBootApplication
@ComponentScan("com.booking")
@EnableJpaRepositories(basePackages = "com.booking.internalmodel")
@EnableTransactionManagement
@EntityScan(basePackages = "com.booking.internalmodel")
@RestController
public class InternalController {

	/**
	 * internalService
	 */
	@Autowired
	InternalService internalService;

	/**
	 * returns all rooms
	 * 
	 * @return all rooms
	 */
	@GetMapping("/room")
	public RoomResponse getAllRoom() {
		return internalService.getAllRoom();
	}

	/**
	 * returns all customer
	 * 
	 * @return List of all customer
	 */
	@GetMapping("/customer")
	public CustomerResponse getAllCustomer() {
		return internalService.getAllCustomer();
	}

	/**
	 * get room by id
	 * 
	 * @param id
	 * @return saved details against given id
	 */
	@GetMapping("/room/{id}")
	public RoomEntity getRoomById(@PathVariable("id") int id) {
		return internalService.getRoomById(id);
	}

	/**
	 * delete booking by id
	 * 
	 * @param id delete from repository against given id
	 */
	@DeleteMapping("/booking/delete/{id}")
	public void deleteBooking(@PathVariable("id") int id) {
		internalService.deleteBooking(id);
	}

	/**
	 * returns all booking
	 * 
	 * @return List of all booking
	 */
	@GetMapping("/booking")
	public BookingResponse getAllBooking() {
		return internalService.getAllBooking();
	}

	/**
	 * save booking and generate bill
	 * 
	 * @param bookingRequest
	 * @return total charge
	 */
	@PostMapping("/billing/booking")
	public BillingAndBookingResponse billingAndBooking(@RequestBody BilliingAndBookingRequest bookingRequest) {
		return internalService.billingAndBooking(bookingRequest);
	}

	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(InternalController.class, args);
	}

}
