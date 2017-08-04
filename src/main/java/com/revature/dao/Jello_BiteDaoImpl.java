package com.revature.dao;

import static org.hibernate.criterion.Restrictions.ilike;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Jello_Bite;
import com.revature.pojo.Task;
import com.revature.pojo.User_Board;

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
	public List<Task> getTasksByJelloBiteId(Jello_Bite jello_bite) {
		Session session = sessionFactory.getCurrentSession();
		
		Criteria crit = session.createCriteria(Task.class);
		crit.add(ilike("BITE_ID", jello_bite.getBite_id()));
		
		return (List<Task>) crit.list();
	}
}
