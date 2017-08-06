package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.BoardDTO;

@RestController
public class AddBoardCtrl {
	
	@RequestMapping(value = "/addBoard", method = RequestMethod.POST)
	public void addPOST(HttpServletRequest req, @RequestBody String json) throws JsonParseException, JsonMappingException, IOException{
		System.out.println("AddBoard - POST");
		System.out.println(json);

		ObjectMapper mapper = new ObjectMapper();
		BoardDTO board = mapper.readValue(json, BoardDTO.class);
		System.out.println("Board: " + board);
		
		//convert DTO to board object
		//add the board record
		//Board brd = new Board();
		//brd.setB_name(board.getBoard_name());  
		//new Service().addBoard(brd);
		
		
		//get current user attribute from session  
		//HttpSession session = req.getSession();
		//User user = session.getAttribute("user");

		//add to board_user table, the user as admin -- multiple steps
		
		//get the id from the added record
		//int b_id = brd.getB_id(); 
		
		//set the roles object to admin
		//Roles roles = new Roles(2, "Admin"); 
		
		//set the user_board_id object; use board and user object from session 
		//User_Board_Id ubi = new User_Board_Id(brd, user);
		 
		//set the user_board object
		//User_Board  us_board = new User_Board(ubi, roles);
		 
		//add user_board object to the db
		//new Service().addUserBoard(us_board); 
	} 
	
}