package com.booking.common;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booking.common.Hotel;

/**
 * @author Rachana Sharma
 * The Hotel Repository
 */
@Repository
public interface HotelRepository extends CrudRepository<Hotel, Integer> {

}
