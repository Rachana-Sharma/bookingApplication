package com.booking.internalModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Rachana Sharma Room
 */
@Entity
@Table
public class Room {
	/**
	 * The Room Id
	 */
	@Id
	@Column
	private int roomId;
	/**
	 * The Room Type
	 */
	@Column
	private String roomType;
	/**
	 * The Room Price
	 */
	@Column
	private double roomPrice;
	/**
	 * The Room Status
	 */
	@Column
	private String roomStatus;

	/**
	 * @param roomId
	 * @param roomType
	 * @param roomPrice
	 * @param roomStatus
	 */
	public Room(int roomId, String roomType, double roomPrice, String roomStatus) {

		this.roomId = roomId;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.roomStatus = roomStatus;
	}

	/**
	 * Empty Constructor
	 */
	public Room() {

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
