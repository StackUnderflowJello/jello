package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Users;
import com.revature.services.AppServices;

@RestController
public class LoginCtrl {

	@Autowired
	AppServices service;
	
	@RequestMapping(value="/loginUser", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<Users> loginUser(@RequestBody Users user, HttpServletRequest req) {
		System.out.println("GET JSON: " + user);
		System.out.println(user.getU_email());
		
		Users revu = service.getUserByEmail(user);
		System.out.println(revu);
		System.out.println(user);
		
		if(revu.getU_email().equals(user.getU_email()) && revu.getU_password().equals(user.getU_password())){
			System.out.println("CLEAR");
			req.setAttribute("user", revu.getU_email());
			return new ResponseEntity<Users>(HttpStatus.OK) ;
		}else{
			System.out.println("NOPE");
			return new ResponseEntity<Users>(HttpStatus.CONFLICT);
		}
		
		
		
		//ObjectMapper mapper = new ObjectMapper();
		//UserDTO qeuedUser = mapper.readValue(json, UserDTO.class);
		//System.out.println("Qeued User: " + qeuedUser);
		
	}
	
	
	
}
