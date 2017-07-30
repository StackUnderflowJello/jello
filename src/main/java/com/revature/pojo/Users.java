package com.revature.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="Users")
public class Users implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7598549940081450437L;
	
	@Id
	@Column
	private int u_id;
	@Column
	private String u_email;
	@Column
	private String u_password;
	
	public Users(){}

	public Users(int u_id, String u_email, String u_password) {
		super();
		this.u_id = u_id;
		this.u_email = u_email;
		this.u_password = u_password;
	}


	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	@Override
	public String toString() {
		return "Users [u_id=" + u_id + ", u_email=" + u_email + ", u_password=" + u_password + "]";
	}
	
	

}
