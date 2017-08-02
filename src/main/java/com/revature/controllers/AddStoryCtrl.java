package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.JelloDTO;

@RestController
public class AddStoryCtrl {

	@RequestMapping(value = "/addStory", method = RequestMethod.GET)
	public ModelAndView addStory(){
		System.out.println("Add - GET");
		return new ModelAndView("/static/board.html");
	}
	
	@RequestMapping(value = "/addStory", method = RequestMethod.POST)
	public void addPOST(HttpServletRequest req, @RequestBody String json) throws JsonParseException, JsonMappingException, IOException{
		System.out.println("Add - POST");
		System.out.println(json);

		ObjectMapper mapper = new ObjectMapper();
		JelloDTO jello = mapper.readValue(json, JelloDTO.class);
		System.out.println("Jello: " + jello);
		
		//need to not add empty tasks into the table
		if(jello.getTask()[0].getValue().equals("")){
			System.out.println("Task is empty");
		}
		
		//need to get the current board
		//HttpSession session = req.getSession();
		//Board currBoard = session.getAttribute("board");
		
		//need to get swimlane using board
		//Swim_lane swimlane = new Service().getSwimlane1ByBoard(currBoard)
		
		//set jello object, need to get jello id
		//int jelloID = new Service().getJelloCount()++;

		//Jello_Bite jb = new Jello_Bite(jelloID, jello.getStory_name(), swimlane, jello.getPoints())
		
		//add jello object to the db
		//new Service().addJello(jb);
		
		//set task objects
		//Task task_list[] = new Task[jello.getTask().length]
		//for(int i = 0; i < jello.getTask().length; i++) {
		//	Task task = new Task(null, jb, jello.getTask()[i]);
		//	if(task.getT_content().equals("")){
		//		continue;
		//	}
		//	add task to database
		//	new Service().addTask(task);
		//}
	}
	
}
