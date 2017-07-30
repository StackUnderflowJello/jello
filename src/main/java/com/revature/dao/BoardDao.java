package com.revature.dao;

import com.revature.pojo.Board;

public interface BoardDao {

	//CREATE
	public void createBoard(Board board);
	
	//READ
	public Board getBoard(Board board);
	
	//UPDATE
	public void adminRenameBoard(Board board);
	public void updateBackGround(Board board);
	
	//DELETE
	public void adminRemoveBoard(Board board);
}
