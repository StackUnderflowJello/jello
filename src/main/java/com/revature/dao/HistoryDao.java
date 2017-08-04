package com.revature.dao;

import java.util.List;

import com.revature.pojo.History;
import com.revature.pojo.Jello_Bite;

public interface HistoryDao {

    //CREATE
    public void saveHistory(History history);
    
    //READ
    public History getHistory(History history);
    public List<History> getHistoryByJello_Bite(Jello_Bite jello_bite);
    //UPDATE
    public void updateHistory(History history);
    
    //DELETE
    public void removeHistory(History history);
}
