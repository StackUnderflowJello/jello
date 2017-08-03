package com.revature.dao;

import com.revature.pojo.Board;
import com.revature.pojo.User_Board;

public interface User_BoardDao {

	//CREATE
	public void createBoard(Board board);
	
	//READ
	public String getBoardName(Board board);
	public User_Board getUser_BoardByBoard(Board board);
	
	//UPDATE
	public void changeBoardName(Board board);
	
	
	//DELETE
	public void deleteBoard(Board board);
}
