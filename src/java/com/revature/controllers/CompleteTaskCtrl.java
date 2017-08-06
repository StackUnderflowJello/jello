package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.TaskyDTO;
import com.revature.pojo.Task;
import com.revature.services.AppServices;

@RestController
public class CompleteTaskCtrl {
	
	@Autowired
	private AppServices appServices;

	@RequestMapping(value = "/completeTask", method = RequestMethod.POST)
	public void completeTask(HttpServletRequest req, @RequestBody String json) throws JsonParseException, JsonMappingException, IOException{
	
		ObjectMapper mapper = new ObjectMapper();
		TaskyDTO tasky = mapper.readValue(json, TaskyDTO.class);
		Task task = new Task();
		task.setT_id(tasky.getTaskyID());
		task.setT_isCompleted(1);
		
		appServices.updateBiteTask(task);
	}
}
