package com.booking.externalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.common.BillingRequest;
import com.booking.common.BookingRequest;
import com.booking.common.BookingResponse;
import com.booking.common.CustomerResponse;
import com.booking.common.RoomModel;
import com.booking.common.RoomResponse;
import com.booking.internalClient.GenerateBillClient;
import com.booking.internalClient.GetAllRoomClient;
import com.booking.internalClient.GetBookingClient;
import com.booking.internalClient.GetCustomerClient;
import com.booking.internalClient.GetRoomByIdClient;
import com.booking.internalClient.SaveBookingClient;

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
	SaveBookingClient saveBookingClient;
	/**
	 * GetBookingClient
	 */
	@Autowired
	GetBookingClient getBookingClient;
	/**
	 * GenerateBillClient
	 */
	@Autowired
	GenerateBillClient generateBillClient;
	/**
	 * GetAllRoomClient
	 */
	@Autowired
	GetAllRoomClient getAllRoomClient;

	/**
	 * returns all customer
	 * @return customerList to add new customer to the ArrayList
	 */
	public CustomerResponse getAllCustomer() {
		return getCustomerClient.getAllCustomerClient();

	}

	/**
	 * returns all booking
	 * @param bookingRequest
	 * @return List<BookingRequest>
	 */
	public BookingResponse getBooking() {
		return getBookingClient.getAllBookingClient();
	}

	/**
	 * saves new booking
	 * @param bookingRequest
	 * @return int
	 */
	public int saveBooking(BookingRequest bookingRequest) {
		return saveBookingClient.saveBookingClient(bookingRequest);
	}

	/**
	 * get room by id
	 * @param id
	 * @return saved values from repository against the given id
	 */
	public RoomModel getRoomById(int id) {
		return getRoomClient.getRoomByIdClient(id);
	}

	/**
	 * delete booking by id
	 * @param id
	 */
	public void deleteBooking(int id) {
		getRoomClient.deleteBookingClient(id);
	}

	/**
	 * creates a bill against given booking details
	 * @param billingRequest
	 * @return totalCharge
	 */
	public double generateBill(BillingRequest billingRequest) {
		return generateBillClient.generateBillClientMethod(billingRequest);
	}
	/**
	 * returns all rooms 
	 * @return
	 */
	public RoomResponse getAllRoom() {
		return getAllRoomClient.getAllRoomClientMethod();
	}
}
