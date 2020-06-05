package com.booking.internalModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rachana Sharma
 * CrudRepository
 */
@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {

}
