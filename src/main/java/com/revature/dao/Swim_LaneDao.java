package com.revature.dao;

import java.util.List;

import com.revature.pojo.Board;
import com.revature.pojo.Swim_Lane;
import com.revature.pojo.Swim_Lane_Type;

public interface Swim_LaneDao {

    //CREATE
    public void createSwimLane(Swim_Lane swimLane);
    
    
    public Swim_Lane getSwimLane(Swim_Lane swimLane);
	public Swim_Lane_Type getSwim_Lane_Type(Swim_Lane swimmer);
    
    //UPDATE
    public void updateSwimLane(Swim_Lane swimLane);
    
    
    //DELETE
    public void deleteSwimLane(Swim_Lane swimLane);


	public List<Swim_Lane> getAllSwimLaneByBoard(Board board);


	public Swim_Lane getFirstSwimLaneByBoard(Board board);


    
}
