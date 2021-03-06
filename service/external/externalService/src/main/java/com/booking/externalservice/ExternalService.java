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
import com.booking.internalclient.DeleteBookingByIdClient;
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
	private GetRoomByIdClient getRoomClient;

	/**
	 * GetCustomerClient
	 */
	@Autowired
	private GetCustomerClient getCustomerClient;

	/**
	 * SaveCustomerClient
	 */
	@Autowired
	private BillingAndBookingClient saveBookingClient;

	/**
	 * GetBookingClient
	 */
	@Autowired
	private GetBookingClient getBookingClient;

	/**
	 * GetAllRoomClient
	 */
	@Autowired
	private GetAllRoomClient getAllRoomClient;
	
	/**
	 * DeleteBookingByIdClient
	 */
	@Autowired
	private DeleteBookingByIdClient deleteBookingByIdClient;

	/**
	 * returns all customer
	 * 
	 * @return customerList to add new customer to the ArrayList
	 */
	public CustomerResponse getAllCustomer() {
		return getCustomerClient.getAllCustomerClientMethod();
	}

	/**
	 * returns all booking
	 * 
	 * @param bookingRequest
	 * @return List<BookingRequest>
	 */
	public BookingResponse getBooking() {
		return getBookingClient.getAllBookingClientMethod();
	}

	/**
	 * saves new booking and generates bill
	 * 
	 * @param bookingRequest
	 * @return BillingAndBookingResponse
	 */
	public BillingAndBookingResponse billingAndBooking(BilliingAndBookingRequest bookingRequest) {
		return saveBookingClient.billingAndBookingClientMethod(bookingRequest);
	}

	/**
	 * get room by id
	 * 
	 * @param id
	 * @return saved values from repository against the given id
	 */
	public RoomModel getRoomById(int id) {
		return getRoomClient.getRoomByIdClientMethod(id);
	}

	/**
	 * delete booking by id
	 * 
	 * @param id
	 */
	public void deleteBooking(int id) {
		deleteBookingByIdClient.deleteBookingClient(id);
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
