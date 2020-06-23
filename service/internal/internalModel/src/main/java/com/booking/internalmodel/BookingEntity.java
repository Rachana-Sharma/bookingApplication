package com.booking.internalmodel;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * BookingEntity
 * 
 * @author Rachana Sharma
 */
@Entity
@Table(name = "BOOKING_ENTITY")
public class BookingEntity {
	/**
	 * The booking id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	/**
	 * The breakfast
	 */
	@Column(name = "BREAKFAST")
	private boolean breakfast;
	/**
	 * The total charge
	 */
	@Column(name = "TOTAL_CHARGE")
	private double totalCharge;
	/**
	 * The start date
	 */
	@Column(name = "START_DATE")
	private Date startDate;
	/**
	 * The end date
	 */
	@Column(name = "END_DATE")
	private Date endDate;

	/**
	 * Joining column roomId of RoomEntity into bookingEntity
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roomId")
	private RoomEntity room;	
	
	@OneToOne(mappedBy = "bookingEntity", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private CustomerEntity customerEntity;


	/**
	 * Class Constructor
	 */
	public BookingEntity() {

	}

	/**
	 * @return the bookingId
	 */
	public int getBookingId() {
		return bookingId;
	}

	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * @return the breakfast
	 */
	public boolean isBreakfast() {
		return breakfast;
	}

	/**
	 * @param breakfast the breakfast to set
	 */
	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}

	/**
	 * @return the totalCharge
	 */
	public double getTotalCharge() {
		return totalCharge;
	}

	/**
	 * @param totalCharge the totalCharge to set
	 */
	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the room
	 */
	public RoomEntity getRoom() {
		return room;
	}
	
	/**
	 * @param room the room to set
	 */
	public void setRoom(RoomEntity room) {
		this.room = room;
	}
}
