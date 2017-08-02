package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UsersDao;
import com.revature.pojo.User_Board;
import com.revature.dao.BoardDao;
import com.revature.dao.Jello_BiteDao;
import com.revature.dao.Swim_LaneDao;
import com.revature.dao.TaskDao;
import com.revature.dao.User_Board_IdDao;
import com.revature.dao.UsersDao;
import com.revature.pojo.Board;
import com.revature.pojo.Jello_Bite;
import com.revature.pojo.Swim_Lane;
import com.revature.pojo.Task;
import com.revature.pojo.User_Board;
import com.revature.pojo.User_Board_Id;
import com.revature.pojo.Users;

@Service("AppService")
public class AppServices {
	
	@Autowired
	private UsersDao usersDao;
	private BoardDao boarddao;
	private User_Board_IdDao user_board_id;
	private Jello_BiteDao jello_bitedao;
	private Swim_LaneDao swim_lanedao;
	private TaskDao taskdao;
	
//	private void createBoardForUser(){
//		Users user = (Users) session.getAttribute("user");
//		
//		
//	}
	
	
	
	/*
	 * =====================User Services =============================
	 */

	public List<User_Board> getAllBoardsByUser(Users use){
		
		return usersDao.getAllBoardsByUser(use);
	}
	
	public void deleteUser(Users use){
		usersDao.deleteUser(use);
	}
	
	public void updateUserRoles(Users use){
		usersDao.updateUserRoles(use);
	}
	
	public void newUser(Users use){
		usersDao.newUser(use);
	}
	
	public Users getUserByEmail(Users use){
		return usersDao.getUserByEmail(use);
	}
	/*
	 * ======================== End User Services ==========================
	 */
	

	/*
	 * ======================= Board Services ===============================
	 */
	

	public void createBoard(Board board){
		boarddao.createBoard(board);
	}
	
	public Board getBoard(Board board){
		return boarddao.getBoard(board);
	}
	public Swim_Lane getFirstSwimLaneByBoard(Board board){
		return boarddao.getFirstSwimLaneByBoard(board);
	}
	public List<Swim_Lane> getAllSwimLaneByBoard(Board board){
		return boarddao.getAllSwimLaneByBoard(board);
	}
	
	public void adminRenameBoard(Board board){
		boarddao.adminRenameBoard(board);
	}
	public void updateBackGround(Board board){
		boarddao.updateBackGround(board);
	}
	
	public void adminRemoveBoard(Board board){
		boarddao.adminRemoveBoard(board);
	}
	
	/*
	 * ====================== End Board Services ============================
	 */

	
	/*
	 * ======================= User_Board_Id Services ===============================
	 */
	
	
	public void addUserToBoard(User_Board_Id userBoardId){
		user_board_id.addUserToBoard(userBoardId);
	}
	
	/*
	 * ======================= End User_Board_Id Services ===============================
	 */
	
	
	
	/*
	 * ====================== Jello_Bite Services ============================
	 */
	
	public void createBite(Jello_Bite bite){
		jello_bitedao.createBite(bite);
	}
	
	public List<Task> getTasksByJelloBiteId(Jello_Bite jello_bite){
		return jello_bitedao.getTasksByJelloBiteId(jello_bite);
	}
	
	public void moveBite(Jello_Bite bite){
		jello_bitedao.moveBite(bite);
	}

	public void removeBite(Jello_Bite bite){
		jello_bitedao.removeBite(bite);
	}
	
	/*
	 * ====================== End Jello_Bite Services ============================
	 */
	
	
	/*
	 * ====================== Swim_Lane Services ============================
	 */
	
		public List<Jello_Bite> getAllJello_BitesBySwimLane(Swim_Lane swimLane){
			return swim_lanedao.getAllJello_BitesBySwimLane(swimLane);
		}
		
		public void moveJelloBite(Swim_Lane swimLane){
			swim_lanedao.moveJelloBite(swimLane);
		}
	
	
		//there is no daoimpl yet for swim_lane
	
	/*
	 * ====================== End Swim_Lane Services ============================
	 */
	
	
	/*
	 * ====================== Task Services ============================
	 */
	
		public void createBiteTask(Task task){
			taskdao.createBiteTask(task);
		}
		
		public void updateBiteTask(Task task){
			taskdao.updateBiteTask(task);
		}
	
	/*
	 * ====================== End Task Services ============================
	 */
	
	
}