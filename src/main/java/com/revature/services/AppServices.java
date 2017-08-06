package com.revature.services;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.BoardDao;
import com.revature.dao.HistoryDao;
import com.revature.dao.Jello_BiteDao;
import com.revature.dao.Swim_LaneDao;
import com.revature.dao.TaskDao;
import com.revature.dao.User_BoardDao;
import com.revature.dao.UsersDao;
import com.revature.pojo.Board;
import com.revature.pojo.History;
import com.revature.pojo.Jello_Bite;
import com.revature.pojo.Roles;
import com.revature.pojo.Swim_Lane;
import com.revature.pojo.Task;
import com.revature.pojo.User_Board;
import com.revature.pojo.Users;


@Service("AppService")
@Transactional
public class AppServices {
    
    @Autowired
    private UsersDao usersdao;
    
    @Autowired
    private BoardDao boarddao;
    
    @Autowired
    private User_BoardDao user_boarddao;
    
    @Autowired
    private Jello_BiteDao jello_bitedao;
    
    @Autowired
    private Swim_LaneDao swim_lanedao;
    
    @Autowired
    private TaskDao taskdao;
    
    @Autowired
    private HistoryDao historydao;
    
 
    /*
     * =====================User Services =============================
     */
    /**
     * Tested and working by:Jonny
     * @param use
     */
    public void deleteUser(Users use){
        usersdao.deleteUser(use);
    }
    

    /**
     *  Changed method name because can't update role in user
     * @param use
     */
    public void updateUser(Users use){
        usersdao.updateUser(use);
    }
    
    /**
     * Tested and working by:Jonny
     * @param use
     */
    public void newUser(Users use){
        usersdao.newUser(use);
    }

    public Users getUserByEmail(Users use){
        return usersdao.getUserByEmail(use);
    }
    
    public List<Users> getAllUsers(){
        return usersdao.getAllUsers();
    }
    /*
     * ======================== End User Services ==========================
     */
    
    /*
     * ======================= Board Services ===============================
     */
    public List<Board> getAllBoardsByUser(Users use){
        
        return boarddao.getAllBoardsByUser(use);
    }
    
    public void createBoard(Board board){
        boarddao.createBoard(board);
    }
    
    public Board getBoard(Board board){
        return boarddao.getBoard(board);
    }
    
    public void adminRenameBoard(Board board){
        boarddao.adminRenameBoard(board);
        /*if(user_boarddao.getUser_BoardByBoard(board).getRole().getR_id() == 1){ // What's the real value for admin
            boarddao.adminRenameBoard(board);
        }*/
        
        // What are we going to do if they aren't an admin???
    }
    public void updateBackGround(Board board){
        boarddao.updateBackGround(board);
    }
    
    public void adminRemoveBoard(Board board){
        boarddao.adminRemoveBoard(board);
       /* if(user_boarddao.getUser_BoardByBoard(board).getRole().getR_id() == 1){ // What's the real value for admin
            boarddao.adminRemoveBoard(board);
        }*/
        
        
        // What are we going to do if they aren't an admin???
        // Change admin role for board to another user first so we can safely delete the board
    }
    
    /*
     * ====================== End Board Services ============================
     */
    
    /*

     * ======================= User_Board Services ===============================
     */
    
 
  	public void addUserToBoard(User_Board userBoard){
  		 user_boarddao.addUserToBoard(userBoard);
  		/* if(user_boarddao.getUser_BoardByBoard(board).getRole().getR_id() == 1){ // What's the real value for admin
         boarddao.adminRemoveBoard(board); }*/
  	}
  	
  	
  	public Roles getUserBoardRole(User_Board userBoard){
  		return  user_boarddao.getRoleForUserOnBoard(userBoard);
  	}
  	
  	
  	public void updateUser_Board(User_Board userBoard){
  		user_boarddao.updateUserRoleOnBoard(userBoard);
  	}
  	
  	
  	public void removeUser_Board(User_Board userBoard){
  		user_boarddao.removeUserFromBoard(userBoard);
  		/* if(user_boarddao.getUser_BoardByBoard(board).getRole().getR_id() == 1){ // What's the real value for admin
        boarddao.adminRemoveBoard(board); }*/
  	}
    
    
    
    /*
     * ======================= End User_Board Services ===============================
     */
    
    
    
    /*
     * ====================== Jello_Bite Services ============================
     */
    
    public void createBite(Jello_Bite bite){
        jello_bitedao.createBite(bite);
    }
    
    public void moveBite(Jello_Bite bite){
        jello_bitedao.moveBite(bite);
    }
    public void removeBite(Jello_Bite bite){
        jello_bitedao.removeBite(bite);
    }
  	
  	public List<Jello_Bite> getAllJello_BitesBySwimLane(Swim_Lane swimLane){
  		return  jello_bitedao.getAllJello_BitesBySwimLane(swimLane);
  	}
    
    /*
     * ====================== End Jello_Bite Services ============================
     */
    
    
    /*
     * ====================== Swim_Lane Services ============================
     */
    public Swim_Lane getFirstSwimLaneByBoard(Board board){
        return swim_lanedao.getFirstSwimLaneByBoard(board);
    }
    public List<Swim_Lane> getAllSwimLaneByBoard(Board board){
        return swim_lanedao.getAllSwimLaneByBoard(board);
    }
    

  	public void createSwimLane(Swim_Lane swimLane){
  		swim_lanedao.createSwimLane(swimLane);
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
    
    public List<Task> getTasksByJelloBiteId(Jello_Bite jello_bite){
    	return taskdao.getTasksByJelloBiteId(jello_bite);
    }
    
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
    	
    	public List<History>getHistoryByBoard(Board board){
    		List<History> histList = new ArrayList<History>();
    		List<Swim_Lane> slList = swim_lanedao.getAllSwimLaneByBoard(board);
    		List<Jello_Bite> jbList = new ArrayList<Jello_Bite>();
    		for(Swim_Lane swimmer : slList){
    			jbList.addAll(jello_bitedao.getAllJello_BitesBySwimLane(swimmer));
    		}
    		for(Jello_Bite jbite : jbList){
    			histList.addAll(historydao.getHistoryByJello_Bite(jbite));
    		}
    		return histList;
    	}
    	
    	
    	public void removeHistory(History history){
    		historydao.removeHistory(history);
    	}
    	
    	
    /*
     * ====================== End History Services ============================
     */
    
}
