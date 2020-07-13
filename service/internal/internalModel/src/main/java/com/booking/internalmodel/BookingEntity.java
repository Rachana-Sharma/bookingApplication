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
	@GeneratedValue(strategy = GenerationType.TABLE)
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

	/**
	 * Joining CustomerEntity Table with BookingEntity Table through OneToOne
	 * Mapping
	 */
	@OneToOne(mappedBy = "bookingEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private CustomerEntity customerEntity;

	/**
	 * Class Constructor
	 */
	public BookingEntity() {

	}

	/**
	 * get booking id of this BookingEntity
	 * 
	 * @return the bookingId
	 */
	public int getBookingId() {
		return bookingId;
	}

	/**
	 * Registers the bookingId to display in BookingEntity
	 * 
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
	 * Registers the Breakfast to display in BookingEntity
	 * 
	 * @param breakfast the breakfast to set
	 */
	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}

	/**
	 * get totalCharge of this BookingEntity
	 * 
	 * @return the totalCharge
	 */
	public double getTotalCharge() {
		return totalCharge;
	}

	/**
	 * Registers the totalCharge to display in BookingEntity
	 * 
	 * @param totalCharge the totalCharge to set
	 */
	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
	}

	/**
	 * get startDate of this BookingModel
	 * 
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Registers the startDate to display in BookingEntity
	 * 
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * get endDate of this BookingEntity
	 * 
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Registers the endDate to display in BookingEntity
	 * 
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * get room of this BookingEntity
	 * @return the room
	 */
	public RoomEntity getRoom() {
		return room;
	}

	/**
	 * Registers the room to display in BookingEntity
	 * @param room the room to set
	 */
	public void setRoom(RoomEntity room) {
		this.room = room;
	}
}
