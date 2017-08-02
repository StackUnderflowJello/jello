package com.revature.dao;

import java.util.List;

import com.revature.pojo.Jello_Bite;
import com.revature.pojo.Swim_Lane;

public interface Swim_LaneDao {

    //CREATE
    public void createSwimLane(Swim_Lane swimLane);
    
    
    //READ
    public List<Jello_Bite> getAllJello_BitesBySwimLane(Swim_Lane swimLane);
    public Swim_Lane getSwimLane(Swim_Lane swimLane);
    
    //UPDATE
    public void updateSwimLane(Swim_Lane swimLane);
    
    
    //DELETE
    public void deleteSwimLane(Swim_Lane swimLane);
    
}