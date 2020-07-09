package com.booking.internalservice;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.common.BilliingAndBookingRequest;
import com.booking.common.BillingAndBookingResponse;
import com.booking.common.BookingModel;
import com.booking.common.BookingResponse;
import com.booking.common.CustomerModel;
import com.booking.common.CustomerResponse;
import com.booking.common.RoomModel;
import com.booking.common.RoomResponse;
import com.booking.internalmodel.BookingEntity;
import com.booking.internalmodel.BookingRepository;
import com.booking.internalmodel.CustomerEntity;
import com.booking.internalmodel.CustomerRepository;
import com.booking.internalmodel.RoomEntity;
import com.booking.internalmodel.RoomRepository;

/**
 * @author Rachana Sharma The InternalService
 */
@Service
public class InternalService {

	/**
	 * RoomRepository
	 */
	@Autowired
	private RoomRepository roomRepository;

	/**
	 * defining RoomEntity object
	 */
	private RoomEntity roomEntity;

	/**
	 * CustomerRepository
	 */
	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * defining CustomerEntity object
	 */
	private CustomerEntity customerEntity;

	/**
	 * BookingRepository
	 */
	@Autowired
	private BookingRepository bookingRepository;

	/**
	 * defining BookingEntity object
	 */
	private BookingEntity bookingEntity;

	/**
	 * returns all rooms
	 * 
	 * @return roomResponse
	 */
	public RoomResponse getAllRoom() {
		List<RoomEntity> roomList = (List<RoomEntity>) roomRepository.findAll();
		RoomResponse roomResponse = new RoomResponse();
		roomList.forEach(room -> {
			RoomModel roomModel = new RoomModel();
			BeanUtils.copyProperties(room, roomModel);
			roomResponse.getRoomResponse().add(roomModel);
		});
		return roomResponse;
	}

	/**
	 * returns all customer
	 * 
	 * @return customerList
	 */
	public CustomerResponse getAllCustomer() {
		List<CustomerEntity> customerList = (List<CustomerEntity>) customerRepository.findAll();
		CustomerResponse customerResponse = new CustomerResponse();
		customerList.forEach(customer -> {
			CustomerModel customerModel = new CustomerModel();
			BeanUtils.copyProperties(customer, customerModel);
			customerResponse.getCustomerResponse().add(customerModel);
		});
		return customerResponse;
	}

	/**
	 * returns all booking
	 * 
	 * @return bookingResponse
	 */
	public BookingResponse getAllBooking() {
		List<BookingEntity> bookingList = (List<BookingEntity>) bookingRepository.findAll();
		BookingResponse bookingResponse = new BookingResponse();
		bookingList.forEach(booking -> {
			BookingModel bookingModel = new BookingModel();
			BeanUtils.copyProperties(booking, bookingModel);
			bookingResponse.getBookingResponse().add(bookingModel);
		});
		return bookingResponse;
	}

	/**
	 * get room by id
	 * 
	 * @param id
	 * @return saved values from repository against the given id
	 */
	public RoomEntity getRoomById(int id) {
		return roomRepository.findById(id).get();
	}

	/**
	 * delete booking by id
	 * 
	 * @param id to delete from repository against given id
	 */
	public void deleteBooking(int id) {
		bookingEntity = new BookingEntity();
		roomEntity = new RoomEntity();
		bookingEntity = bookingRepository.findById(id).get();
		int roomId = bookingEntity.getRoom().getRoomId();
		bookingRepository.deleteById(id);
		roomRepository.updateStatusById(roomId);
		/*
		 * if (bookingRepository.findById(roomId) == null) {
		 * roomRepository.updateStatusById(roomId); }
		 */
	}

	/**
	 * save booking and generate bill
	 * 
	 * @param bookingRequest
	 * @return
	 */
	public BillingAndBookingResponse billingAndBooking(BilliingAndBookingRequest bookingRequest) {
		double breakfastCharge = 1000;
		double totalCharge = 0;
		String roomStatus = "OCCUPIED";
		roomEntity = new RoomEntity();
		bookingEntity = new BookingEntity();
		customerEntity = new CustomerEntity();
		BillingAndBookingResponse billingAndBookingResponse = new BillingAndBookingResponse();
		//int id=roomRepository.findRoom(bookingRequest.getRoomType());
		int id = roomRepository.findRoomByDate(bookingRequest.getStartDate(),bookingRequest.getEndDate(), bookingRequest.getRoomType());
		// int id=roomRepository.findRoomByDateRange(bookingRequest.getStartDate(),bookingRequest.getEndDate(),bookingRequest.getRoomType());
		roomEntity = roomRepository.findById(id).get();
		if (bookingRequest.isBreakfast()) {
			totalCharge = roomEntity.getRoomPrice() + breakfastCharge;
		} else {
			totalCharge = roomEntity.getRoomPrice();
		}

		BeanUtils.copyProperties(bookingRequest, customerEntity);

		roomEntity.setRoomStatus(roomStatus);
		BeanUtils.copyProperties(bookingRequest, bookingEntity);
		bookingEntity.setTotalCharge(totalCharge);
		bookingEntity.setRoom(roomEntity);
		customerEntity.setBookingEntity(bookingEntity);

		customerRepository.save(customerEntity);
		bookingRepository.save(bookingEntity);

		billingAndBookingResponse.setTotalCharge(totalCharge);
		billingAndBookingResponse.getTotalCharge();
		return billingAndBookingResponse;
	}
}
