package com.revature;

import com.revature.dao.RegisterDaoImpl;
import com.revature.pojo.Users;

public class TestDriver {

	public static void main(String[] args) {
		
		Users user = new Users();
		
		user.setU_id(1);
		user.setU_email("hello@gmail.com");
		user.setU_password("password");
		
		new RegisterDaoImpl().createUser(user);
		
		System.out.println(user);

	}

}
