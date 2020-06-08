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

import com.booking.common.BookingRequest;
import com.booking.common.CustomerRequest;
import com.booking.common.RoomRequest;
import com.booking.internalModel.Booking;
import com.booking.internalModel.Customer;
import com.booking.internalModel.Hotel;
import com.booking.internalModel.Room;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(InternalController.class, args);
	}

	/**
	 * @return List of all hotel
	 */
	@GetMapping("/room/get")
	public List<Room> getAllRoom() {
		return internalService.getAllRoom();
	}
	
	/**
	 * @return List of all customer
	 */
	@GetMapping("/customer/get")
	public List<Customer> getAllCustomer(){
		return internalService.getAllCustomer();
	}

	/**
	 * @param hotelRequest
	 * @return id 
	 */
	@PostMapping("/room/save")
	public int saveRoom(@RequestBody RoomRequest roomRequest) {
		internalService.saveRoom(roomRequest);
		int id = roomRequest.getRoomId();
		return id;

	}

	/**
	 * @param id
	 * @return saved details against given id
	 */
	@GetMapping("/hotel/{id}")
	public Hotel getHotelById(@PathVariable("id") int id) {
		return internalService.getHotelById(id);
	}

	/**
	 * @param id delete from repository against given id
	 */
	@DeleteMapping("/hotel/delete/{id}")
	public void deleteHotels(@PathVariable("id") int id) {
		internalService.deleteHotel(id);
	}
	/**
	 * @param customerRequest
	 * @return id
	 */
	@PostMapping("/customer/save")
	public int saveCustomer(@RequestBody CustomerRequest customerRequest) {
		internalService.saveCustomer(customerRequest);
		int id = customerRequest.getCustomerId();
		return id;
	}
	/**
	 * @param bookingRequest
	 * @return id
	 */
	@PostMapping("/booking/save")
	public int saveBooking(@RequestBody BookingRequest bookingRequest) {
		internalService.saveBooking(bookingRequest);
		int id = bookingRequest.getBookingId();
		return id;
	}

	/**
	 * @return List of all booking
	 */
	@GetMapping("/booking/get")
	public List<Booking> getAllBooking(){
		return internalService.getAllBooking();
	}
	@GetMapping("/bill/{id}/{breakfast}")
	public double generateBill(@PathVariable("id") int id, @PathVariable("breakfast") String breakfast) {
		return internalService.generateBill(id, breakfast);
	}

}
