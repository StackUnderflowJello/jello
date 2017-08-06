package com.revature.dto;

public class BoardyDTO {

	private int boardyId;
	
	public BoardyDTO(){}

	public BoardyDTO(int boardyId) {
		super();
		this.boardyId = boardyId;
	}

	public int getBoardyId() {
		return boardyId;
	}

	public void setBoardyId(int boardyId) {
		this.boardyId = boardyId;
	}

	@Override
	public String toString() {
		return "BoardyDTO [boardyId=" + boardyId + "]";
	}
}
