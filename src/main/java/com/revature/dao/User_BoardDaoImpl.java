package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.pojo.Board;


public class User_BoardDaoImpl implements User_BoardDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createBoard(Board board) {
		Session session = sessionFactory.getCurrentSession();
		session.save(board);
		
	}

	@Override
	public String getBoardName(Board board) {
		Board retBoard;
		
		Session session = sessionFactory.getCurrentSession();
		retBoard = (Board) session.get(Board.class, board.getB_id());
		return retBoard.getB_name();
	}

	@Override
	public void changeBoardName(Board board) {
		Session session = sessionFactory.getCurrentSession();
		session.update(board);
		
	}

	@Override
	public void deleteBoard(Board board) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(board);		
	}

	
}