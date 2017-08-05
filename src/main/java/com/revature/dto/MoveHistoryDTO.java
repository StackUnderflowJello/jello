package com.revature.dto;

public class MoveHistoryDTO {

	private String story_name;
	private int prev_lane_id;
	private int new_lane_id;
	
	public MoveHistoryDTO(){
		
	}

	public MoveHistoryDTO(String story_name, int prev_lane_id, int new_lane_id) {
		super();
		this.story_name = story_name;
		this.prev_lane_id = prev_lane_id;
		this.new_lane_id = new_lane_id;
	}

	public String getStory_name() {
		return story_name;
	}

	public void setStory_name(String story_name) {
		this.story_name = story_name;
	}

	public int getPrev_lane_id() {
		return prev_lane_id;
	}

	public void setPrev_lane_id(int prev_lane_id) {
		this.prev_lane_id = prev_lane_id;
	}

	public int getNew_lane_id() {
		return new_lane_id;
	}

	public void setNew_lane_id(int new_lane_id) {
		this.new_lane_id = new_lane_id;
	}

	@Override
	public String toString() {
		return "MoveHistoryDTO [story_name=" + story_name + ", prev_lane_id=" + prev_lane_id + ", new_lane_id="
				+ new_lane_id + "]";
	}
	
}
