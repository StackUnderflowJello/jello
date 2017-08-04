package com.revature.dao;

import com.revature.pojo.Board;
import com.revature.pojo.Roles;
import com.revature.pojo.User_Board;

public interface User_BoardDao {

    //CREATE
    public void addUserToBoard(User_Board user_board);
    
    //READ
    public Roles getRoleForUserOnBoard(User_Board user_board);
    public User_Board getUser_BoardByBoard(Board board);
    
    //UPDATE
    public void updateUserRoleOnBoard(User_Board user_board);
    
    
    //DELETE
    public void removeUserFromBoard(User_Board user_board);
}