
package com.booking.internalmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath*:resources/invoices-context.xml",
		"classpath*:resources/invoices-int-schema.xml" })
public class RoomRepositoryTest {

	@InjectMocks
	RoomRepository roomRepository;

	private Date sDate;

	private Date eDate;

	private RoomEntity roomEntity;

	@Test
	public void findRommByDateTest() throws ParseException {
		String startDate = "27-07-2020";
		sDate = new SimpleDateFormat("dd-mm-yyyy").parse(startDate);
		String endDate = "28-07-2020";
		eDate = new SimpleDateFormat("dd-mm-yyyy").parse(endDate);
		String roomType = "SINGLE";

		roomEntity = new RoomEntity();
		roomEntity.setRoomId(1);
		roomEntity.setRoomPrice(6000);
		roomEntity.setRoomStatus("AVAILABLE");
		roomEntity.setRoomType("SINGLE");

		Mockito.when(
				roomRepository.findRoomByDate(Mockito.any(Date.class), Mockito.any(Date.class), Mockito.anyString()))
				.thenReturn(roomEntity.getRoomId());
		int id = roomRepository.findRoomByDate(Mockito.any(Date.class), Mockito.any(Date.class), Mockito.anyString());
		assertEquals(1, id);
	}

}
