package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Users;


@Repository(value = "registerDaoImpl")
public class RegisterDaoImpl implements RegisterDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Integer createUser(Users user) {
		Session session = sessionFactory.getCurrentSession();
		return (Integer) session.save(user);
	}

	@Override
	public void removeUser(Users user) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(user);
	}

}
