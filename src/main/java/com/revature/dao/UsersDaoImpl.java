package com.revature.dao;

import static org.hibernate.criterion.Restrictions.ilike;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.User_Board;
import com.revature.pojo.Users;



@Repository
@Component
public class UsersDaoImpl implements UsersDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Users getUserByEmail(Users use) {
		System.out.println("Getting user my email");
		
		Session session = sessionFactory.getCurrentSession();
		
		
		Criteria crit = session.createCriteria(Users.class);
		crit.add(ilike("U_EMAIL", use.getU_email()));
		
		// Should be unique, so just return the first item in the list and cast it.
		return (Users) crit.list().get(0);
	}

	@Override
	public void newUser(Users use) {
		Session session = sessionFactory.getCurrentSession();
		session.save(use);
	}

	@Override
	public void updateUserRoles(Users use) {
		Session session = sessionFactory.getCurrentSession();
		session.update(use);
	}

	@Override
	public void deleteUser(Users use) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(use);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User_Board> getAllBoardsByUser(Users use) {
		Session session = sessionFactory.getCurrentSession();
		
		Criteria crit = session.createCriteria(User_Board.class);
		crit.add(ilike("USER_BOARD", use.getU_id()));
		
		return (List<User_Board>) crit.list();
	}

	@Override
	public void deleteUserFromBoardById(Users use) {
		System.out.println("Deleting User from board by ID");
		
		// Get session
		Session session = sessionFactory.getCurrentSession();
		
		// Make criteria since 
		Criteria crit = session.createCriteria(User_Board.class);
		crit.add(ilike("U_ID", use.getU_id()));
		
		//Get the user_board from the quered results
		User_Board ub = (User_Board) crit.list().get(0);
		
		//Remove the user from the Board
		session.delete(ub);
	}

}
