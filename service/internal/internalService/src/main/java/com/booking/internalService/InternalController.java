package com.booking.internalService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.booking.common.Hotel;

/**
 * @author Rachana Sharma The InternalController
 */
@RestController
public class InternalController {

	/**
	 * internalService
	 */
	@Autowired
	InternalService internalService;

	/**
	 * @return List of all hotel
	 */
	@GetMapping("/hotel/get")
	public List<Hotel> getAllHotel() {
		return internalService.getAllHotel();
	}

	/**
	 * @param hotel
	 * @return id of hotel that has been saved to repository
	 */
	@PostMapping("/hotel/save")
	public int saveHotel(@RequestBody Hotel hotel) {
		internalService.saveHotel(hotel);
		return hotel.getId();
	}

}
