package com.booking.internalmodel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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

	/**
	 * Joining RoomEntity Table with BookingEntity Table through OneToOne Mapping
	 */
	@OneToOne(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
	private BookingEntity booking;

	/**
	 * Class Constructor
	 */
	public RoomEntity() {

	}

	/**
	 * get roomId of this RoomEntity
	 * 
	 * @return the roomId
	 */
	public int getRoomId() {
		return roomId;
	}

	/**
	 * Registers the roomId to display in RoomEntity
	 * 
	 * @param roomId the roomId to set
	 */
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	/**
	 * get roomType of this RoomEntity
	 * 
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * Registers the roomType to display in RoomEntity
	 * 
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 * get roomPrice of this RoomEntity
	 * 
	 * @return the roomPrice
	 */
	public double getRoomPrice() {
		return roomPrice;
	}

	/**
	 * Registers the roomPrice to display in RoomEntity
	 * 
	 * @param roomPrice the roomPrice to set
	 */
	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	/**
	 * get roomStatus of this RoomEntity
	 * 
	 * @return the roomStatus
	 */
	public String getRoomStatus() {
		return roomStatus;
	}

	/**
	 * Registers the roomStatus to display in RoomEntity
	 * 
	 * @param roomStatus the roomStatus to set
	 */
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
}
