package com.revature.dao;

import com.revature.pojo.Board;
import com.revature.pojo.Jello_Bite;
import com.revature.pojo.Task;
import com.revature.pojo.User_Board;
import com.revature.pojo.Users;

public interface UsersDao {

	//CREATE
	public void newUser(Users use);
	public void createBite(Jello_Bite bite); //Ask Gil
	public void createBiteTask(Task task);
	public void createBoard(Board board);
	
	
	//READ
	public Users getUserByEmail(Users use);
//	public Users serchUserByEmail(Users use);
	public Board getBoard(Board board);
	
	//UPDATE
	public void addUserToBoard(User_Board user_board);
	public void moveBite(Jello_Bite bite);
	public void updateBiteTask(Task task);
	public void adminRenameBoard(Board board);
//	public void updateBackGround(Board board);
	
	//DELETE
	public void removeBite(Jello_Bite bite);
	public void adminRemoveUser(Users use);
	public void adminRemoveBoard(Board board);
}
