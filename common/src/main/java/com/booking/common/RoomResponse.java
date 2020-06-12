package com.booking.common;

import java.util.List;

public class RoomResponse {
	List<RoomModel> roomResponse;

	/**
	 * @return the roomResponse
	 */
	public List<RoomModel> getRoomResponse() {
		return roomResponse;
	}

	/**
	 * @param roomResponse the roomResponse to set
	 */
	public void setRoomResponse(List<RoomModel> roomResponse) {
		this.roomResponse = roomResponse;
	}

	/**
	 * 
	 */
	public RoomResponse() {
		super();
	}

	/**
	 * @param roomRespon
	 */
	public RoomResponse(List<RoomModel> roomResponse) {
		super();
		this.roomResponse = roomResponse;
	};
}
