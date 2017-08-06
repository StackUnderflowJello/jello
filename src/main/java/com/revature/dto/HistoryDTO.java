package com.revature.dto;

import java.io.Serializable;

public class HistoryDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7424104745691852242L;
	private String date;
	private int points;
	
	public HistoryDTO(){}

	public HistoryDTO(String date, int points) {
		super();
		this.date = date;
		this.points = points;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Dto [date=" + date + ", points=" + points + "]";
	}
	
	
}
