package com.revature.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.BoardyDTO;
import com.revature.pojo.Board;
import com.revature.pojo.Jello_Bite;
import com.revature.pojo.Swim_Lane;
import com.revature.services.AppServices;

@RestController
public class GetAllJelloBitesByBoardCtrl {

	@Autowired
	private AppServices appServices;
	
	@RequestMapping(value="/getJelloBites", method=RequestMethod.GET)
	public @ResponseBody String getJelloBitesByBoard(HttpServletRequest req) throws JsonParseException, JsonMappingException, IOException{
		HttpSession httpSession = req.getSession();
		
//		Board brd = (Board) httpSession.getAttribute("board");
//
//		List<Swim_Lane> slList = appServices.getAllSwimLaneByBoard(brd);
//		List<List<Jello_Bite>> jbList = new ArrayList<List<Jello_Bite>>();
//		for(Swim_Lane swim : slList){
//			jbList.add(appServices.getAllJello_BitesBySwimLane(swim));
//		}
		
		Board brd = new Board();
        brd.setB_id(1);
        
        List<Swim_Lane> slList = appServices.getAllSwimLaneByBoard(brd);
        List<List<Jello_Bite>> jbList = new ArrayList<List<Jello_Bite>>();
        for(Swim_Lane swim : slList){
            System.out.println(swim);
            jbList.add(appServices.getAllJello_BitesBySwimLane(swim));
        }
        
		ObjectMapper mapper = new ObjectMapper();
		String returnedJson = mapper.writeValueAsString(jbList);
		return returnedJson;
	}	
	
	@RequestMapping(value="/getJelloBites", method=RequestMethod.POST)
	public @ResponseBody String getJelloBitesByBoard(HttpServletRequest req, @RequestBody String json) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		BoardyDTO boardy = mapper.readValue(json, BoardyDTO.class);
		Board brd = appServices.getBoard(new Board(boardy.getBoardyId(), null));
		req.getSession().setAttribute("board", brd);
		
		List<Swim_Lane> slList = appServices.getAllSwimLaneByBoard(brd);
		List<List<Jello_Bite>> jbList = new ArrayList<List<Jello_Bite>>();
		for(Swim_Lane swim : slList){
			jbList.add(appServices.getAllJello_BitesBySwimLane(swim));
		}
		String returnedJson = mapper.writeValueAsString(jbList);
		return returnedJson;
	}	
}
