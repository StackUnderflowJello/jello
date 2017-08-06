package com.revature.services;

import com.revature.dao.RegisterDaoImpl;
import com.revature.pojo.Users;

public class RegisterService {
	
	public static void createUser(Users user) {
		RegisterDaoImpl dao = new RegisterDaoImpl();
		dao.createUser(user);
	}
	
	public static void deleteUser(Users user) {
		RegisterDaoImpl dao = new RegisterDaoImpl();
		dao.removeUser(user);
	}

}
