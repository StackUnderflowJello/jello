package com.revature.services;
import java.util.ArrayList;
import java.util.Iterator;
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
import com.revature.pojo.User_Board_Id;
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
    
    public void removeUserFromBoards(Users user) {
    	List<User_Board> toDelete = usersdao.getAllBoardsByUser(user);
    	System.out.println(toDelete);
    	for(int i = 0; i < toDelete.size(); i++) {
    		// Unable to convert Object returned from query into User_Board
    		// Cycling through basic object and retrieving the IDs. 
    		Iterator itr = toDelete.iterator();
    		while(itr.hasNext()){
    			// Creating User_Board_Id which will take in the Users and Board 
    			User_Board_Id board_id = new User_Board_Id();
    			Board protoboard = new Board();
    			Users protouser = new Users();
    			// Creating User_Board to take in the User_Board_Id
    			User_Board delete = new User_Board();
    			
    			Object[] obj = (Object[]) itr.next();
    		   
    		    Integer u_id = Integer.parseInt(String.valueOf(obj[0]));  
    		    Integer b_id = Integer.parseInt(String.valueOf(obj[1]));
    		    System.out.println("User ID: " + u_id);
    		    System.out.println("Board ID: " + b_id);
    		    // Assigning retrieved IDs to Users and Board
    		    protoboard.setB_id(b_id);
    		    protouser.setU_id(u_id);
    		    
    		    board_id.setBoard(protoboard);
    		    board_id.setUser(protouser);
    		    
    		    User_Board_Id ub_id = new User_Board_Id(protoboard, protouser);
    		    // Assigning our User_Board the User_Board_Id
    		    delete.setUB_id(ub_id);
    		    // Deletion!
    		    user_boarddao.removeUserFromBoard(delete);
    		    
    		}
    	}
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
        if(user_boarddao.getUser_BoardByBoard(board).getRole().getR_id() == 2){
            boarddao.adminRenameBoard(board);
        }
    }
    
    public void updateBackGround(Board board){
        boarddao.updateBackGround(board);
    }
    
    public void adminRemoveBoard(Board board){
        if(user_boarddao.getUser_BoardByBoard(board).getRole().getR_id() == 2){
            boarddao.adminRemoveBoard(board);

        }
        
        
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
        if(userBoard.getRole().getR_id() == 2){
             //boarddao.adminRemoveBoard(board);
                  user_boarddao.addUserToBoard(userBoard);
               }
    }
  	
  	
  	public Roles getUserBoardRole(User_Board userBoard){
  		return  user_boarddao.getRoleForUserOnBoard(userBoard);
  	}
  	
  	
  	public void updateUser_Board(User_Board userBoard){
  		user_boarddao.updateUserRoleOnBoard(userBoard);
  	}
  	
  	
  	public void removeUser_Board(User_Board userBoard){
        if(userBoard.getRole().getR_id() == 2){
            user_boarddao.removeUserFromBoard(userBoard);
        }
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
