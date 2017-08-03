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
import com.revature.pojo.Roles;
import com.revature.pojo.User_Board;
import com.revature.pojo.User_Board_Id;
import com.revature.pojo.Users;
import com.revature.services.AppServices;

@RestController
public class AddUserToBoardCtrl {

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public void addUserToBoard(HttpServletRequest req, @RequestBody String json){
		//get board from the session
		HttpSession session = req.getSession();
		Board curr = (Board) session.getAttribute("board");
		

//		//json is the user to be added
//		//get the userDTO [just their email]
//		//ObjectMapper mapper = new ObjectMapper();
//		UserDTO user_dto = mapper.readValue(json, UserDTO.class);
//		
//		//convert userDTO to user
//		Users user = new Users();
//		user.setU_email(user_dto.getEmail());
//		
//		//need to creates roles, user_board_id object, then combine to get user_board
//		Roles role = new Roles(1, "User");
//		User_Board_Id ub_id = new User_Board_Id(curr, user);
//		User_Board ub = new User_Board(ub_id, role);
//		
//		//add record to user_board table
//		new Service().addUserToBoard(ub);

	}
	
}