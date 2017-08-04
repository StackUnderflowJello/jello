package com.revature.dao;

import static org.hibernate.criterion.Restrictions.eq;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Jello_Bite;
import com.revature.pojo.Task;

@Repository
@Component
public class TaskDaoImpl implements TaskDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    
    @Override
    public void createBiteTask(Task task) {
        Session session = sessionFactory.getCurrentSession();
        session.save(task);
    }
    
    @Override
    public void updateBiteTask(Task task) {
        Session session = sessionFactory.getCurrentSession();
        session.update(task);
    }

    @Override
    public void getBiteTask(Task task) {
        Session session = sessionFactory.getCurrentSession();
        session.get(Task.class, task.getT_id());
    }

    @Override
    public void deleteBiteTask(Task task) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(task);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> getTasksByJelloBiteId(Jello_Bite jello_bite) {
		Session session = sessionFactory.getCurrentSession();
		
		Criteria crit = session.createCriteria(Task.class);
		crit.createAlias("jello_bite", "jb");
		crit.add(eq("jb.bite_id", jello_bite.getBite_id()));
		
		return (List<Task>) crit.list();
	}

}
