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
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.JellyDTO;
import com.revature.pojo.Jello_Bite;
import com.revature.pojo.Task;
import com.revature.services.AppServices;

@RestController
public class GetAllTasksByJelloBite {

	@Autowired
	private AppServices appServices;
		
	@RequestMapping(value="/getTasks", method=RequestMethod.POST)
	public @ResponseBody String getTasksByJelloBite(HttpServletRequest req, @RequestBody String json) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		JellyDTO jelly = mapper.readValue(json, JellyDTO.class);
		Jello_Bite jb = new Jello_Bite();
		jb.setBite_id(jelly.getJellyId());
		List<Task> tList = appServices.getTasksByJelloBiteId(jb);
		
		String returnedJson = mapper.writeValueAsString(tList);
		return returnedJson;
	}	
}
