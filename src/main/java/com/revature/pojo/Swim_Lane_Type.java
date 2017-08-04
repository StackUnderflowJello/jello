package com.revature.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="Swim_Lane_Type")
public class Swim_Lane_Type implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8360994235249676557L;
	@Id
	@Column
	private int col_id;
	@Column
	private String col_name;
	
	public Swim_Lane_Type(){}
	
	public Swim_Lane_Type(int col_id, String col_name) {
		super();
		this.col_id = col_id;
		this.col_name = col_name;
	}


	public int getCol_id() {
		return col_id;
	}
	public void setCol_id(int col_id) {
		this.col_id = col_id;
	}
	public String getCol_name() {
		return col_name;
	}
	public void setCol_name(String col_name) {
		this.col_name = col_name;
	}

	@Override
	public String toString() {
		return "Swim_Lane_Type [col_id=" + col_id + ", col_name=" + col_name + "]";
	}
	
	

	
}
