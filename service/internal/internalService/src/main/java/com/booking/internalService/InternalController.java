package com.booking.internalService;

import java.util.List;

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

import com.booking.common.BillingRequest;
import com.booking.common.BookingRequest;
import com.booking.common.RoomResponse;
import com.booking.internalModel.BookingEntity;
import com.booking.internalModel.CustomerEntity;
import com.booking.internalModel.RoomEntity;

/**
 * @author Rachana Sharma The InternalController
 */
@SpringBootApplication
@ComponentScan("com.booking")
@EnableJpaRepositories(basePackages = "com.booking.internalModel")
@EnableTransactionManagement
@EntityScan(basePackages = "com.booking.internalModel")
@RestController
public class InternalController {

	/**
	 * internalService
	 */
	@Autowired
	InternalService internalService;

	
	/**
	 * @return all rooms
	 */
	@GetMapping("/room")
	public RoomResponse getAllRoom() {
		return internalService.getAllRoom();
	}

	/**
	 * @return List of all customer
	 */
	@GetMapping("/customer/get")
	public List<CustomerEntity> getAllCustomer() {
		return internalService.getAllCustomer();
	}

	/**
	 * @param id
	 * @return saved details against given id
	 */
	@GetMapping("/hotel/{id}")
	public RoomEntity getRoomById(@PathVariable("id") int id) {
		return internalService.getRoomById(id);
	}

	/**
	 * @param id delete from repository against given id
	 */
	@DeleteMapping("/hotel/delete/{id}")
	public void deleteBooking(@PathVariable("id") int id) {
		internalService.deleteBooking(id);
	}

	/**
	 * @param customerRequest
	 * @return id
	 */

	/**
	 * @param bookingRequest
	 * @return id
	 */
	@PostMapping("/booking/save")
	public int saveBooking(@RequestBody BookingRequest bookingRequest) {
		return internalService.saveBooking(bookingRequest);
	}

	/**
	 * @return List of all booking
	 */
	@GetMapping("/booking/get")
	public List<BookingEntity> getAllBooking() {
		return internalService.getAllBooking();
	}

	/**
	 * @param billingRequest
	 * @return totalCharge
	 */
	@PostMapping("/bill")
	public double generateBill(@RequestBody BillingRequest billingRequest) {
		return internalService.generateBill(billingRequest);
	}

	public static void main(String[] args) {
		SpringApplication.run(InternalController.class, args);
	}

}
