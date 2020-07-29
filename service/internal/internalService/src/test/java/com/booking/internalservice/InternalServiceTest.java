package com.booking.internalservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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

public class InternalServiceTest {

	@InjectMocks
	InternalService InternalService;

	@Mock
	private RoomRepository roomRepository;

	@Mock
	private BookingRepository bookingRepository;

	@Mock
	private CustomerRepository customerRepository;

	private RoomResponse roomResponse = null;

	private CustomerResponse customerResponse = null;

	private BookingResponse bookingResponse = null;

	private RoomModel roomModel = null;

	private CustomerModel customerModel = null;

	private BookingModel bookingModel = null;

	private RoomEntity roomEntity = null;

	private CustomerEntity customerEntity = null;

	private BookingEntity bookingEntity = null;

	private List<RoomEntity> roomList = null;

	private List<CustomerEntity> customerList = null;

	private List<BookingEntity> bookingList = null;

	private int id;

	private Date sDate;
	private Date eDate;

	/**
	 * sets up all the values and is executed before the actual test cases runs
	 * 
	 * @throws ParseException
	 */
	@BeforeEach
	public void setUp() throws ParseException {
		MockitoAnnotations.initMocks(this);
		id = 1;

		String startDate = "27-07-2020";
		sDate = new SimpleDateFormat("dd-mm-yyyy").parse(startDate);
		String endDate = "28-07-2020";
		eDate = new SimpleDateFormat("dd-mm-yyyy").parse(endDate);

		roomEntity = new RoomEntity();
		roomEntity.setRoomId(1);
		roomEntity.setRoomPrice(5000);
		roomEntity.setRoomStatus("AVAILABLE");
		roomEntity.setRoomType("SINGLE");

		roomModel = new RoomModel(1, "SINGLE", 5000, "AVAILABLE");

		roomResponse = new RoomResponse();
		roomResponse.getRoomResponse().add(roomModel);

		roomList = new ArrayList<RoomEntity>();
		roomList.add(roomEntity);

		customerEntity = new CustomerEntity();
		customerEntity.setCustomerId(1);
		customerEntity.setCustomerName("chandler");
		customerList = new ArrayList<CustomerEntity>();
		customerList.add(customerEntity);
		customerModel = new CustomerModel(1, "chandler");
		customerResponse = new CustomerResponse();
		customerResponse.getCustomerResponse().add(customerModel);

		bookingEntity = new BookingEntity();
		bookingEntity.setBookingId(1);
		bookingEntity.setBreakfast(true);
		bookingEntity.setStartDate(sDate);
		bookingEntity.setEndDate(eDate);
		bookingEntity.setTotalCharge(6000);
		bookingList = new ArrayList<BookingEntity>();
		bookingList.add(bookingEntity);
		bookingModel = new BookingModel(1, true, 6000, sDate, eDate);
		bookingResponse = new BookingResponse();
		bookingResponse.getBookingResponse().add(bookingModel);
	}

	/**
	 * {@link InternalService#getAllRoom()}
	 */
	@Test
	public void getAllRoomTest() {
		Mockito.when((List<RoomEntity>) roomRepository.findAll()).thenReturn(roomList);
		List<RoomEntity> roomList = (List<RoomEntity>) roomRepository.findAll();
		assertEquals(1, roomList.get(0).getRoomId());
		assertEquals("SINGLE", roomList.get(0).getRoomType());
		assertEquals(5000, roomList.get(0).getRoomPrice());
		assertEquals("AVAILABLE", roomList.get(0).getRoomStatus());
		Mockito.verify(roomRepository).findAll();
	}

	/**
	 * {@link InternalService#getAllCustomer()}
	 */
	@Test
	public void getAllCustomerTest() {
		Mockito.when((List<CustomerEntity>) customerRepository.findAll()).thenReturn(customerList);
		List<CustomerEntity> customerList = (List<CustomerEntity>) customerRepository.findAll();
		assertEquals(1, customerList.get(0).getCustomerId());
		assertEquals("chandler", customerList.get(0).getCustomerName());
		Mockito.verify(customerRepository).findAll();
	}

	/**
	 * {@link InternalService#getAllBooking()}
	 */
	@Test
	public void getAllBookingTest() {
		Mockito.when((List<BookingEntity>) bookingRepository.findAll()).thenReturn(bookingList);
		List<BookingEntity> bookingList = (List<BookingEntity>) bookingRepository.findAll();
		assertEquals(1, bookingList.get(0).getBookingId());
		assertEquals(true, bookingList.get(0).isBreakfast());
		assertEquals(sDate, bookingList.get(0).getStartDate());
		assertEquals(eDate, bookingList.get(0).getEndDate());
		assertEquals(6000, bookingList.get(0).getTotalCharge());
		Mockito.verify(bookingRepository).findAll();
	}

	/**
	 * {@link InternalService#getRoomById(int)()}
	 */
	@Test
	public void getRoomByIdTest() {
		Mockito.when(roomRepository.findById(id)).thenReturn(Optional.of(roomEntity));
		RoomEntity roomEntity = roomRepository.findById(1).get();
		assertEquals(1, roomEntity.getRoomId());
		assertEquals(5000, roomEntity.getRoomPrice());
		assertEquals("AVAILABLE", roomEntity.getRoomStatus());
		assertEquals("SINGLE", roomEntity.getRoomType());
		Mockito.verify(roomRepository).findById(id);
	}
	
	/**
	 * {@link InternalService#deleteBooking(int)}
	 */
	@Test
	public void deleteBookingTest() {
		bookingRepository.deleteById(id);
		Mockito.verify(bookingRepository).deleteById(id);
	}
	
	/**
	 * {@link InternalService#billingAndBooking(com.booking.common.BilliingAndBookingRequest)}
	 */
	@Test
	public void billingAndBookingTest() {
		Mockito.when(bookingRepository.save(Mockito.any(BookingEntity.class))).thenReturn(bookingEntity);
		Mockito.when(customerRepository.save(Mockito.any(CustomerEntity.class))).thenReturn(customerEntity);
	}
}
