package com.revature.aspect;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.revature.dao.BoardDao;
import com.revature.dao.BoardDaoImpl;
import com.revature.dao.Jello_BiteDao;
import com.revature.dao.Jello_BiteDaoImpl;
import com.revature.dao.TaskDao;
import com.revature.dao.TaskDaoImpl;
import com.revature.dao.User_BoardDao;
import com.revature.dao.User_BoardDaoImpl;
import com.revature.dao.User_Board_IdDao;
import com.revature.dao.User_Board_IdDaoImpl;
import com.revature.dao.UsersDao;
import com.revature.dao.UsersDaoImpl;
import com.revature.pojo.Board;
import com.revature.pojo.Jello_Bite;
import com.revature.pojo.Task;
import com.revature.pojo.User_Board;
import com.revature.pojo.User_Board_Id;
import com.revature.pojo.Users;

@Aspect
@Component
public class AspectJello {

	/**
	 * This is My Logger Object, I will log the information inside each hijack
	 */
	 static Logger logger = Logger.getLogger(AspectJello.class); 

	 /**
	 * logging the createBoard(),
	 * getBoard(),
	 * adminRenameBoard(),
	 * adminRemoveBoard(),
	 * @param jp
	 */
	@Before("execution(* com.revature.dao.BoardDaoImpl.createBoard(..))")
		public void hijackCreateBoard(JoinPoint jp){
			Board curr = (Board) jp.getArgs()[0];
			System.out.println("Board Created: " + curr.getB_name());
			logger.info("Board Created: " + curr.getB_name());
	}
	
	
	@Before("execution(* com.revature.dao.BoardDaoImpl.adminRenameBoard(..))")
	public void hijackAdminRenameBoard(JoinPoint jp){
		Board curr = (Board) jp.getArgs()[0];
		System.out.println("Board Created: " + curr.getB_name());
		logger.info("Board Renamed: " + curr.getB_name());
	}
	
	@Before("execution(* com.revature.dao.BoardDaoImpl.adminRemoveBoard(..))")
	public void hijackAdminRemoveBoard(JoinPoint jp){
		Board curr = (Board) jp.getArgs()[0];
		System.out.println("Board Created: " + curr.getB_name());
		logger.info("Board Removed: " + curr.getB_name());
	}
	
	/**
	 * logging the createBite(),
	 * removeBite(),
	 * moveBite(),
	 * @param jp
	 */

	@Before("execution(* com.revature.dao.Jello_BiteDaoImpl.createBite(..))")
	public void hijackCreateBite(JoinPoint jp){
		Jello_Bite jello_bite = (Jello_Bite) jp.getArgs()[0];
		System.out.println("Bite Created: " + jello_bite.getBite_name());
		logger.info("Bite Created: " + jello_bite.getBite_name());
	}
	
	@Before("execution(* com.revature.dao.Jello_BiteDaoImpl.removeBite(..))")
	public void hijackRemoveBite(JoinPoint jp){
		Jello_Bite jello_bite = (Jello_Bite) jp.getArgs()[0];
		System.out.println("Jello Bite Removed: " + jello_bite.getBite_name());
		logger.info("Jello Bite Removed: " + jello_bite.getBite_name());
	}
	
	@Before("execution(* com.revature.dao.Jello_BiteDaoImpl.moveBite(..))")
	public void hijackMoveBite(JoinPoint jp){
		Jello_Bite jello_bite = (Jello_Bite) jp.getArgs()[0];
		System.out.println("Jello Bite moved:" + jello_bite.getBite_name());
		logger.info("Jello Bite moved:" + jello_bite.getBite_name());
	}

	/**
	 * logging the createBiteTask(),
	 * updateBiteTask()
	 * @param jp
	 */
	
	@Before("execution(* com.revature.dao.TaskDaoImpl.createBiteTask(..))")
	public void hijackCreateBiteTask(JoinPoint jp){
		Task task = (Task) jp.getArgs()[0];
		System.out.println("Tasked Created: " + task.getT_id() + task.getT_content());
		logger.info("Tasked Created: " + task.getT_id() + task.getT_content());
	}
	
	@Before("execution(* com.revature.dao.TaskDaoImpl.updateBiteTask(..))")
	public void hijackUpdateBiteTask(JoinPoint jp){
		Task task = (Task) jp.getArgs()[0];
		System.out.println("Tasked Updated: " + task.getT_id() + " " + task.getT_content());
		logger.info("Tasked Updated: " + task.getT_id() + " " + task.getT_content());
	}
	
	/**
	 * logging the addUserToBoard()
	 * @param jp
	 */
	@Before("execution(* com.revature.dao.User_Board_IdDaoImpl.addUserToBoard(..))")
	public void hijackAddUserToBoard(JoinPoint jp){
		User_Board_IdDao userBoardId = (User_Board_IdDao) jp.getArgs()[0];
		System.out.println("User added to board: " + userBoardId);
		logger.info("User added to board: " + userBoardId);
	
	}
		
	/**
	 * no methods currently in the User_BoardDaoImpl
	 * @param jp
	 */
	
	@Before("execution(* com.revature.dao.User_BoardDaoImpl.*Board(..))")
	public void hijackUser_BoardDaoImpl(JoinPoint jp){
		System.out.println("Logged from User_Board Dao Impl Method");
		jp.getArgs();
	}


	/**
	 * logging the getUserbyEmail(),
	 * newUser(),
	 * updateUserRoles(),
	 * deleteUser(),
	 * 
	 * @param jp
	 */
	@Before("execution(* com.revature.dao.UsersDaoImpl.getUserByEmail(..))")
	public void hijackGetUserByEmail(JoinPoint jp){
		Users use = (Users) jp.getArgs()[0];
		System.out.println("User Traced by email: " + use.getU_email());
		logger.info("User Traced by email: " + use.getU_email());
	}
	
	@Before("execution(* com.revature.dao.UsersDaoImpl.newUser(..))")
	public void hijackNewUser(JoinPoint jp){
		Users use = (Users) jp.getArgs()[0];
		System.out.println("New User Added: " + use.getU_id() + " " + use.getU_email() + " " + use.getU_password());
		logger.info("New User Added: " + use.getU_id() + " " + use.getU_email() + " " + use.getU_password());
	}
	
	@Before("execution(* com.revature.dao.UsersDaoImpl.updateUserRoles(..))")
	public void hijackUpdateUserRoles(JoinPoint jp){
		Users use = (Users) jp.getArgs()[0];
		System.out.println("User role update: " + use.getU_id());
		logger.info("User role update: " + use.getU_id());
	}
	
	@Before("execution(* com.revature.dao.UsersDaoImpl.deleteUser(..))")
	public void hijackDeleteUser(JoinPoint jp){
		Users use = (Users) jp.getArgs()[0];
		System.out.println("User Deleted: " + use.getU_id() + " " + use.getU_email());
		logger.info("User Deleted: " + use.getU_id() + " " + use.getU_email());
	}
	
	}
