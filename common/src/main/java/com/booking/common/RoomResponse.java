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
	private List<RoomModel> roomResponse=new ArrayList<>();

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
	 * empty constructor
	 */
	public RoomResponse() {

	}

	/**
	 * @param roomRespon
	 */
	public RoomResponse(List<RoomModel> roomResponse) {
		this.roomResponse = roomResponse;
	};
}
