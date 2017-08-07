package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.Board;
import com.revature.pojo.Users;
import com.revature.services.AppServices;

@RestController
public class GetAllBoardsByUser {

	@Autowired
	private AppServices appServices;
	
	@RequestMapping(value="/getBoards", method=RequestMethod.GET)
	public @ResponseBody String getBoardsByUser(HttpServletRequest req) throws JsonProcessingException{
		HttpSession httpSession = req.getSession();
		Users user = (Users) httpSession.getAttribute("user");
		
		//List<Board> boardList = appServices.getAllBoardsByUser(user);
		List<Board> boardList = appServices.getAllBoards();
		ObjectMapper mapper = new ObjectMapper();
		String returnedJson = mapper.writeValueAsString(boardList);
		return returnedJson;
	}	
}
