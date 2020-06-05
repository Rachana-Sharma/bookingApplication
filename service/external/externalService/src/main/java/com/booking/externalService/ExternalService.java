package com.booking.externalService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.common.BookingRequest;
import com.booking.common.CustomerRequest;
import com.booking.common.HotelRequest;
import com.booking.common.RoomRequest;
import com.booking.internalClient.GetBookingClient;
import com.booking.internalClient.GetCustomerClient;
import com.booking.internalClient.GetRoomClient;
import com.booking.internalClient.SaveBookingClient;
import com.booking.internalClient.SaveCustomerClient;
import com.booking.internalClient.SaveRoomClient;

/**
 * @author Rachana Sharma The ExternalService
 */
@Service
public class ExternalService {

	/**
	 * GetRoomClient
	 */
	@Autowired
	GetRoomClient getRoomClient;
	/**
	 * GetCustomerClient
	 */
	@Autowired
	GetCustomerClient getCustomerClient;
	/**
	 * GetCustomerClient
	 */
	@Autowired
	SaveRoomClient saveRoomClient;
	/**
	 * SaveCustomerClient
	 */
	@Autowired
	SaveCustomerClient saveCustomerClient;
	/**
	 * SaveCustomerClient
	 */
	@Autowired
	SaveBookingClient saveBookingClient;
	/**
	 * GetBookingClient
	 */
	@Autowired
	GetBookingClient getBookingClient;

	/**
	 * @return roomList to add new room to the ArrayList
	 */
	public List<RoomRequest> getAllRoomES() {
		return getRoomClient.getAllRoomClient();

	}

	/**
	 * @param roomRequest
	 * @return room to save into room repository via client
	 */
	public int saveRoomES(RoomRequest roomRequest) {
		return saveRoomClient.saveRoomClient(roomRequest);
	}

	/**
	 * @return customerList to add new customer to the ArrayList
	 */
	public List<CustomerRequest> getAllCustomerES() {
		return getCustomerClient.getAllCustomerClient();

	}

	/**
	 * @param customerRequest
	 * @return customer to save into customer repository via client
	 */
	public int saveCustomerES(CustomerRequest customerRequest) {
		return saveCustomerClient.saveCustomerClient(customerRequest);
	}

	/**
	 * @param bookingRequest
	 * @return List<BookingRequest>
	 */
	public List<BookingRequest> getBookingES() {
		return getBookingClient.getAllBookingClient();
	}

	/**
	 * @param bookingRequest
	 * @return int
	 */
	public int saveBookingES(BookingRequest bookingRequest) {
		return saveBookingClient.saveBookingClient(bookingRequest);
	}

	/**
	 * @param id
	 * @return saved values from repository against the given id
	 */
	public HotelRequest getHotelByIdES(int id) {
		return getRoomClient.getHotelByIdClient(id);
	}

	/**
	 * @param id
	 */
	public void deleteHotelES(int id) {
		getRoomClient.deleteHotelClient(id);
	}
}
