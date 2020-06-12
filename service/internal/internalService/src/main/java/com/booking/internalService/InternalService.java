package com.booking.internalService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.common.BillingRequest;
import com.booking.common.BookingRequest;
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

	RoomEntity roomEntity = new RoomEntity();
	/**
	 * CustomerRepository
	 */
	@Autowired
	CustomerRepository customerRepository;

	CustomerEntity customerEntity = new CustomerEntity();
	/**
	 * BookingRepository
	 */
	@Autowired
	BookingRepository bookingRepository;

	BookingEntity bookingEntity = new BookingEntity();

	
	
	public RoomResponse getAllRoom() {
		List<RoomEntity> roomList=   (List<RoomEntity>) roomRepository.findAll();
		List<RoomModel> list= new ArrayList<RoomModel>();
		
		RoomModel roomModel =  null;
		for(int i=0; i<roomList.size();i++) {
			roomModel	= new RoomModel();
			roomModel.setRoomId(roomList.get(i).getRoomId());
			roomModel.setRoomPrice(roomList.get(i).getRoomPrice());
			roomModel.setRoomStatus(roomList.get(i).getRoomStatus());
			roomModel.setRoomType(roomList.get(i).getRoomType());
			list.add(roomModel);
		}
		//return roomResponse;
		RoomResponse roomResponse=new RoomResponse();
		roomResponse.setRoomResponse(list);
		return roomResponse;
		
		  
	}

	/**
	 * @return customerList
	 */
	public List<CustomerEntity> getAllCustomer() {
		List<CustomerEntity> customerList = new ArrayList<CustomerEntity>();
		customerRepository.findAll().forEach(customer -> customerList.add(customer));
		return customerList;
	}

	/**
	 * @return List<Booking>
	 */
	public List<BookingEntity> getAllBooking() {
		List<BookingEntity> bookingList = new ArrayList<BookingEntity>();
		bookingRepository.findAll().forEach(booking -> bookingList.add(booking));
		return bookingList;
	}

	/**
	 * @param bookingRequest
	 */
	public int saveBooking(BookingRequest bookingRequest) {
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
	 * @param id
	 * @return saved values from repository against the given id
	 */
	public RoomEntity getRoomById(int id) {
		return roomRepository.findById(id).get();

	}

	/**
	 * @param id to delete from repository against given id
	 */
	public void deleteBooking(int id) {
		bookingRepository.deleteById(id);
	}

	/**
	 * @param id
	 * @param breakfast
	 * @return totalCharge
	 */

	public double generateBill(BillingRequest billingRequest) {
		double breakfastCharge = 1000;
		double totalCharge = 0;
		RoomEntity getRoom = roomRepository.findById(billingRequest.getRoomId()).get();
		BookingEntity getBooking = bookingRepository.findById(billingRequest.getBookingId()).get();
		if (billingRequest.isBreakfast() == true) {
			totalCharge = getRoom.getRoomPrice() + breakfastCharge;
		} else {
			totalCharge = getRoom.getRoomPrice();
		}
		getBooking.setTotalCharge(totalCharge);
		bookingRepository.save(getBooking);
		return totalCharge;
	}
}
