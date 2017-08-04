package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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

}
