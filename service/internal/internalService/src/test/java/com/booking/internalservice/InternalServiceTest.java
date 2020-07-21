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
		customerEntity.setCustomerName("Chandler");
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

	@Test
	public void getAllRoomTest() {
		Mockito.when((List<RoomEntity>) roomRepository.findAll()).thenReturn(roomList);
		assertEquals(1, roomResponse.getRoomResponse().get(0).getRoomId());
		assertEquals("SINGLE", roomResponse.getRoomResponse().get(0).getRoomType());
		assertEquals(5000, roomResponse.getRoomResponse().get(0).getRoomPrice());
		assertEquals("AVAILABLE", roomResponse.getRoomResponse().get(0).getRoomStatus());
	}

	@Test
	public void getAllCustomerTest() {
		Mockito.when((List<CustomerEntity>) customerRepository.findAll()).thenReturn(customerList);
		assertEquals(1, customerResponse.getCustomerResponse().get(0).getCustomerId());
		assertEquals("chandler", customerResponse.getCustomerResponse().get(0).getCustomerName());
	}

	@Test
	public void getAllBookingTest() {
		Mockito.when((List<BookingEntity>) bookingRepository.findAll()).thenReturn(bookingList);
		assertEquals(1, bookingResponse.getBookingResponse().get(0).getBookingId());
		assertEquals(true, bookingResponse.getBookingResponse().get(0).isBreakfast());
		assertEquals(sDate, bookingResponse.getBookingResponse().get(0).getStartDate());
		assertEquals(eDate, bookingResponse.getBookingResponse().get(0).getEndDate());
		assertEquals(6000, bookingResponse.getBookingResponse().get(0).getTotalCharge());
	}

	@Test
	public void getRoomByIdTest() {
		Mockito.when(roomRepository.findById(id)).thenReturn(Optional.of(roomEntity));
		assertEquals(1, roomEntity.getRoomId());
		assertEquals(5000, roomEntity.getRoomPrice());
		assertEquals("AVAILABLE", roomEntity.getRoomStatus());
		assertEquals("SINGLE", roomEntity.getRoomType());
	}
}
