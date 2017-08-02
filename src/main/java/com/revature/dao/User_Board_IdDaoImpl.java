package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.pojo.User_Board_Id;

public class User_Board_IdDaoImpl implements User_Board_IdDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUserToBoard(User_Board_Id userBoardId) {
		Session session = sessionFactory.getCurrentSession();
		session.save(userBoardId);
	}

	@Override
	public User_Board_Id getUser_Board_Id(User_Board_Id userBoardId) {
		Session session = sessionFactory.getCurrentSession();
		return (User_Board_Id) session.get(User_Board_Id.class, userBoardId.getUser());
	}

	@Override
	public void updateUser_Board_Id(User_Board_Id userBoardId) {
		Session session = sessionFactory.getCurrentSession();
		session.update(userBoardId);
	}

	@Override
	public void removeUser_Board_Id(User_Board_Id userBoardId) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(userBoardId);		
	}

	
}
