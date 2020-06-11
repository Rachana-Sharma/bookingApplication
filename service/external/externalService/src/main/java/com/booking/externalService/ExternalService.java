package com.booking.externalService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.common.BillingRequest;
import com.booking.common.BookingRequest;
import com.booking.common.CustomerResponse;
import com.booking.common.RoomResponse;
import com.booking.internalClient.GenerateBillClient;
import com.booking.internalClient.GetBookingClient;
import com.booking.internalClient.GetCustomerClient;
import com.booking.internalClient.GetRoomClient;
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
	GetRoomClient getRoomClient;
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
	 * @return roomList to add new room to the ArrayList
	 */
	public List<RoomResponse> getAllRoom() {
		return getRoomClient.getAllRoomClient();

	}

	/**
	 * @return customerList to add new customer to the ArrayList
	 */
	public List<CustomerResponse> getAllCustomer() {
		return getCustomerClient.getAllCustomerClient();

	}

	/**
	 * @param bookingRequest
	 * @return List<BookingRequest>
	 */
	public List<BookingRequest> getBooking() {
		return getBookingClient.getAllBookingClient();
	}

	/**
	 * @param bookingRequest
	 * @return int
	 */
	public int saveBooking(BookingRequest bookingRequest) {
		return saveBookingClient.saveBookingClient(bookingRequest);
	}

	/**
	 * @param id
	 * @return saved values from repository against the given id
	 */
	public RoomResponse getRoomById(int id) {
		return getRoomClient.getRoomByIdClient(id);
	}

	/**
	 * @param id
	 */
	public void deleteBooking(int id) {
		getRoomClient.deleteBookingClient(id);
	}

	/**
	 * @param billingRequest
	 * @return
	 */
	public double generateBill(BillingRequest billingRequest) {
		return generateBillClient.generateBillClientMethod(billingRequest);
	}
}
