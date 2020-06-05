package com.booking.common;

/**
 * @author Rachana Sharma Room
 */
public class RoomRequest {
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
	public RoomRequest(int roomId, String roomType, double roomPrice, String roomStatus) {

		this.roomId = roomId;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.roomStatus = roomStatus;
	}

	/**
	 * Empty Constructor
	 */
	public RoomRequest() {

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
