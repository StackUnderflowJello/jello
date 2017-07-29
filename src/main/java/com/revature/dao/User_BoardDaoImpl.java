package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.pojo.User_Board;

public class User_BoardDaoImpl implements User_BoardDao{

	@Autowired
	private SessionFactory sessionFactory;

}
