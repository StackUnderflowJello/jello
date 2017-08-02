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
import com.revature.dto.JelloDTO;
import com.revature.pojo.Board;
import com.revature.pojo.Jello_Bite;
import com.revature.services.AppServices;

@RestController
public class RemoveStoryCtrl {

	@RequestMapping(value = "/removeStory", method = RequestMethod.POST)
	public void removeStory(HttpServletRequest req, @RequestBody String json){
		//get Board from session
		HttpSession session = req.getSession();
		Board curr = (Board) session.getAttribute("board");
		
		//get json from the client and parse it into the JelloDTO
		ObjectMapper mapper = new ObjectMapper();
		JelloDTO jello_dto;
		try {
			jello_dto = mapper.readValue(json, JelloDTO.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//convert JelloDTO to Jello
		JelloDTO dto = new JelloDTO();
		Jello_Bite jello = new Jello_Bite();
		jello.setBite_name(dto.getStory_name());
		jello.setJello_point(dto.getPoints());
		
		//delete jello from db
		//new AppServices().removeBite(jello);
		
		//make sure to update view
	}
	
}