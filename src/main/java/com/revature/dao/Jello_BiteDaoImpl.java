package com.revature.dao;

import static org.hibernate.criterion.Restrictions.eq;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Jello_Bite;
import com.revature.pojo.Swim_Lane;

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

	@SuppressWarnings("unchecked")
    @Override
    public List<Jello_Bite> getAllJello_BitesBySwimLane(Swim_Lane swimLane) {
        Session session = sessionFactory.getCurrentSession();
        
       Criteria crit = session.createCriteria(Jello_Bite.class);
		crit.createAlias("swim_lane", "sl");
        crit.add(eq("sl.lane_id", swimLane.getLane_id()));
        
       return (List<Jello_Bite>) crit.list();
    }
}
