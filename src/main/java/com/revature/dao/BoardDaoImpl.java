package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Board;
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

}
