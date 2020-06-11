package com.booking.internalModel;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Rachana Sharma Booking
 */
@Entity
@Table
public class BookingEntity {
	/**
	 * The booking id
	 */
	@Id
	// @SequenceGenerator(initialValue = 1,allocationSize = 3, name = "mySeqGen")
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	/**
	 * The breakfast
	 */
	@Column
	private String breakfast;
	/**
	 * The total charge
	 */
	@Column
	private double totalCharge;
	/**
	 * The start date
	 */
	@Column
	private Date startDate;
	/**
	 * The end date
	 */
	@Column
	private Date endDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "roomId")
	private RoomEntity room;

	/**
	 * @param bookingId
	 * @param breakfast
	 * @param totalCharge
	 * @param startDate
	 * @param endDate
	 */
	public BookingEntity(int bookingId, String breakfast, double totalCharge, Date startDate, Date endDate,
			RoomEntity room) {
		// this.bookingId = bookingId;
		this.breakfast = breakfast;
		this.totalCharge = totalCharge;
		this.startDate = startDate;
		this.endDate = endDate;
		this.room = room;
	}

	/**
	 * Empty Constructor
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
	public String getBreakfast() {
		return breakfast;
	}

	/**
	 * @param breakfast the breakfast to set
	 */
	public void setBreakfast(String breakfast) {
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

}
