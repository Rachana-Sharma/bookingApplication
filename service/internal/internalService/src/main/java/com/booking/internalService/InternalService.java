package com.booking.internalService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.common.Hotel;
import com.booking.common.HotelRepository;

/**
 * @author Rachana Sharma The InternalService
 */
@Service
public class InternalService {

	/**
	 * HotelRepository
	 */
	@Autowired
	HotelRepository hotelRepository;

	/**
	 * @return hotelList to add new hotel to the ArrayList
	 */
	public List<Hotel> getAllHotel() {
		List<Hotel> hotelList = new ArrayList<Hotel>();
		hotelRepository.findAll().forEach(hotel -> hotelList.add(hotel));
		return hotelList;
	}

	/**
	 * @param hotel to save into hotel repository
	 */
	public void saveHotel(Hotel hotel) {
		hotelRepository.save(hotel);
	}
}
