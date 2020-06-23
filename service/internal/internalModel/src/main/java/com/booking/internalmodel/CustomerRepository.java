package com.booking.internalmodel;

import org.springframework.data.repository.CrudRepository;

/**
 * The CustomerRepository, it extends CrudRepository
 * 
 * @author Rachana Sharma
 */
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

}
