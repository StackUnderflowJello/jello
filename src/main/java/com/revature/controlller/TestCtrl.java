package com.revature.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Users;
import com.revature.services.AppServices;

@RestController
public class TestCtrl {
	
	@Autowired
	private AppServices service;
	
	
	@RequestMapping(value ="/test", method = RequestMethod.GET)
	public void test (){
	System.out.println("Entering Test or something like that");
	Users usr = new Users();
		
		usr.setU_id(3);
		usr.setU_email("duke@java.com");
		usr.setU_password("123");		
		
		System.out.println(usr);
		usr = service.getUserByEmail(usr);
		
	}
	
	
	
}
