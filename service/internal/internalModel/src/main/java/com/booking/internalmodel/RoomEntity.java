package com.booking.internalmodel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The RoomEntity
 * 
 * @author Rachana Sharma
 */

@Entity
@Table(name = "Room_Entity")
public class RoomEntity {
	/**
	 * The Room Id
	 */
	@Id
	@SequenceGenerator(initialValue = 1, allocationSize = 3, name = "mySeqGen")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int roomId;
	/**
	 * The Room Type
	 */
	@Column(name = "RoomType")
	private String roomType;
	/**
	 * The Room Price
	 */
	@Column(name = "RoomPrice")
	private double roomPrice;
	/**
	 * The Room Status
	 */
	@Column(name = "RoomStatus")
	private String roomStatus;

	@OneToOne(mappedBy = "room", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private BookingEntity booking;

	/**
	 * Class Constructor
	 */
	public RoomEntity() {

	}

	/**
	 * @return the roomId
	 */
	public int getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	/**
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 * @return the roomPrice
	 */
	public double getRoomPrice() {
		return roomPrice;
	}

	/**
	 * @param roomPrice the roomPrice to set
	 */
	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	/**
	 * @return the roomStatus
	 */
	public String getRoomStatus() {
		return roomStatus;
	}

	/**
	 * @param roomStatus the roomStatus to set
	 */
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
}
