package com.booking.internalmodel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The CustomerEntity
 * 
 * @author Rachana Sharma
 */
@Entity
@Table(name = "CUSTOMER_ENTITY")
public class CustomerEntity {

	/**
	 * The Customer Id
	 */
	@Id
	@SequenceGenerator(initialValue = 1, allocationSize = 3, name = "mySeqGen")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int customerId;

	/**
	 * The Customer Name
	 */
	@Column(name = "CUSTOMER_NAME")
	private String customerName;

	/**
	 * Joining column roomId of RoomEntity into bookingEntity
	 */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "bookingId")
	private BookingEntity bookingEntity;

	/**
	 * Class Constructor
	 */
	public CustomerEntity() {

	}

	/**
	 * get customerId of this CustomerEntity
	 * 
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Registers the customerId to display in CustomerEntity
	 * 
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * get customerName of this CustomerEntity
	 * 
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * Registers the customerName to display in CustomerEntity
	 * 
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * get bookingEntity of this CustomerEntity
	 * 
	 * @return the bookingEntity
	 */
	public BookingEntity getBookingEntity() {
		return bookingEntity;
	}

	/**
	 * Registers the bookingEntity to display in CustomerEntity
	 * 
	 * @param bookingEntity the bookingEntity to set
	 */
	public void setBookingEntity(BookingEntity bookingEntity) {
		this.bookingEntity = bookingEntity;
	}

}
