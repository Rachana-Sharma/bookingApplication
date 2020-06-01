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

import com.booking.common.HotelRequest;
import com.booking.internalModel.Hotel;

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
	@GetMapping("/hotel/get")
	public List<Hotel> getAllHotel() {
		return internalService.getAllHotel();
	}

	/**
	 * @param hotelRequest
	 * @return id of hotel that has been saved to repository
	 */
	@PostMapping("/hotel/save")
	public int saveHotel(@RequestBody HotelRequest hotelRequest) {
		internalService.saveHotel(hotelRequest);
		int id = hotelRequest.getId();
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

}
