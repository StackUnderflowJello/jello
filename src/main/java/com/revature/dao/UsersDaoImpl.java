package com.revature.dao;

import static org.hibernate.criterion.Restrictions.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
		crit.add(ilike("u_email", use.getU_email()));
		// Should be unique, so just return the first item in the list and cast it.
		return (Users) crit.list().get(0);
	}

	@Override
	public void newUser(Users use) {
		Session session = sessionFactory.getCurrentSession();
		session.save(use);
	}

	@Override
	public void updateUser(Users use) {
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
		
		String sql = "SELECT * FROM User_Board WHERE"
				+ " u_id = ?";
		SQLQuery query = session.createSQLQuery(sql);
		query.setInteger(0, use.getU_id());
		
		System.out.println((List<User_Board>) query.list());
		
		return (List<User_Board>) query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Users");
		List<Users> results = query.list();
		return results;
	}

}
