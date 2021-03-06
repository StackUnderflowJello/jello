package com.revature.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="board")
public class Board implements Serializable {
	@Cascade(CascadeType.DELETE)
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5949559657708067406L;
	@Id
	@Column
	private int b_id;
	@Column
	private String b_name;

	public Board(){}

	public Board(int b_id, String b_name) {
		super();
		this.b_id = b_id;
		this.b_name = b_name;
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	@Override
	public String toString() {
		return "Board [b_id=" + b_id + ", b_name=" + b_name + "]";
	}
	
	
	
	
	

}
