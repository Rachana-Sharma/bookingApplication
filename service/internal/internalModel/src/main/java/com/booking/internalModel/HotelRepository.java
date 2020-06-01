package com.booking.internalModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rachana Sharma The Hotel Repository
 */
@Repository
public interface HotelRepository extends CrudRepository<Hotel, Integer> {

}
