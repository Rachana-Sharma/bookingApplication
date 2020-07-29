/*package com.booking.internalmodel;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

//@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
//@ExtendWith(MockitoExtension.class)
//@DataJpaTest
@SpringBootTest
@RunWith(SpringRunner.class)
@EnableJpaRepositories(basePackages = {"com.booking.internalmodel"})
@EntityScan(basePackages = {"com.booking"})
public class RoomRepositoryTest {

	@Autowired
	RoomRepository roomRepository;
	
//	@Autowired
//	TestEntityManager entityManager;
	
	private Date sDate;
	
	private Date eDate;

	@Test
	public void findRommByDateTest() throws ParseException {
		String startDate = "27-07-2020";
		sDate = new SimpleDateFormat("dd-mm-yyyy").parse(startDate);
		String endDate = "28-07-2020";
		eDate = new SimpleDateFormat("dd-mm-yyyy").parse(endDate);
		String roomType = "SINGLE";
	//	BookingEntity bookingEntity = new BookingEntity();
	//	bookingEntity.setStartDate(sDate);
	//	bookingEntity.setEndDate(eDate);
		RoomEntity roomEntity = new RoomEntity();
		roomEntity.setRoomId(1);
		roomEntity.setRoomPrice(6000);
		roomEntity.setRoomStatus("AVAILABLE");
		roomEntity.setRoomType("SINGLE");
		//roomEntity = entityManager.persistAndFlush(roomEntity);
		//Integer id = entityManager.persistAndGetId(roomEntity, Integer.class);
		//assertNotNull(id);
		//roomRepository.findRoomByDate(sDate, eDate, roomType);
		roomRepository.save(roomEntity);
		//assertEquals(e, roomEntity.getRoomId());
		assertNotNull(roomEntity.getRoomId());
	}
	
}*/
