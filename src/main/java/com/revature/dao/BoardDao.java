package com.revature.dao;

import java.util.List;

import com.revature.pojo.Board;
import com.revature.pojo.Users;

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

	public List<Board> getAllBoardsByUser(Users use);
}
