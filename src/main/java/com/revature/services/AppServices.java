package com.revature.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.revature.dao.BoardDao;
import com.revature.dao.HistoryDao;
import com.revature.dao.Jello_BiteDao;
import com.revature.dao.Swim_LaneDao;
import com.revature.dao.TaskDao;
import com.revature.dao.User_BoardDao;
import com.revature.dao.User_Board_IdDao;
import com.revature.dao.UsersDao;
import com.revature.dao.UsersDaoImpl;
import com.revature.pojo.Board;
import com.revature.pojo.History;
import com.revature.pojo.Jello_Bite;
import com.revature.pojo.Swim_Lane;
import com.revature.pojo.Task;
import com.revature.pojo.User_Board;
import com.revature.pojo.User_Board_Id;
import com.revature.pojo.Users;
@Component
@Service("AppService")
public class AppServices {
    
    @Autowired
    private UsersDao usersdao;
    
    @Autowired
    private BoardDao boarddao;
    
    @Autowired
    private User_Board_IdDao user_board_iddao;
    
    @Autowired
    private Jello_BiteDao jello_bitedao;
    
    @Autowired
    private Swim_LaneDao swim_lanedao;
    
    @Autowired
    private TaskDao taskdao;
    
    @Autowired
    private HistoryDao historydao;
    
    @Autowired
    private User_BoardDao user_boarddao;
    
//  private void createBoardForUser(){
//      Users user = (Users) session.getAttribute("user");
//      
//      
//  }
    
    
    
    /*
     * =====================User Services =============================
     */
    public List<User_Board> getAllBoardsByUser(Users use){
        
        return usersdao.getAllBoardsByUser(use);
    }
    
    public void deleteUser(Users use){
        usersdao.deleteUser(use);
    }
    
    public void updateUserRoles(Users use){
        usersdao.updateUserRoles(use);
    }
    
    public void newUser(Users use){
        usersdao.newUser(use);
    }
    
    public Users getUserByEmail(Users use){
        UsersDao dao = new UsersDaoImpl();
        return dao.getUserByEmail(use);
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
    
    public void renameBoard(Board board){
    	if(user_boarddao.getUser_BoardByBoard(board).getRole().getR_id() == 1){ // What's the real value for admin
    		boarddao.adminRenameBoard(board);
    	}
    	
    	
    	// What are we going to do if they aren't an admin???
    }
    public void updateBackGround(Board board){
        boarddao.updateBackGround(board);
    }
    
    public void removeBoard(Board board){
    	if(user_boarddao.getUser_BoardByBoard(board).getRole().getR_id() == 1){ // What's the real value for admin
    		boarddao.adminRemoveBoard(board);
    	}
    	
    	
    	// What are we going to do if they aren't an admin???
    	// Change admin role for board to another user first so we can safely delete the board
    }
    
    /*
     * ====================== End Board Services ============================
     */
    
    /*
     * ======================= User_Board_Id Services ===============================
     */
    
 
  	public void addUserToBoard(User_Board_Id userBoardId){
  		 user_board_iddao.addUserToBoard(userBoardId);
  	}
  	
  	
  	public User_Board_Id getUser_Board_Id(User_Board_Id userBoardId){
  		return  user_board_iddao.getUser_Board_Id(userBoardId);
  	}
  	
  	
  	public void updateUser_Board_Id(User_Board_Id userBoardId){
  		user_board_iddao. updateUser_Board_Id(userBoardId);
  	}
  	
  	
  	public void removeUser_Board_Id(User_Board_Id userBoardId){
  		user_board_iddao.removeUser_Board_Id(userBoardId);
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
    

  	public void createSwimLane(Swim_Lane swimLane){
  		swim_lanedao.createSwimLane(swimLane);
  	}
  	
  	public List<Jello_Bite> getAllJello_BitesBySwimLane(Swim_Lane swimLane){
  		return  swim_lanedao.getAllJello_BitesBySwimLane(swimLane);
  	}
  	
  	public Swim_Lane getSwimLane(Swim_Lane swimLane){
  		return swim_lanedao.getSwimLane(swimLane);
  	}
  	

  	public void updateSwimLane(Swim_Lane swimLane){
  		swim_lanedao.updateSwimLane(swimLane);
  	}
  	
  	
  	public void deleteSwimLane(Swim_Lane swimLane){
  		swim_lanedao.deleteSwimLane(swimLane);
  	}
    
    /*
     * ====================== End Swim_Lane Services ============================
     */
    
    
    /*
     * ====================== Task Services ============================
     */
    
        public void createBiteTask(Task task){
        	taskdao.createBiteTask(task);
        }
     	
    	public void getBiteTask(Task task){
    		taskdao.getBiteTask(task);
    	}
     	

     	public void updateBiteTask(Task task){
     		taskdao.updateBiteTask(task);
     	}
     	
    	public void deleteBiteTask(Task task){
    		taskdao.deleteBiteTask(task);
    	}
    
    /*
     * ====================== End Task Services ============================
     */
    
    	
    /*
     * ====================== History Services ============================
     */
    	
    	
    	public void saveHistory(History history){
    		historydao.saveHistory(history);
    	}
    	
    	
    	public History getHistory(History history){
    		return historydao.getHistory(history);
    	}
    	
    	
    	public void updateHistory(History history){
    		historydao.updateHistory(history);
    	}
    	
    	
    	public void removeHistory(History history){
    		historydao.removeHistory(history);
    	}
    	
    	
    /*
     * ====================== End History Services ============================
     */
    
}