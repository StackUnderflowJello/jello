package com.revature.dao;

import com.revature.pojo.Users;

public interface UsersDao {

	//CREATE
	public void newUser(Users use);
	
	
	//READ
	public Users getUserByEmail(Users use);
	
	
	//UPDATE

	public void updateUser(Users use);
	
	//DELETE
	public void deleteUser(Users use);
}
