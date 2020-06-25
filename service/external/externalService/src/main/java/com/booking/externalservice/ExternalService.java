package com.booking.externalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.common.BilliingAndBookingRequest;
import com.booking.common.BillingAndBookingResponse;
import com.booking.common.BookingResponse;
import com.booking.common.CustomerResponse;
import com.booking.common.RoomModel;
import com.booking.common.RoomResponse;
import com.booking.internalclient.BillingAndBookingClient;
import com.booking.internalclient.GetAllRoomClient;
import com.booking.internalclient.GetBookingClient;
import com.booking.internalclient.GetCustomerClient;
import com.booking.internalclient.GetRoomByIdClient;

/**
 * @author Rachana Sharma The ExternalService
 */
@Service
public class ExternalService {

	/**
	 * GetRoomClient
	 */
	@Autowired
	GetRoomByIdClient getRoomClient;

	/**
	 * GetCustomerClient
	 */
	@Autowired
	GetCustomerClient getCustomerClient;

	/**
	 * SaveCustomerClient
	 */
	@Autowired
	BillingAndBookingClient saveBookingClient;

	/**
	 * GetBookingClient
	 */
	@Autowired
	GetBookingClient getBookingClient;

	/**
	 * GetAllRoomClient
	 */
	@Autowired
	GetAllRoomClient getAllRoomClient;

	/**
	 * returns all customer
	 * 
	 * @return customerList to add new customer to the ArrayList
	 */
	public CustomerResponse getAllCustomer() {
		return getCustomerClient.getAllCustomerClient();
	}

	/**
	 * returns all booking
	 * 
	 * @param bookingRequest
	 * @return List<BookingRequest>
	 */
	public BookingResponse getBooking() {
		return getBookingClient.getAllBookingClient();
	}

	/**
	 * saves new booking and generates bill
	 * 
	 * @param bookingRequest
	 * @return int
	 */
	public BillingAndBookingResponse billingAndBooking(BilliingAndBookingRequest bookingRequest) {
		return saveBookingClient.billingAndBookingClient(bookingRequest);
	}

	/**
	 * get room by id
	 * 
	 * @param id
	 * @return saved values from repository against the given id
	 */
	public RoomModel getRoomById(int id) {
		return getRoomClient.getRoomByIdClient(id);
	}

	/**
	 * delete booking by id
	 * 
	 * @param id
	 */
	public void deleteBooking(int id) {
		getRoomClient.deleteBookingClient(id);
	}

	/**
	 * returns all rooms
	 * 
	 * @return
	 */
	public RoomResponse getAllRoom() {
		return getAllRoomClient.getAllRoomClientMethod();
	}
}
