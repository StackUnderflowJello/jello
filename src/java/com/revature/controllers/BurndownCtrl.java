package com.revature.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
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
	
	/**
	 * 	Loads the history for the current board into the burndown chart
	 * @param req
	 * @return the history for the current board in json format
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value="/static/chart", method=RequestMethod.GET)
	public @ResponseBody String burnDown(HttpServletRequest req) throws JsonProcessingException{
		//HttpSession httpSession = req.getSession(); //Gets the current session
		//Board board = (Board) httpSession.getAttribute("board"); //Grabs the board for the current session
		Board board = new Board(1, "Jello"); // test value
		
		List<History> historyList = appServices.getHistoryByBoard(board); //Gets the history db as a list for the current board
		List<HistoryDTO> json = new ArrayList<>(); //creates the list to be returned
		Collections.sort(historyList, History.histDateComparator); //sorts the history list by date
		TreeMap<String, Integer> historyMap = new TreeMap<>(); //creates a treeMap to put each date and the points remaining for that day inside
		//loops through historyList
		for(History history : historyList){
			//Checks if the map currently has an item with the current item's date
			if(historyMap.containsKey(history.getAction_date())){
				//checks if new bite was created
				if(history.getSwim_Lane_Type() == null && history.getSwim_Lane_Type_new().getCol_id() == 1){
					historyMap.replaceAll((key, value) -> value + history.getJello_bite().getJello_point());//refactors map so its as if the new bite was created on day one
				//checks if bite was moved into completed lane
				}else if(history.getSwim_Lane_Type().getCol_id() != 5 && history.getSwim_Lane_Type_new().getCol_id() == 5){
					historyMap.replace(history.getAction_date(), historyMap.get(history.getAction_date())-history.getJello_bite().getJello_point());//decrements the points remaining by value of bite
				//checks if bite was moved back out of completed
				}else if(history.getSwim_Lane_Type().getCol_id() == 5 && history.getSwim_Lane_Type_new().getCol_id() != 5){
					ListIterator<History> itr = historyList.listIterator(historyList.indexOf(history));//creates iterator of list up to current point
					//loops while list has previous item
					while(itr.hasPrevious()){
						History hist = itr.previous();//sets variable to previous item in list
						//checks of id of current bite matches id of previous bite being moved
						if(history.getJello_bite().getBite_id() == (hist.getJello_bite().getBite_id())){
							historyMap.tailMap(hist.getAction_date()).replaceAll((key, value) -> value + history.getJello_bite().getJello_point());//increments all past days values from when bite was moved into completed, makes it as if bite was never in completed in first case
							break;//closes out of loop
						}
					}
				}
			}else{
				//checks if map has values is empty
				if(historyMap.size() == 0){
					//initializes the first day of the tree map
					historyMap.put(history.getAction_date(), 0);
				}else{
					//initializes a new day in the tree map and the current points remaining as the last day with a change
					historyMap.put(history.getAction_date(), historyMap.get(historyMap.lastKey()));
				}
				//checks if new bite was created
				if(history.getSwim_Lane_Type() == null && history.getSwim_Lane_Type_new().getCol_id() == 1){
					historyMap.replaceAll((key, value) -> value + history.getJello_bite().getJello_point());//refactors map so its as if the new bite was created on day one
				//checks if bite was moved into completed lane
				}else if(history.getSwim_Lane_Type().getCol_id() != 5 && history.getSwim_Lane_Type_new().getCol_id() == 5){
					historyMap.replace(history.getAction_date(), historyMap.get(history.getAction_date())-history.getJello_bite().getJello_point());//decrements the points remaining by value of bite
				//checks if bite was moved back out of completed
				}else if(history.getSwim_Lane_Type().getCol_id() == 5 && history.getSwim_Lane_Type_new().getCol_id() != 5){
					ListIterator<History> itr = historyList.listIterator(historyList.indexOf(history));//creates iterator of list up to current point
					//loops while list has previous item
					while(itr.hasPrevious()){
						History hist = itr.previous();//sets variable to previous item in list
						//checks of id of current bite matches id of previous bite being moved
						if(history.getJello_bite().getBite_id() == (hist.getJello_bite().getBite_id())){
							historyMap.tailMap(hist.getAction_date()).replaceAll((key, value) -> value + history.getJello_bite().getJello_point());//increments all past days values from when bite was moved into completed, makes it as if bite was never in completed in first case
							break;//closes out of loop
						}
					}
				}
			}
		}
		LocalDate tempDate = LocalDate.parse(historyMap.firstKey());//Creates date object equal to first item in map
		LocalDate today = LocalDate.now();//creates date object equal to current date
		LocalDate finalDate = tempDate.plusDays(14);//creates final date object, equal to 2 weeks after start of first item in map
		int currPoints = historyMap.get(tempDate.toString());//sets currPoints equal to points on first day of sprint(max points)
		//loops through map one day at a time until it hits either the current day or the end of the sprint
		for(; (tempDate.isBefore(today) || tempDate.isEqual(today)) && (tempDate.isBefore(finalDate) || tempDate.isEqual(finalDate)); tempDate = tempDate.plusDays(1)){
			//checks if day exists in map
			if(historyMap.containsKey(tempDate.toString())){
				currPoints = historyMap.get(tempDate.toString());//sets currPoints equal to points on tempDay
				json.add(new HistoryDTO(tempDate.toString(), currPoints));//adds to json tempDay and points on tempDay
			}else{
				json.add(new HistoryDTO(tempDate.toString(), currPoints));//adds to json tempDay and points on tempDay, for when no jello bites were moved on day
			}
		}
		ObjectMapper mapper = new ObjectMapper();
		String returnedJson = mapper.writeValueAsString(json);
		return returnedJson;
	}
}
