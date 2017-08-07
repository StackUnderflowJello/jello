package com.revature.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Restrictions.eq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Board;
import com.revature.pojo.User_Board;
import com.revature.pojo.User_Board_Id;
import com.revature.pojo.Users;

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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Board> getAllBoards(){
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Board.class);
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Board> getAllBoardsByUser(Users use) {
		System.out.println(use + "I'm a little teapot");
		Session session = sessionFactory.getCurrentSession();
		
		Criteria crit = session.createCriteria(User_Board.class);
		crit.createAlias("ub_id.user.u_id", "usr");
		crit.add(eq("usr", use.getU_id()));
		System.out.println(crit.list() + "hello");
		Criteria crit2 = session.createCriteria(Board.class);
		for(User_Board ub : (List<User_Board>)crit.list()){
			crit2.add(eq("b_id", ub.getUB_id().getBoard().getB_id()));
		}
		System.out.println(crit2.list() + "goodbye");
		return (List<Board>) crit2.list();
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
