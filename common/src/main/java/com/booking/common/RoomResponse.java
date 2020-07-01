package com.booking.common;

import java.util.ArrayList;
import java.util.List;

/**
 * RoomResponse
 * 
 * @author Rachana Sharma
 *
 */
public class RoomResponse {

	/**
	 * the room response
	 */
	private List<RoomModel> roomResponse = new ArrayList<>();

	/**
	 * Class constructor
	 */
	public RoomResponse() {

	}

	/**
	 * get roomResponse of this RoomResponse
	 * 
	 * @return the roomResponse
	 */
	public List<RoomModel> getRoomResponse() {
		return roomResponse;
	}

	/**
	 * Registers the roomResponse to display in RoomResponse
	 * 
	 * @param roomResponse the roomResponse to set
	 */
	public void setRoomResponse(List<RoomModel> roomResponse) {
		this.roomResponse = roomResponse;
	}
}
