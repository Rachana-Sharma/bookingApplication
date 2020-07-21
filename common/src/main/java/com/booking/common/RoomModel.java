package com.booking.common;

/**
 * The RoomModel
 * 
 * @author Rachana Sharma
 */
public class RoomModel {

	/**
	 * The Room Id
	 */
	private int roomId;

	/**
	 * The Room Type
	 */
	private String roomType;

	/**
	 * The Room Price
	 */
	private double roomPrice;

	/**
	 * The Room Status
	 */
	private String roomStatus;

	/**
	 * @param roomId
	 * @param roomType
	 * @param roomPrice
	 * @param roomStatus
	 */
	public RoomModel(int roomId, String roomType, double roomPrice, String roomStatus) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.roomStatus = roomStatus;
	}

	/**
	 * Class Constructor
	 */
	public RoomModel() {

	}

	/**
	 * get roomId of this RoomModel
	 * 
	 * @return the roomId
	 */
	public int getRoomId() {
		return roomId;
	}

	/**
	 * Registers the roomId to display in RoomModel
	 * 
	 * @param roomId the roomId to set
	 */
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	/**
	 * get roomType of this RoomModel
	 * 
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * Registers the roomType to display in RoomModel
	 * 
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 * get roomPrice of this RoomModel
	 * 
	 * @return the roomPrice
	 */
	public double getRoomPrice() {
		return roomPrice;
	}

	/**
	 * Registers the roomPrice to display in RoomModel
	 * 
	 * @param roomPrice the roomPrice to set
	 */
	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	/**
	 * get roomStatus of this RoomModel
	 * 
	 * @return the roomStatus
	 */
	public String getRoomStatus() {
		return roomStatus;
	}

	/**
	 * Registers the roomStatus to display in RoomModel
	 * 
	 * @param roomStatus the roomStatus to set
	 */
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
}
