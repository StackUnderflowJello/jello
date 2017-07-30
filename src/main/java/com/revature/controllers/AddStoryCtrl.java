package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddStoryCtrl {

	@RequestMapping("/")
	public ModelAndView login(){
		System.out.println("AddStory - GET");
		return new ModelAndView("/resources/addStory.html");
	}
	
}
