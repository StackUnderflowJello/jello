package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.UserDTO;
import com.revature.pojo.Users;
import com.revature.services.AppServices;

@RestController
public class RemoveUserAccountCtrl {
	
	@Autowired
	AppServices app;

	@RequestMapping(value = "/deRegister", method = RequestMethod.POST)
	public void removeUserFromBoard(HttpServletRequest req, @RequestBody String json) throws JsonParseException, JsonMappingException, IOException{
		Users currentUser = new Users();
		//Get User from Session
		HttpSession session = req.getSession();
		currentUser = (Users) session.getAttribute("user");

		// get the userDTO from json
		ObjectMapper mapper = new ObjectMapper();
		UserDTO user_dto = mapper.readValue(json, UserDTO.class); 
		
		if(currentUser.getU_email().equals(user_dto.getEmail())){
			app.removeUserFromBoards(currentUser);
			app.deleteUser(currentUser);
		}else{
			System.out.println("No luck, buddy.");
		}
		
		
//		//get userByEmail from service to get the id
//		user = new Service().getUserByEmail(user);
//		
//		//delete user from user_board table by id
//		//need to do a criteria here
//		new Service().deleteUserFromBoardById(user);
	}
	
}