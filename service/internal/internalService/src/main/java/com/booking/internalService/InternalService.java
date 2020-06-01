package com.booking.internalService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.common.HotelRequest;
import com.booking.internalModel.Hotel;
import com.booking.internalModel.HotelRepository;

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

	Hotel hotel = new Hotel();

	/**
	 * @return hotelList to add new hotel to the ArrayList
	 */
	public List<Hotel> getAllHotel() {
		List<Hotel> hotelList = new ArrayList<Hotel>();
		hotelRepository.findAll().forEach(hotel -> hotelList.add(hotel));
		return hotelList;
	}

	/**
	 * @param HotelRequest
	 */
	public void saveHotel(HotelRequest hotelRequest) {
		hotel.setId(hotelRequest.getId());
		hotel.setName(hotelRequest.getName());
		hotelRepository.save(hotel);
	}

	/**
	 * @param id
	 * @return saved values from repository against the given id
	 */
	public Hotel getHotelById(int id) {
		return hotelRepository.findById(id).get();

	}

	/**
	 * @param id to delete from repository against given id
	 */
	public void deleteHotel(int id) {
		hotelRepository.deleteById(id);
	}
}
