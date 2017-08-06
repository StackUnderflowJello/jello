package com.revature.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.NewUserDTO;
import com.revature.pojo.Users;
import com.revature.services.AppServices;

@RestController
public class RegisterUserCtrl {
	
	@Autowired
	AppServices service;
	
	@RequestMapping(value="/registerUser", method=RequestMethod.POST)
	public void registerUser(@RequestBody String json) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("POST JSON: " + json);
		
		ObjectMapper mapper = new ObjectMapper();
		NewUserDTO newUser = mapper.readValue(json, NewUserDTO.class);
		System.out.println("New User: " + newUser);
		
		Users newby = new Users();
		
		String email = newUser.getRegEmail();
		String password = newUser.getRegPassword();
		
		//newby.setU_id(3);
		newby.setU_email(email);
		newby.setU_password(password);
		
		System.out.println("New User Object: " + newby);
		
		service.newUser(newby);
	}
}
