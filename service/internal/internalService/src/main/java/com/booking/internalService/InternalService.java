package com.booking.internalService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.common.BillingRequest;
import com.booking.common.BookingModel;
import com.booking.common.BookingRequest;
import com.booking.common.BookingResponse;
import com.booking.common.CustomerModel;
import com.booking.common.CustomerResponse;
import com.booking.common.RoomModel;
import com.booking.common.RoomResponse;
import com.booking.internalModel.BookingEntity;
import com.booking.internalModel.BookingRepository;
import com.booking.internalModel.CustomerEntity;
import com.booking.internalModel.CustomerRepository;
import com.booking.internalModel.RoomEntity;
import com.booking.internalModel.RoomRepository;

/**
 * @author Rachana Sharma The InternalService
 */
@Service
public class InternalService {

	/**
	 * RoomRepository
	 */
	@Autowired
	RoomRepository roomRepository;

	RoomEntity roomEntity;
	/**
	 * CustomerRepository
	 */
	@Autowired
	CustomerRepository customerRepository;

	CustomerEntity customerEntity;
	/**
	 * BookingRepository
	 */
	@Autowired
	BookingRepository bookingRepository;

	BookingEntity bookingEntity;

	/**
	 * returns all rooms 
	 * @return roomResponse
	 */
	public RoomResponse getAllRoom() {
		List<RoomEntity> roomList = (List<RoomEntity>) roomRepository.findAll();
		List<RoomModel> list = new ArrayList<RoomModel>();
		RoomModel roomModel = null;
		for (int i = 0; i < roomList.size(); i++) {
			roomModel = new RoomModel();
			roomModel.setRoomId(roomList.get(i).getRoomId());
			roomModel.setRoomPrice(roomList.get(i).getRoomPrice());
			roomModel.setRoomStatus(roomList.get(i).getRoomStatus());
			roomModel.setRoomType(roomList.get(i).getRoomType());
			list.add(roomModel);
		}
		RoomResponse roomResponse = new RoomResponse();
		roomResponse.setRoomResponse(list);
		return roomResponse;
	}

	/**
	 * returns all customer
	 * @return customerList
	 */
	public CustomerResponse getAllCustomer() {
		List<CustomerEntity> customerList = (List<CustomerEntity>) customerRepository.findAll();
		List<CustomerModel> list = new ArrayList<CustomerModel>();
		CustomerResponse customerResponse = new CustomerResponse();
		CustomerModel customerModel = new CustomerModel();
		for (int i = 0; i < customerList.size(); i++) {
			customerModel.setCustomerId(customerList.get(i).getCustomerId());
			customerModel.setCustomerName(customerList.get(i).getCustomerName());
			list.add(customerModel);
		}
		customerResponse.setCustomerResponse(list);
		return customerResponse;
	}

	/**
	 * returns all booking
	 * @return bookingResponse
	 */
	public BookingResponse getAllBooking() {
		List<BookingEntity> bookingList = (List<BookingEntity>) bookingRepository.findAll();
		List<BookingModel> list = new ArrayList<BookingModel>();
		BookingModel bookingModel = new BookingModel();
		for (int i = 0; i < bookingList.size(); i++) {
			bookingModel.setBookingId(bookingList.get(i).getBookingId());
			bookingModel.setBreakfast(bookingList.get(i).getBreakfast());
			bookingModel.setTotalCharge(bookingList.get(i).getTotalCharge());
			bookingModel.setStartDate(bookingList.get(i).getStartDate());
			bookingModel.setEndDate(bookingList.get(i).getEndDate());
			list.add(bookingModel);
		}
		BookingResponse bookingResponse = new BookingResponse();
		bookingResponse.setBookingResponse(list);
		return bookingResponse;
	}
	/**
	 * saves new booking 
	 * @param bookingRequest
	 * @return booking Id
	 */
	public int saveBooking(BookingRequest bookingRequest) {
		bookingEntity = new BookingEntity();
		customerEntity = new CustomerEntity();
		bookingEntity.setBookingId(bookingRequest.getBookingId());
		customerEntity.setCustomerId(bookingRequest.getCustomerId());
		customerEntity.setCustomerName(bookingRequest.getCustomerName());
		bookingEntity.setBreakfast(bookingRequest.getBreakfast());
		bookingEntity.setStartDate(bookingRequest.getStartDate());
		bookingEntity.setEndDate(bookingRequest.getEndDate());
		bookingRepository.save(bookingEntity);
		customerRepository.save(customerEntity);
		return bookingEntity.getBookingId();
	}

	/**
	 * get room by id
	 * @param id
	 * @return saved values from repository against the given id
	 */
	public RoomEntity getRoomById(int id) {
		return roomRepository.findById(id).get();
	}

	/**
	 * delete booking by id
	 * @param id to delete from repository against given id
	 */
	public void deleteBooking(int id) {
		bookingRepository.deleteById(id);
	}

	/**
	 * creates a bill against given booking details
	 * @param id
	 * @param breakfast
	 * @return totalCharge
	 */
	public double generateBill(BillingRequest billingRequest) {
		double breakfastCharge = 1000;
		double totalCharge = 0;
		roomEntity = new RoomEntity();
		bookingEntity = new BookingEntity();
		roomEntity = roomRepository.findById(billingRequest.getRoomId()).get();
		bookingEntity = bookingRepository.findById(billingRequest.getBookingId()).get();
		if (billingRequest.isBreakfast()) {
			totalCharge = roomEntity.getRoomPrice() + breakfastCharge;
		} else {
			totalCharge = roomEntity.getRoomPrice();
		}
		bookingEntity.setTotalCharge(totalCharge);
		bookingRepository.save(bookingEntity);
		return totalCharge;
	}
}
