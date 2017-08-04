package com.revature.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Board;
import com.revature.pojo.Roles;
import com.revature.pojo.User_Board;


@Repository
@Component
public class User_BoardDaoImpl implements User_BoardDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUserToBoard(User_Board user_board) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user_board);
		
	}

	@Override
	public Roles getRoleForUserOnBoard(User_Board user_board) {
		User_Board retBoard;
		
		Session session = sessionFactory.getCurrentSession();
		retBoard = (User_Board) session.get(User_Board.class, user_board.getB_id());
		return retBoard.getRole();
	}

	@Override
	public User_Board getUser_BoardByBoard(Board board) {
		Session session = sessionFactory.getCurrentSession();
		return (User_Board) session.get(User_Board.class, board.getB_id());
	}
	
	@Override
	public void updateUserRoleOnBoard(User_Board user_board) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user_board);
		
	}

	@Override
	public void removeUserFromBoard(User_Board user_board) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(user_board);		
	}
}