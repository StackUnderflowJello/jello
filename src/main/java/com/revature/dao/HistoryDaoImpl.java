<<<<<<< HEAD
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
=======
package com.revature.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.History;

@Repository
@Component
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
>>>>>>> b1ce11ba9a9950e10dde4b23d05e5a7a7a4de387
