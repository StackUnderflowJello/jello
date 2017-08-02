package com.revature.dao;

import java.util.List;

import com.revature.pojo.Jello_Bite;
import com.revature.pojo.Swim_Lane;

public interface Swim_LaneDao {

	//CREATE
//	public void createJello_Bite
	
	
	//READ
	public List<Jello_Bite> getAllJello_BitesBySwimLane(Swim_Lane swimLane);
	
	//UPDATE
	public void moveJelloBite(Swim_Lane swimLane);
	
	
	//DELETE
}
