package com.revature.dao;

import java.util.List;

import com.revature.pojo.User_Board;
import com.revature.pojo.Users;

public interface UsersDao {

	//CREATE
	public void newUser(Users use);
	
	
	//READ
	public Users getUserByEmail(Users use);
	public List<User_Board> getAllBoardsByUser(Users use);
	
	//UPDATE

	public void updateUserRoles(Users use);
	
	//DELETE
	public void deleteUser(Users use);
	public void deleteUserFromBoardById(Users use);
}
