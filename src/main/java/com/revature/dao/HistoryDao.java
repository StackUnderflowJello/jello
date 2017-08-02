package com.revature.dao;

import com.revature.pojo.History;

public interface HistoryDao {

    //CREATE
    public void saveHistory(History history);
    
    //READ
    public History getHistory(History history);
    
    //UPDATE
    public void updateHistory(History history);
    
    //DELETE
    public void removeHistory(History history);
}