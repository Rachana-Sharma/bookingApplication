package com.booking.internalmodel;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.util.Date;

import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.booking.externalservice.DatabaseConfig;

/**
 * RoomRepositoryTest
 * 
 * @author Rachana Sharma
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DatabaseConfig.class},loader= AnnotationConfigContextLoader.class)
@DataJpaTest
public class RoomRepositoryTest {

	/**
	 * defining and initializing RoomRepository object
	 */
	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private ApplicationContext applicationContext;
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
	@Autowired
    private TestEntityManager entityManager;

	/**
	 * sets up all the values and is executed before the actual test cases runs
	 * 
	 * @throws ParseException
	 */
	/*@BeforeEach
	public void setUp() throws ParseException {
		MockitoAnnotations.initMocks(this);MockitoAnnotations.initMocks(this);
		sDate = new Date(2020, 7, 22);
		eDate = new Date(2020, 7, 24);
		roomType = "SINGLE";

		roomEntity = new RoomEntity();
		roomEntity.setRoomId(1);
		roomEntity.setRoomPrice(6000);
		roomEntity.setRoomStatus("AVAILABLE");
		roomEntity.setRoomType("SINGLE");
	}*/

	/**
	 * Test findRommByDate method
	 */
	@Test
	public void findRommByDateTest() throws ParseException {
		sDate = new Date(2020, 7, 22);
		eDate = new Date(2020, 7, 24);
		roomType = "SINGLE";

		roomEntity = new RoomEntity();
		roomEntity.setRoomId(1);
		roomEntity.setRoomPrice(6000);
		roomEntity.setRoomStatus("AVAILABLE");
		roomEntity.setRoomType("SINGLE");
		this.entityManager.persist(roomEntity);
		// int id = roomRepository.findRoomByDate(Mockito.any(Date.class),
		// Mockito.any(Date.class), Mockito.anyString());
		int id1 = this.roomRepository.findRoomByDate(sDate, eDate, roomType);
		assertNotNull(id1);
	}
}
