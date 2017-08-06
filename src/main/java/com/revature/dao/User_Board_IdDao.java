package com.revature.dao;

import com.revature.pojo.User_Board_Id;

public interface User_Board_IdDao {

    //CREATE
    public void addUserToBoard(User_Board_Id userBoardId);
    
    //READ
    public User_Board_Id getUser_Board_Id(User_Board_Id userBoardId);
    
    //UPDATE
    public void updateUser_Board_Id(User_Board_Id userBoardId);
    
    //DELETE
    public void removeUser_Board_Id(User_Board_Id userBoardId);
}
