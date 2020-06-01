package com.booking.common;

public class HotelRequest {

	/**
	 * The id
	 */
	
	private int id;
	/**
	 * The name
	 */
	
	private String name;

	/**
	 * @param id
	 * @param name
	 */
	public HotelRequest(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * empty constructor
	 */
	public HotelRequest() {

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
