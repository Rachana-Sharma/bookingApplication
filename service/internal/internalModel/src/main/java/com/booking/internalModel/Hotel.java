package com.booking.internalModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Hotel {

	/**
	 * The id
	 */
	@Id
	@Column
	private int id;
	/**
	 * The name
	 */
	@Column
	private String name;

	/**
	 * @param id
	 * @param name
	 */
	public Hotel(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * empty constructor
	 */
	public Hotel() {

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
