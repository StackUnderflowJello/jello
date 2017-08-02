package com.revature.dao;

import com.revature.pojo.Board;

public interface User_BoardDao {

    //CREATE
    public void createBoard(Board board);
    
    //READ
    public String getBoardName(Board board);
    
    //UPDATE
    public void changeBoardName(Board board);
    
    
    //DELETE
    public void deleteBoard(Board board);
}