package com.booking.internalmodel;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * RoomRepositoryTest
 * 
 * @author Rachana Sharma
 */


@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {DatabaseConfig.class},loader = AnnotationConfigContextLoader.class)
public class RoomRepositoryTest {

	/**
	 * defining and initializing RoomRepository object
	 */
	@Autowired
	private RoomRepository roomRepository;

	/**
	 * the start date
	 */
	private Date sDate;

	/**
	 * the end date
	 */
	private Date eDate;
	/**
	 * the room type
	 */
	private String roomType = null;

	/**
	 * defining and initializing RoomEntity object
	 */
	private RoomEntity roomEntity = null;

	/**
	 * sets up all the values and is executed before the actual test cases runs
	 * 
	 * @throws ParseException
	 */
	public void setUp() throws ParseException {

		sDate = new Date(2020, 7, 22);
		eDate = new Date(2020, 7, 24);
		roomType = "SINGLE";

		roomEntity = new RoomEntity();
		roomEntity.setRoomId(1);
		roomEntity.setRoomPrice(6000);
		roomEntity.setRoomStatus("AVAILABLE");
		roomEntity.setRoomType("SINGLE");
	}

	/**
	 * Test findRommByDate method
	 */
	@Test
	public void findRommByDateTest() throws ParseException {

		roomRepository.save(roomEntity);
		// int id = roomRepository.findRoomByDate(Mockito.any(Date.class),
		// Mockito.any(Date.class), Mockito.anyString());
		int id1 = roomRepository.findRoomByDate(sDate, eDate, roomType);
		assertNotNull(id1);
	}
}
