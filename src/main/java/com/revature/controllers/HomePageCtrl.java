package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageCtrl {
	//RequestMapping for controller classes
		@RequestMapping("/home")
		public ModelAndView home(){
			System.out.println("HomePageCtrl");
			return new ModelAndView("/homepage.html");
		}
		
		/*
		 * RequestMappings default to ALL REQUEST TYPES!
		 * 	-get -Read
		 * 	-post -Create	
		 * 	-put  -Update
		 * 	-delete	-Delete
		 * 	-trace
		 * 	-options
		 * 	-head
		 * 
		 */
}
