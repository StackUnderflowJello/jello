package com.revature.dao;


import static org.hibernate.criterion.Restrictions.eq;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.History;
import com.revature.pojo.Jello_Bite;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<History> getHistoryByJello_Bite(Jello_Bite jello_bite) {
		Session session = sessionFactory.getCurrentSession();
		
		Criteria crit = session.createCriteria(History.class);
		crit.createAlias("jello_bite", "jb");
		crit.addOrder(Order.asc("action_date"));
		crit.addOrder(Order.asc("history_id"));
		crit.add(eq("jb.bite_id", jello_bite.getBite_id()));
		
		return (List<History>) crit.list();
	}

}
