package com.revature.dao;

import java.util.List;

import com.revature.pojo.Jello_Bite;
import com.revature.pojo.Swim_Lane;

public interface Jello_BiteDao {

	//CREATE
	public void createBite(Jello_Bite bite);

	//READ
	public List<Jello_Bite> getAllJello_BitesBySwimLane(Swim_Lane swimLane);
	
	//UPDATE
	public void moveBite(Jello_Bite bite);
	
	//DELETE
	public void removeBite(Jello_Bite bite);
	
}
