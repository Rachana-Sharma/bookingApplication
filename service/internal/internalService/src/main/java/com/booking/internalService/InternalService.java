package com.booking.internalService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.common.BookingRequest;
import com.booking.common.CustomerRequest;
import com.booking.common.RoomRequest;
import com.booking.internalModel.BookingEntity;
import com.booking.internalModel.BookingRepository;
import com.booking.internalModel.CustomerEntity;
import com.booking.internalModel.CustomerRepository;
import com.booking.internalModel.Hotel;
import com.booking.internalModel.HotelRepository;
import com.booking.internalModel.RoomEntity;
import com.booking.internalModel.RoomRepository;

/**
 * @author Rachana Sharma The InternalService
 */
@Service
public class InternalService {

	/**
	 * HotelRepository
	 */
	@Autowired
	HotelRepository hotelRepository;

	Hotel hotel = new Hotel();
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
	/**
	 * @return hotelList 
	 */
	public List<RoomEntity> getAllRoom() {
		List<RoomEntity> roomList = new ArrayList<RoomEntity>();
		roomRepository.findAll().forEach(room -> roomList.add(room));
		return roomList;
	}
	
	/**
	 * @return customerList
	 */
	public List<CustomerEntity> getAllCustomer(){
		List<CustomerEntity> customerList = new ArrayList<CustomerEntity>();
		customerRepository.findAll().forEach(customer -> customerList.add(customer));
		return customerList;
		}

	/**
	 * @param HotelRequest
	 */
	public int saveRoom(RoomRequest roomRequest) {
		roomEntity.setRoomId(roomRequest.getRoomId());
		roomEntity.setRoomType(roomRequest.getRoomType());
		roomEntity.setRoomPrice(roomRequest.getRoomPrice());
		roomEntity.setRoomStatus(roomRequest.getRoomStatus());
		roomRepository.save(roomEntity);
		return roomEntity.getRoomId();
	}
	
	/**
	 * @return List<Booking>
	 */
	public List<BookingEntity> getAllBooking(){
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
	public Hotel getHotelById(int id) {
		return hotelRepository.findById(id).get();

	}

	/**
	 * @param id to delete from repository against given id
	 */
	public void deleteBooking(int id) {
		bookingRepository.deleteById(id);
	}
	/**
	 * @param customerRequest
	 */
	public void saveCustomer(CustomerRequest customerRequest) {
		customerEntity.setCustomerId(customerRequest.getCustomerId());
		customerEntity.setCustomerName(customerRequest.getCustomerName());
		customerRepository.save(customerEntity);
	}
	
	/**
	 * @param id
	 * @param breakfast
	 * @return totalCharge
	 */
	public double generateBill(int id,String breakfast) {
		String addBreakfast = "yes";
		double breakfastCharge = 1000;
		double totalCharge= 0;
		
		RoomEntity getRoom = roomRepository.findById(id).get();
		
		if(breakfast.equals(addBreakfast)) {
			totalCharge = getRoom.getRoomPrice() + breakfastCharge;
					
		}
		else {
			totalCharge = getRoom.getRoomPrice();
		}
		return totalCharge;
		
	}
}
