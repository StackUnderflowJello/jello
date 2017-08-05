package com.revature.controllers;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.MoveHistoryDTO;
import com.revature.pojo.History;
import com.revature.pojo.Jello_Bite;
import com.revature.pojo.Swim_Lane_Type;
import com.revature.services.AppServices;

@RestController
public class MoveStoryCtrl {

	@RequestMapping(value = "/moveStory", method = RequestMethod.POST)
	public void moveStory(HttpServletRequest req, @RequestBody String json) throws JsonParseException, JsonMappingException, IOException{
		//json will return the story, prev_lane_id, new_lane_id
		//get board from session
		HttpSession session = req.getSession();
//		Board curr = (Board) session.getAttribute("board");
//		List<Swim_Lane> swimlane_list = (List<Swim_Lane>) session.getAttribute("swimlane_list");
		
		//get current time
		DateTime dt = new DateTime();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-ee");
		String date = fmt.print(dt);
		
		//parse json into MoveHistory DTO
		ObjectMapper mapper = new ObjectMapper();
		MoveHistoryDTO moveHist = mapper.readValue(json, MoveHistoryDTO.class);
		
		//create prev/new swimlaneIdTypes
		Swim_Lane_Type prevLane = new Swim_Lane_Type();
		Swim_Lane_Type newLane = new Swim_Lane_Type();
		prevLane.setCol_id(moveHist.getPrev_lane_id());
		newLane.setCol_id(moveHist.getNew_lane_id());
		
		//get jello bite by story name
		Jello_Bite curr_story = new Jello_Bite();
		curr_story.setBite_name(moveHist.getStory_name());
		
		//getJelloBySwimlaneStory() => match the swimlane ids and get bite back
		
//		Jello_Bite story = new AppServices().getJelloBySwimlaneStory(curr_story);
//		History hist = new History();
//		hist.setJello_bite(story);
//		hist.setSwim_Lane_Type(prevLane);
//		hist.setSwim_Lane_Type_new(newLane);
//		hist.setAction_date(date);
		
		//add record to history table
		
//		new AppServices().addHistory(hist);
	}
	
}
