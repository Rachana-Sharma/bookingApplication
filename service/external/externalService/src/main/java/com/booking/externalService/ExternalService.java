package com.booking.externalService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.common.HotelRequest;
import com.booking.internalClient.BookingClient;

/**
 * @author Rachana Sharma The ExternalService
 */
@Service
public class ExternalService {

	/**
	 * BookingClient
	 */
	@Autowired
	BookingClient bookingClient;

	/**
	 * @return hotelList to add new hotel to the ArrayList
	 */
	public List<HotelRequest> getAllHotelES() {
		return bookingClient.getAllHotelClient();
	}

	/**
	 * @param hotel
	 * @return hotel to save into hotel repository via client
	 */
	public int saveHotelES(HotelRequest hotel) {
		return bookingClient.saveHotelClient(hotel);
	}

	/**
	 * @param id
	 * @return saved values from repository against the given id
	 */
	public HotelRequest getHotelByIdES(int id) {
		return bookingClient.getHotelByIdClient(id);
	}

	/**
	 * @param id
	 */
	public void deleteHotelES(int id) {
		bookingClient.deleteHotelClient(id);
	}
}
