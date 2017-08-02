package com.revature.dao;

import javax.transaction.Transactional;

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