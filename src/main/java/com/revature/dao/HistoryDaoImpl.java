package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.pojo.History;

public class HistoryDaoImpl implements HistoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveHistory(History history) {
		Session session = sessionFactory.getCurrentSession();
		session.save(history);
	}

	@Override
	public History getHistory(History history) {
		Session session = sessionFactory.getCurrentSession();
		return (History) session.get(History.class, history.getHistory_id());
	}

	@Override
	public void updateHistory(History history) {

		Session session = sessionFactory.getCurrentSession();
		session.update(history);
	}

	@Override
	public void removeHistory(History history) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(history);
	}

}
