package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.UserDTO;
import com.revature.pojo.Board;
import com.revature.pojo.Users;
import com.revature.services.AppServices;

@RestController
public class RemoveUserFromBoardCtrl {

	@RequestMapping(value = "/removeUser", method = RequestMethod.POST)
	public void removeUserFromBoard(HttpServletRequest req, @RequestBody String json) throws JsonParseException, JsonMappingException, IOException{
		//get board from session
		HttpSession session = req.getSession();
		Board curr = (Board) session.getAttribute("board");
		
		//get the userDTO from json
		ObjectMapper mapper = new ObjectMapper();
		UserDTO user_dto = mapper.readValue(json, UserDTO.class); 
		
		//convert userDTO to user
		Users user = new Users();
		user.setU_email(user_dto.getEmail());
		
		//get userByEmail from service to get the id
		user = new AppServices().getUserByEmail(user);
		
		//delete user from user_board table by id
		//need to do a criteria here
		new AppServices().deleteUser(user);
	}
	
}