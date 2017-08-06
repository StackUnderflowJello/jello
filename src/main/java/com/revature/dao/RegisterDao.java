package com.revature.dao;

import com.revature.pojo.Users;

public interface RegisterDao {
	
	public void createUser(Users user);
	
	public void removeUser(Users user);

}
