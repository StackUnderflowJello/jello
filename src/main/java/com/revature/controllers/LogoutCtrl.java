package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutCtrl {
	
	@RequestMapping(value="/logoutUser", method=RequestMethod.POST)
	public void loginUser(HttpServletRequest req) {
		System.out.println("LOGGED OUT");
		req.getSession().invalidate();
	}
	
	
	
}
