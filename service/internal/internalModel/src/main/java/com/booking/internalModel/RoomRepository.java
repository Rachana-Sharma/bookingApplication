package com.booking.internalModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * The RoomRepository, it extends CrudRepository
 * @author Rachana Sharma
 */
@Repository
public interface RoomRepository extends CrudRepository<RoomEntity, Integer> {
	
	@Query(value="SELECT TOP 1 r.ROOM_ID  FROM ROOM_ENTITY r WHERE r.ROOM_STATUS ='AVAILABLE'  AND r.ROOM_TYPE =:roomType",nativeQuery=true)
	int findRoom(@Param("roomType")String roomType);

}
