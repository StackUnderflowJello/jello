package com.revature.pojo;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table(name="user_board")
public class User_Board implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1067525463301858262L;
	
	@EmbeddedId
	private User_Board_Id ub_id;
	@JoinColumn(name="r_id") //joining between two tables
	@ManyToOne//connecting our Roles table.
	private Roles role;
	
	public User_Board(){}

	public User_Board(User_Board_Id ub_id, Roles role) {
		super();
		this.ub_id = ub_id;
		this.role = role;
	}

	public User_Board_Id getUB_id() {
		return ub_id;
	}

	public void setUB_id(User_Board_Id ub_id) {
		this.ub_id = ub_id;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User_Board [ub_id=" + ub_id + ", role=" + role + "]";
	}
	
	
	

}
