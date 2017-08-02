package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.JelloDTO;
import com.revature.pojo.Board;
import com.revature.pojo.Jello_Bite;

@RestController
public class RemoveStoryCtrl {

	@RequestMapping(value = "/removeStory", method = RequestMethod.POST)
	public void removeStory(HttpServletRequest req, @RequestBody String json){
		//get Board from session
		HttpSession session = req.getSession();
		Board curr = (Board) session.getAttribute("board");
		
		//get json from the client and parse it into the JelloDTO
		ObjectMapper mapper = new ObjectMapper();
		JelloDTO jello_dto = mapper.readValue(json, JelloDTO.class);
		
		//convert JelloDTO to Jello
		Jello_Bite jello = new Jello_Bite();
		jello.setBite_name(jello_dto.getStory_name());
		jello.setJello_point(jello_dto.getPoints());
		
		//delete jello from db
		new Service().removeBite(jello);
		
		//make sure to update view
	}
	
}