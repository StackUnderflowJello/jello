package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Board;
import com.revature.services.AppServices;

@RestController
public class RemoveBoardCtrl {

	@RequestMapping(value = "/removeBoard", method = RequestMethod.POST)
	public void removeBoard(HttpServletRequest req){
		//get board from session
		HttpSession session = req.getSession();
		Board curr = (Board) session.getAttribute("board");
		
		//cascade delete board

	//	new AppServices().removeBoard(curr);

		
		//make sure to refresh view after this
	}
	
}
