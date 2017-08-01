package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class User_Board_IdDaoImpl implements User_Board_IdDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUserToBoard(User_Board_IdDao userBoardId) {
		Session session = sessionFactory.getCurrentSession();
		session.save(userBoardId);
	}

	
}
