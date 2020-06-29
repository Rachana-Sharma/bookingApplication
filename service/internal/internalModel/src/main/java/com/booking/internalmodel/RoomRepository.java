package com.booking.internalmodel;

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

	
	
}
