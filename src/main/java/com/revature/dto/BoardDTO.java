package com.revature.dto;

public class BoardDTO {

	private String board_name;
	
	public BoardDTO(){
		
	}

	public BoardDTO(String board_name) {
		super();
		this.board_name = board_name;
	}

	public String getBoard_name() {
		return board_name;
	}

	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}

	@Override
	public String toString() {
		return "BoardDTO [board_name=" + board_name + "]";
	}
	
}