package com.revature.dto;

import java.util.Arrays;

public class JelloDTO {
	
	private String story_name;
	private int points;
	private TaskDTO[] task;
	
	public JelloDTO(){
		
	}

	public String getStory_name() {
		return story_name;
	}

	public void setStory_name(String story_name) {
		this.story_name = story_name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public TaskDTO[] getTask() {
		return task;
	}

	public void setTask(TaskDTO[] task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "JelloDTO [story_name=" + story_name + ", points=" + points + ", task=" + Arrays.toString(task) + "]";
	}
	
}