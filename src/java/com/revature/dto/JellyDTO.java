package com.revature.dto;

public class JellyDTO {

	private int JellyId;
	
	public JellyDTO(){}

	public JellyDTO(int jellyId) {
		super();
		JellyId = jellyId;
	}

	public int getJellyId() {
		return JellyId;
	}

	public void setJellyId(int jellyId) {
		JellyId = jellyId;
	}

	@Override
	public String toString() {
		return "JellyDTO [JellyId=" + JellyId + "]";
	};
	
	
}
