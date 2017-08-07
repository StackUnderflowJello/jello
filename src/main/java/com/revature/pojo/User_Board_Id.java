package com.revature.pojo;

 
import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Embeddable
//This class is to set the Composite for User_Board
//This is to create the Composite Key 
@Table(name="ub_id")
public class User_Board_Id implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2803314883882448573L;

	@ManyToOne
	@JoinColumn(name="b_id")//this is for the foreign key
	private Board board;
	
	@ManyToOne//connecting to the Users table.
	@JoinColumn(name="u_id")
	private Users user;
	
	public User_Board_Id(){}

	public User_Board_Id(Board board, Users user) {
		super();
		this.board = board;
		this.user = user;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "User_Board_Id [board=" + board + ", user=" + user + "]";
	}

	
	
}
