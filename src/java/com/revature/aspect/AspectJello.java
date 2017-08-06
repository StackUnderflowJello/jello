package com.revature.aspect;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.revature.pojo.Board;
import com.revature.pojo.History;
import com.revature.pojo.Jello_Bite;
import com.revature.pojo.Roles;
import com.revature.pojo.Swim_Lane;
import com.revature.pojo.Task;
import com.revature.pojo.User_Board;
import com.revature.pojo.User_Board_Id;
import com.revature.pojo.Users;
import com.revature.services.AppServices;

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
	 * logging method saveHistory(),
	 * updateHistory(),
	 * removeHistory(),
	 * 
	 * @param jp
	 */
	@Before("execution(* com.revature.dao.HistoryDaoImpl.saveHistory(..))")
	public void hijackSaveHistory(JoinPoint jp){
		History hist = (History) jp.getArgs()[0];
		System.out.println("History saved: " + hist.getHistory_id());
		logger.info("History saved: " + hist.getHistory_id());
	}
	
	@Before("execution(* com.revature.dao.HistoryDaoImpl.updateHistory(..))")
	public void hijackUpdateHistory(JoinPoint jp){
		History hist = (History) jp.getArgs()[0];
		System.out.println("History Updated: " + hist.getHistory_id());
		logger.info("History Upadated: " + hist.getHistory_id());
	}
	
	@Before("execution(* com.revature.dao.HistoryDaoImpl.removeHistory(..))")
	public void hijackRemoveHistory(JoinPoint jp){
		History hist = (History) jp.getArgs()[0];
		System.out.println("History Removed: " + hist.getHistory_id());
		logger.info("History Removed: " + hist.getHistory_id());
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
	 * logging the createSwimLane(),
	 * updateSwimLane(),
	 * deleteSwimLane(),
	 * @param jp
	 */

	@Before("execution(* com.revature.dao.Swim_Lane_DaoImpl.createSwimLane(..))")
	public void hijackCreateSwimLane(JoinPoint jp){
		Swim_Lane swimLane = (Swim_Lane) jp.getArgs()[0];
		System.out.println("Swim Lane Created : " + swimLane.getLane_id() );
		logger.info("Swim Lane Created: " + swimLane.getLane_id());
	}
	
	@Before("execution(* com.revature.dao.Swim_Lane_DaoImpl.updateSwimLane(..))")
	public void hijackUpdateSwimLane(JoinPoint jp){
		Swim_Lane swimLane = (Swim_Lane) jp.getArgs()[0];
		System.out.println("Swim Lane Updated: " + swimLane.getLane_id() );
		logger.info("Swim Lane Updated: " + swimLane.getLane_id());
	}
	
	@Before("execution(* com.revature.dao.Swim_Lane_DaoImpl.deleteSwimLane(..))")
	public void hijackDeleteSwimLane(JoinPoint jp){
		Swim_Lane swimLane = (Swim_Lane) jp.getArgs()[0];
		System.out.println("Swim Lane deleted: " + swimLane.getLane_id() );
		logger.info("Swim Lane deleted: " + swimLane.getLane_id());
	}
	
	
	/**
	 * logging the createBiteTask(),
	 * updateBiteTask(),
	 * deleteBiteTask()
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
	
	@Before("execution(* com.revature.dao.TaskDaoImpl.deleteBiteTask(..))")
	public void hijackDeleteBiteTask(JoinPoint jp){
		Task task = (Task) jp.getArgs()[0];
		System.out.println("Tasked Deleted: " + task.getT_id() + " " + task.getT_content());
		logger.info("Tasked Deleted: " + task.getT_id() + " " + task.getT_content());
	}
			
	/**
	 * logging the createBoard(),
	 * changeBoardName(),
	 * deleteBoardName()
	 * @param jp
	 */
	
	@Before("execution(* com.revature.dao.User_BoardDaoImpl.addUserToBoard(..))")
	public void hijackAddUserToBoard(JoinPoint jp){
		User_Board user_board = (User_Board) jp.getArgs()[0];
		System.out.println("User Board Created: " + user_board.getUB_id() + " " + user_board.getRole());
		logger.info("User Board Created: " + user_board.getUB_id() + " " + user_board.getRole());
	}
	
	@Before("execution(* com.revature.dao.User_BoardDaoImpl.updateUserRoleOnBoard(..))")
	public void hijackUpdateUserRoleBoard(JoinPoint jp){
		User_Board user_board = (User_Board) jp.getArgs()[0];
		System.out.println("User Board Name Changed: " + user_board.getUB_id() + " " + user_board.getRole());
		logger.info("User Board Name Change: " + user_board.getUB_id() + " " + user_board.getRole());
	}
	
	@Before("execution(* com.revature.dao.User_BoardDaoImpl.removeUserFromBoard(..))")
	public void hijackRemoveUserFromBoard(JoinPoint jp){
		User_Board user_board = (User_Board) jp.getArgs()[0];
		System.out.println("User Board Deleted: " + user_board.getUB_id() + " " + user_board.getRole());
		logger.info("User Board Deleted: " + user_board.getUB_id() + " " + user_board.getRole());
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
	
	@Before("execution(* com.revature.dao.UsersDaoImpl.updateUser(..))")
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
	
	/**
	 * logging methods createUser(),
	 * removeUser()
	 * @param args
	 */
	
	@Before("execution(* com.revature.dao.RegisterDaoImpl.createUser(..))")
	public void hijackRegisterCreateUser(JoinPoint jp){
		Users usr = (Users) jp.getArgs()[0];
		System.out.println("Users registered" + usr.getU_email() + " " + usr.getU_password());
		logger.info("Users registered" + usr.getU_email() + " " + usr.getU_password());
		
	}
	
	@Before("execution(* com.revature.dao.RegisterDaoImpl.removeUser(..))")
	public void hijackRegisterRemoveUser(JoinPoint jp){
		Users usr = (Users) jp.getArgs()[0];
		System.out.println("User removed: " + usr.getU_email());
		logger.info("User removed: " + usr.getU_email());
		
	}
		
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		AppServices app = (AppServices) ac.getBean("AppService");
		
		Users usr = new Users();
		Board brd = new Board();
		User_Board userBoard = new User_Board();
		User_Board_Id userBoardId = new User_Board_Id();
		Roles userRole = new Roles();
		List<History> history = new ArrayList<>();
		
		usr.setU_email("tom@java.com");
		usr.setU_password("123");
		usr.setU_id(4);
		
		//app.newUser(usr);
		
		userRole.setR_id(1);
		
		brd.setB_id(1);
		brd.setB_name("Speedo");
		//app.createBoard(brd);
		
		userBoardId.setBoard(brd);
		userBoardId.setUser(usr);
		
		userBoard.setUB_id(userBoardId);
		userBoard.setRole(userRole);
		//app.addUserToBoard(userBoard);
		history = app.getHistoryByBoard(brd);
		
		
		System.out.println(usr);
		System.out.println(brd);
		System.out.println(userBoardId);
		System.out.println(userBoard);
		System.out.println(history);
		//app.updateUser_Board_Id(userBoardId);
		
	}
		
	
	}
