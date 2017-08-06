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
	public List<Users> getAllUsers();
	
	//UPDATE

	public void updateUser(Users use);
	
	//DELETE
	public void deleteUser(Users use);
}
