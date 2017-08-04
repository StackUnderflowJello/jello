package com.revature.dao;


import static org.hibernate.criterion.Restrictions.eq;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Board;
import com.revature.pojo.Swim_Lane;
import com.revature.pojo.Swim_Lane_Type;


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

    @Override
    public Swim_Lane getSwimLane(Swim_Lane swimLane) {
        Session session = sessionFactory.getCurrentSession();
        return (Swim_Lane) session.get(Swim_Lane.class, swimLane.getLane_id());
    }

	@Override
	public Swim_Lane_Type getSwim_Lane_Type(Swim_Lane swimmer) {
		Session session = sessionFactory.getCurrentSession();
		return (Swim_Lane_Type) session.get(Swim_Lane_Type.class, swimmer.getSwim_lane_type());
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Swim_Lane> getAllSwimLaneByBoard(Board board) {
		Session session = sessionFactory.getCurrentSession();
		
		Criteria crit = session.createCriteria(Swim_Lane.class);
		crit.createAlias("board", "b");
		crit.add(eq("b.b_id", board.getB_id()));
		return (List<Swim_Lane>) crit.list();
	}

	@Override
	public Swim_Lane getFirstSwimLaneByBoard(Board board) {
		Session session = sessionFactory.getCurrentSession();
		
		Criteria crit = session.createCriteria(Swim_Lane.class);
		crit.createAlias("board", "b");
		crit.add(eq("b.b_id", board.getB_id()));
		
		return (Swim_Lane) crit.list().get(0);
	}

}
