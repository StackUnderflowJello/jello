package com.revature.dao;

import java.util.List;

import com.revature.pojo.Jello_Bite;
import com.revature.pojo.Task;

public interface TaskDao {

    //CREATE
    public void createBiteTask(Task task);
    
    //READ
    public void getBiteTask(Task task);
    
    
    //UPDATE
    public void updateBiteTask(Task task);
    
    //DELETE
    public void deleteBiteTask(Task task);

	//READ
	public List<Task> getTasksByJelloBiteId(Jello_Bite jello_bite);
}
