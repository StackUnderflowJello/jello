package com.revature.dao;

import com.revature.pojo.Users;

public interface RegisterDao {
	
	public Integer createUser(Users user);
	
	public void removeUser(Users user);

}
