package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Jello_Bite;
import com.revature.pojo.Swim_Lane;
import static org.hibernate.criterion.Restrictions.ilike;

@Repository
@Component
public class Swim_Lane_DaoImpl implements Swim_LaneDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void createSwimLane(Swim_Lane swimLane) {
        Session session = sessionFactory.getCurrentSession();
        session.save(swimLane);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Jello_Bite> getAllJello_BitesBySwimLane(Swim_Lane swimLane) {
        Session session = sessionFactory.getCurrentSession();
        
       Criteria crit = session.createCriteria(Jello_Bite.class);
        crit.add(ilike("LANE_ID", swimLane.getLane_id()));
        
       return (List<Jello_Bite>) crit.list();
    }

    @Override
    public Swim_Lane getSwimLane(Swim_Lane swimLane) {
        Session session = sessionFactory.getCurrentSession();
        return (Swim_Lane) session.get(Swim_Lane.class, swimLane.getLane_id());
    }

    @Override
    public void updateSwimLane(Swim_Lane swimLane) {

        Session session = sessionFactory.getCurrentSession();
        session.update(swimLane);
    }

    @Override
    public void deleteSwimLane(Swim_Lane swimLane) {

        Session session = sessionFactory.getCurrentSession();
        session.delete(swimLane);
    }

}
