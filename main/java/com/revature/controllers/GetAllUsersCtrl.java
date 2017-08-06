package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.Users;
import com.revature.services.AppServices;

@RestController
public class GetAllUsersCtrl {
	
	@Autowired
	AppServices app;
	
	@RequestMapping(value="/getAllUsers")
	public @ResponseBody String getAllUsers() throws JsonProcessingException{
		
		System.out.println("All users json.");
		
		ObjectMapper mapper = new ObjectMapper();
		List<Users> users = app.getAllUsers();
		
		String parsed = mapper.writeValueAsString(users);
		
		System.out.println(parsed);
		
		return parsed;
	}

}
