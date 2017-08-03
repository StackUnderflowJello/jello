package com.revature.dao;


import static org.hibernate.criterion.Restrictions.eq;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.History;
import com.revature.pojo.Swim_Lane;

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
	public List<History> getHistoryBySwimLane(Swim_Lane swim_lane) {
		Session session = sessionFactory.getCurrentSession();
		
		Criteria crit = session.createCriteria(History.class);
		crit.createAlias("swim_lane", "sw");
		crit.add(eq("sw.lane_id", swim_lane.getLane_id()));
		
		return (List<History>) crit.list();
	}

}
