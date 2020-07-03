package com.booking.internalmodel;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The RoomRepository, it extends CrudRepository
 * 
 * @author Rachana Sharma
 */
@Repository
public interface RoomRepository extends CrudRepository<RoomEntity, Integer> {

	/**
	 * Runs a select query on RoomEntity Table
	 * 
	 * @param roomType
	 * @return room id of the first room that satisfies the query
	 */
	@Query(value = "SELECT TOP 1 r.ROOM_ID  FROM ROOM_ENTITY r WHERE r.ROOM_STATUS ='AVAILABLE'  AND r.ROOM_TYPE =:roomType", nativeQuery = true)
	int findRoom(@Param("roomType") String roomType);

	/**
	 * Updates RoomEntity based on given condition
	 * 
	 * @param roomId
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE RoomEntity r SET r.roomStatus ='AVAILABLE' WHERE r.roomId =:roomId")
	void updateStatusById(@Param("roomId") int roomId);

	/**
	 * selects room id of the first row that satisfies the given condition and
	 * allots it for booking
	 * 
	 * @param startDate
	 * @param roomType
	 * @return room id
	 */
	@Query(value = "SELECT TOP 1 ROOM_ENTITY.ROOM_ID FROM ROOM_ENTITY WHERE (ROOM_ENTITY.ROOM_TYPE=:roomType AND ROOM_ENTITY.ROOM_ID IN (SELECT BOOKING_ENTITY.ROOM_ID FROM BOOKING_ENTITY WHERE BOOKING_ENTITY.END_DATE <=:startDate )) OR (ROOM_ENTITY.ROOM_TYPE=:roomType AND ROOM_ENTITY.ROOM_STATUS ='AVAILABLE')", nativeQuery = true)
	int findRoomByDate(@Param("startDate") Date startDate, @Param("roomType") String roomType);

	/**
	 * selects room id of the first row that satisfies the given condition and
	 * allots it for booking
	 * 
	 * @param startDate
	 * @param endDate
	 * @param roomType
	 * @return room id
	 */
	@Query(value = "SELECT TOP 1 ROOM_ENTITY.ROOM_ID FROM ROOM_ENTITY WHERE (ROOM_ENTITY.ROOM_TYPE=:roomType AND ROOM_ENTITY.ROOM_ID NOT IN (SELECT BOOKING_ENTITY.ROOM_ID FROM BOOKING_ENTITY WHERE (BOOKING_ENTITY.START_DATE BETWEEN (:startDate AND :endDate)) OR (BOOKING_ENTITY.END_DATE BETWEEN (:startDate AND :endDate)) OR (BOOKING_ENTITY.START_DATE <=:startDate AND BOOKING_ENTITY.END_DATE >=:endDate))) OR (ROOM_ENTITY.ROOM_TYPE=:roomType AND ROOM_ENTITY.ROOM_STATUS ='AVAILABLE')", nativeQuery = true)
	int findRoomByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
			@Param("roomType") String roomType);

}
