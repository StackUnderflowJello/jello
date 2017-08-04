package com.revature.dao;

import java.util.List;

import com.revature.pojo.History;
import com.revature.pojo.Swim_Lane;

public interface HistoryDao {

    //CREATE
    public void saveHistory(History history);
    
    //READ
    public History getHistory(History history);
    public List<History> getHistoryBySwimLane(Swim_Lane swim_lane);
    //UPDATE
    public void updateHistory(History history);
    
    //DELETE
    public void removeHistory(History history);
}