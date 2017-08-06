package com.revature.dto;

public class TaskyDTO {

	private int taskyID;
	
	public TaskyDTO(){}

	public TaskyDTO(int taskyID) {
		super();
		this.taskyID = taskyID;
	}

	public int getTaskyID() {
		return taskyID;
	}

	public void setTaskyID(int taskyID) {
		this.taskyID = taskyID;
	}

	@Override
	public String toString() {
		return "TaskyDTO [taskyID=" + taskyID + "]";
	}
	
	
}
