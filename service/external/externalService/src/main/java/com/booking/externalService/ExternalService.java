package com.booking.externalService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.common.Hotel;
import com.booking.internalClient.BookingClient;

/**
 * @author Rachana Sharma The ExternalService
 */
@Service
public class ExternalService {

	@Autowired
	BookingClient bookingClient;

	public List<Hotel> getAllHotelES() {
		return bookingClient.getAllHotelClient();
	}

	public int saveHotelES(Hotel hotel) {
		return bookingClient.saveHotelClient(hotel);
	}
}
