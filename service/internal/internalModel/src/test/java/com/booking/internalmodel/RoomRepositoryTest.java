
package com.booking.internalmodel;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

public class RoomRepositoryTest {
	
	@Autowired
	private RoomRepository roomRepository= new RoomRepository() {
		
		@Override
		public <S extends RoomEntity> Iterable<S> saveAll(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends RoomEntity> S save(S entity) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Optional<RoomEntity> findById(Integer id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Iterable<RoomEntity> findAllById(Iterable<Integer> ids) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Iterable<RoomEntity> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean existsById(Integer id) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void deleteById(Integer id) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAll(Iterable<? extends RoomEntity> entities) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void delete(RoomEntity entity) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public void updateStatusById(int roomId) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public int findRoomByDate(Date startDate, Date endDate, String roomType) {
			// TODO Auto-generated method stub
			return 0;
		}
	};
	
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
	private String roomType =null;
	
	private RoomEntity roomEntity = null;
	
	public void setUp() throws ParseException {
		String startDate = "27-08-2020";
		sDate = new SimpleDateFormat("dd-mm-yyyy").parse(startDate);
		String endDate = "28-08-2020";
		eDate = new SimpleDateFormat("dd-mm-yyyy").parse(endDate);
	    roomType = "SINGLE";
		
		roomEntity = new RoomEntity();
		roomEntity.setRoomId(1);
		roomEntity.setRoomPrice(6000);
		roomEntity.setRoomStatus("AVAILABLE");
		roomEntity.setRoomType("SINGLE");
	}
	@Test
	public void findRommByDateTest() throws ParseException {
		
		roomRepository.save(roomEntity);
		//int id = roomRepository.findRoomByDate(Mockito.any(Date.class), Mockito.any(Date.class), Mockito.anyString());
		int id1=roomRepository.findRoomByDate(sDate, eDate, roomType);
		assertNotNull(id1);
	}
	@Test
	public void updateStatusByIdTest() throws ParseException {
		
		roomRepository.save(roomEntity);
		roomRepository.updateStatusById(1);		
	}
}
