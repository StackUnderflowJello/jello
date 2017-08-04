package com.revature.dao;

import java.util.List;

import com.revature.pojo.Jello_Bite;
import com.revature.pojo.Task;

public interface Jello_BiteDao {

	//CREATE
	public void createBite(Jello_Bite bite);
	
	//READ
	public List<Task> getTasksByJelloBiteId(Jello_Bite jello_bite);
	
	//UPDATE
	public void moveBite(Jello_Bite bite);
	
	//DELETE
	public void removeBite(Jello_Bite bite);
}
