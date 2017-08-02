package com.revature.dao;

import static org.hibernate.criterion.Restrictions.ilike;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Board;
import com.revature.pojo.Swim_Lane;
import com.revature.pojo.User_Board;

@Repository
@Component
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void createBoard(Board board) {
		Session session = sessionFactory.getCurrentSession();
		session.save(board);
	}
	
	@Override
	public Board getBoard(Board board) {
		Session session = sessionFactory.getCurrentSession();
		return (Board) session.get(Board.class, board.getB_id());
	}
	
	@Override
	public void adminRenameBoard(Board board) {
		Session session = sessionFactory.getCurrentSession();
		session.update(board);
	}
	
	@Override
	public void adminRemoveBoard(Board board) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(board);		
	}
	
	

	// This will be optional at the moment, but would be a nice feature to stand out
	@Override
	public void updateBackGround(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Swim_Lane getFirstSwimLaneByBoard(Board board) {
		Session session = sessionFactory.getCurrentSession();
		
		Criteria crit = session.createCriteria(Swim_Lane.class);
		crit.add(ilike("B_ID", board.getB_id()));
		
		return (Swim_Lane) crit.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Swim_Lane> getAllSwimLaneByBoard(Board board) {
		Session session = sessionFactory.getCurrentSession();
		
		Criteria crit = session.createCriteria(Swim_Lane.class);
		crit.add(ilike("B_ID", board.getB_id()));
		
		return (List<Swim_Lane>) crit.list();
	}

}
