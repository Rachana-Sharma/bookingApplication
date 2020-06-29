package com.booking.common;

import java.util.Date;

/**
 * @author Rachana Sharma DateRangeRequest
 *
 */
public class DateRangeRequest {

	/**
	 * The start date
	 */
	private Date startDate;
	
	/**
	 * The end date
	 */
	private Date endDate;

	/**
	 * 
	 */
	public DateRangeRequest() {
		
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
