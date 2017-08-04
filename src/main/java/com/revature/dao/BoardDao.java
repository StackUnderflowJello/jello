package com.revature.dao;

import java.util.List;

import com.revature.pojo.Board;
import com.revature.pojo.Swim_Lane;

public interface BoardDao {

	//CREATE
	public void createBoard(Board board);
	
	//READ
	public Board getBoard(Board board);
	public Swim_Lane getFirstSwimLaneByBoard(Board board);
	public List<Swim_Lane> getAllSwimLaneByBoard(Board board);
	
	
	//UPDATE
	public void adminRenameBoard(Board board);
	public void updateBackGround(Board board);
	
	//DELETE
	public void adminRemoveBoard(Board board);
}
