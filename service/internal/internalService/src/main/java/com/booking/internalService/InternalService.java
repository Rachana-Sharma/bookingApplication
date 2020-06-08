package com.booking.internalService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.common.BookingRequest;
import com.booking.common.CustomerRequest;
import com.booking.common.RoomRequest;
import com.booking.internalModel.Booking;
import com.booking.internalModel.BookingRepository;
import com.booking.internalModel.Customer;
import com.booking.internalModel.CustomerRepository;
import com.booking.internalModel.Hotel;
import com.booking.internalModel.HotelRepository;
import com.booking.internalModel.Room;
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
	
	Room room = new Room();
	/**
	 * CustomerRepository
	 */
	@Autowired
	CustomerRepository customerRepository;
	
	Customer customer = new Customer();
	/**
	 * BookingRepository
	 */
	@Autowired
	BookingRepository bookingRepository;
	
	Booking booking = new Booking();
	/**
	 * @return hotelList 
	 */
	public List<Room> getAllRoom() {
		List<Room> roomList = new ArrayList<Room>();
		roomRepository.findAll().forEach(room -> roomList.add(room));
		return roomList;
	}
	
	/**
	 * @return customerList
	 */
	public List<Customer> getAllCustomer(){
		List<Customer> customerList = new ArrayList<Customer>();
		customerRepository.findAll().forEach(customer -> customerList.add(customer));
		return customerList;
		}

	/**
	 * @param HotelRequest
	 */
	public void saveRoom(RoomRequest roomRequest) {
		room.setRoomId(roomRequest.getRoomId());
		room.setRoomType(roomRequest.getRoomType());
		room.setRoomPrice(roomRequest.getRoomPrice());
		room.setRoomStatus(roomRequest.getRoomStatus());
		roomRepository.save(room);
	}
	
	/**
	 * @return List<Booking>
	 */
	public List<Booking> getAllBooking(){
		List<Booking> bookingList = new ArrayList<Booking>();
		bookingRepository.findAll().forEach(booking -> bookingList.add(booking));
		return bookingList;
	}
	
	/**
	 * @param bookingRequest
	 */
	public void saveBooking(BookingRequest bookingRequest) {
		booking.setBookingId(bookingRequest.getBookingId());
		booking.setBreakfast(bookingRequest.getBreakfast());
		booking.setTotalCharge(bookingRequest.getTotalCharge());
		booking.setStartDate(bookingRequest.getStartDate());
		booking.setEndDate(bookingRequest.getEndDate());
		bookingRepository.save(booking);
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
	public void deleteHotel(int id) {
		hotelRepository.deleteById(id);
	}
	/**
	 * @param customerRequest
	 */
	public void saveCustomer(CustomerRequest customerRequest) {
		customer.setCustomerId(customerRequest.getCustomerId());
		customer.setCustomerName(customerRequest.getCustomerName());
		customerRepository.save(customer);
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
		
		Room getRoom = roomRepository.findById(id).get();
		
		if(breakfast.equals(addBreakfast)) {
			totalCharge = getRoom.getRoomPrice() + breakfastCharge;
					
		}
		else {
			totalCharge = getRoom.getRoomPrice();
		}
		return totalCharge;
		
	}
}
