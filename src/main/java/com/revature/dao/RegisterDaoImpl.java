package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Users;

@Repository
@Component
public class RegisterDaoImpl implements RegisterDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void createUser(Users user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	@Override
	public void removeUser(Users user) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(user);
	}

}
