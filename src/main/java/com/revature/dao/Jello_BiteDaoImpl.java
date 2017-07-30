package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Jello_Bite;

@Repository
@Component
public class Jello_BiteDaoImpl implements Jello_BiteDao{
	

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createBite(Jello_Bite bite) {
		Session session = sessionFactory.getCurrentSession();
		session.save(bite);
	}

	@Override
	public void removeBite(Jello_Bite bite) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(bite);		
	}

	@Override
	public void moveBite(Jello_Bite bite) {

		Session session = sessionFactory.getCurrentSession();
		session.update(bite);	
	}
}
