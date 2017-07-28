package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Board;
import com.revature.pojo.Jello_Bite;
import com.revature.pojo.Task;
import com.revature.pojo.User_Board;
import com.revature.pojo.Users;


@Repository
@Component
public class UsersdaoImpl implements UsersDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Users getUserByEmail(Users use) {
		System.out.println("Getting user my email");
		
		Session session = sessionFactory.getCurrentSession();
		return (Users) session.get(Users.class, use.getU_email());
	}

	@Override
	public void newUser(Users use) {
		Session session = sessionFactory.getCurrentSession();
		session.save(use);
	}

	@Override
	public void createBite(Jello_Bite bite) {
		Session session = sessionFactory.getCurrentSession();
		session.save(bite);
	}

	@Override
	public void createBiteTask(Task task) {
		Session session = sessionFactory.getCurrentSession();
		session.save(task);
	}

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
	public void addUserToBoard(User_Board user_board) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user_board);
	}

	@Override
	public void moveBite(Jello_Bite bite) {
		Session session = sessionFactory.getCurrentSession();
		session.update(bite);
	}

	@Override
	public void updateBiteTask(Task task) {
		Session session = sessionFactory.getCurrentSession();
		session.update(task);
	}

	@Override
	public void adminRenameBoard(Board board) {
		Session session = sessionFactory.getCurrentSession();
		session.update(board);
	}

	@Override
	public void removeBite(Jello_Bite bite) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(bite);		
	}

	@Override
	public void adminRemoveUser(Users use) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(use);
	}

	@Override
	public void adminRemoveBoard(Board board) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(board);		
	}





}
