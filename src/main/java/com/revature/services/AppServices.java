package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UsersDao;
import com.revature.pojo.User_Board;
import com.revature.pojo.Users;

@Service("AppService")
public class AppServices {
	
	@Autowired
	private UsersDao usersDao;
	
//	private void createBoardForUser(){
//		Users user = (Users) session.getAttribute("user");
//		
//		
//	}
	
	
	
	/*
	 * =====================User Services =============================
	 */
	public List<User_Board> getAllBoardsByUser(Users use){
		
		return usersDao.getAllBoardsByUser(use);
	}
	
	public void deleteUser(Users use){
		usersDao.deleteUser(use);
	}
	
	public void updateUserRoles(Users use){
		usersDao.updateUserRoles(use);
	}
	
	public void newUser(Users use){
		usersDao.newUser(use);
	}
	
	public Users getUserByEmail(Users use){
		return usersDao.getUserByEmail(use);
	}
	
	/*
	 * ======================== End User Services ==========================
	 */
	
	
	
	
	/*
	 * ======================= Board Services ===============================
	 */
	
	
	/*
	 * ====================== End Board Services ============================
	 */
}
