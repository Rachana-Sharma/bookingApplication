package com.booking.internalmodel;

import org.springframework.data.repository.CrudRepository;

/**
 * The BookingRepository, it extends CrudRepository
 * 
 * @author Rachana Sharma
 */
public interface BookingRepository extends CrudRepository<BookingEntity, Integer> {

}
