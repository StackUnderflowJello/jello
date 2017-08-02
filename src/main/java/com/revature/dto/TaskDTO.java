package com.revature.dto;

public class TaskDTO {

	public String value;
	
	public TaskDTO(){
		
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "TaskDTO [value=" + value + "]";
	}
	
}
