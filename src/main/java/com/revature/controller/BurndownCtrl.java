package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.revature.dto.HistoryDTO;

@RestController
public class BurndownCtrl {

	@RequestMapping(value="/burndown", method=RequestMethod.GET)
	public ModelAndView openChart(){
		System.out.println("finding MAV");
		return new ModelAndView("/static/burndown.html");
	}
	
	@RequestMapping(value="/chart", method=RequestMethod.GET)
	public @ResponseBody List<HistoryDTO> burnDown(){
		List<HistoryDTO> json = new ArrayList<>();
		json.add(new HistoryDTO("2017-07-24", 80));
		json.add(new HistoryDTO("2017-07-25", 75));
		json.add(new HistoryDTO("2017-07-26", 70));
		//json.add(new HistoryDTO("2017-07-27", 70));
		json.add(new HistoryDTO("2017-07-28", 70));
		json.add(new HistoryDTO("2017-07-29", 68));
		json.add(new HistoryDTO("2017-07-30", 60));
		json.add(new HistoryDTO("2017-07-31", 60));
		json.add(new HistoryDTO("2017-08-01", 62));
		return json;
	}
}
