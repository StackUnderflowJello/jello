package com.revature.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.HistoryDTO;
import com.revature.pojo.Board;
import com.revature.pojo.History;
import com.revature.services.AppServices;

@RestController
public class BurndownCtrl {
	
	@Autowired
	private AppServices appServices;

	@RequestMapping(value="/burndown", method=RequestMethod.GET)
	public ModelAndView openChart(){
		return new ModelAndView("/static/fragments/burndown.html");
	}
	
	@RequestMapping(value="/static/chart", method=RequestMethod.GET)
	public @ResponseBody String burnDown(HttpServletRequest req) throws JsonProcessingException{
		HttpSession httpSession = req.getSession();
		Board board = (Board) httpSession.getAttribute("board");
		
		List<History> historyList = appServices.getHistoryByBoard(board);
		List<HistoryDTO> json = new ArrayList<>();
		Collections.sort(historyList, History.histDateComparator);
		TreeMap<String, Integer> historyMap = new TreeMap<>();
		for(History history : historyList){
			if(historyMap.containsKey(history.getAction_date())){
				if(history.getSwim_Lane_Type() == null && history.getSwim_Lane_Type_new().getCol_id() == 1){
					historyMap.replaceAll((key, value) -> value + history.getJello_bite().getJello_point());
				}else if(history.getSwim_Lane_Type().getCol_id() != 5 && history.getSwim_Lane_Type_new().getCol_id() == 5){
					historyMap.replace(history.getAction_date(), historyMap.get(history.getAction_date())-history.getJello_bite().getJello_point());
				}else if(history.getSwim_Lane_Type().getCol_id() == 5 && history.getSwim_Lane_Type_new().getCol_id() != 5){
					historyMap.replace(history.getAction_date(), historyMap.get(history.getAction_date())+history.getJello_bite().getJello_point());
				}
			}else{
				if(historyMap.size() == 0){
					historyMap.put(history.getAction_date(), 0);
				}else{
					historyMap.put(history.getAction_date(), historyMap.get(historyMap.lastKey()));
				}
				if(history.getSwim_Lane_Type() == null && history.getSwim_Lane_Type_new().getCol_id() == 1){
					historyMap.replaceAll((key, value) -> value + history.getJello_bite().getJello_point());
				}else if(history.getSwim_Lane_Type().getCol_id() != 5 && history.getSwim_Lane_Type_new().getCol_id() == 5){
					historyMap.replace(history.getAction_date(), historyMap.get(history.getAction_date())-history.getJello_bite().getJello_point());
				}else if(history.getSwim_Lane_Type().getCol_id() == 5 && history.getSwim_Lane_Type_new().getCol_id() != 5){
					historyMap.replace(history.getAction_date(), historyMap.get(history.getAction_date())+history.getJello_bite().getJello_point());
				}
			}
		}
		LocalDate tempDate = LocalDate.parse(historyMap.firstKey());
		LocalDate today = LocalDate.now();
		LocalDate finalDate = tempDate.plusDays(14);
		int currPoints = historyMap.get(tempDate.toString());
		for(; (tempDate.isBefore(today) || tempDate.isEqual(today)) && (tempDate.isBefore(finalDate) || tempDate.isEqual(finalDate)); tempDate = tempDate.plusDays(1)){
			if(historyMap.containsKey(tempDate.toString())){
				currPoints = historyMap.get(tempDate.toString());
				json.add(new HistoryDTO(tempDate.toString(), currPoints));
			}else{
				json.add(new HistoryDTO(tempDate.toString(), currPoints));
			}
		}
		ObjectMapper mapper = new ObjectMapper();
		String returnedJson = mapper.writeValueAsString(json);
		return returnedJson;
	}
}
