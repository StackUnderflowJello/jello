package com.revature.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Task") 
public class Task  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6388441533051245050L;
	@Id
	@Column
	private int t_id;
	@ManyToOne
	@JoinColumn(name="bite_id")
	private Jello_Bite jello_bite;
	@Column
	private String t_content;
	
	public Task(){}
	
	public Task(int t_id, Jello_Bite jello_bite, String t_content) {
		super();
		this.t_id = t_id;
		this.jello_bite = jello_bite;
		this.t_content = t_content;
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public Jello_Bite getJello_bite() {
		return jello_bite;
	}

	public void setJello_bite(Jello_Bite jello_bite) {
		this.jello_bite = jello_bite;
	}

	public String getT_content() {
		return t_content;
	}

	public void setT_content(String t_content) {
		this.t_content = t_content;
	}

	@Override
	public String toString() {
		return "Task [t_id=" + t_id + ", jello_bite=" + jello_bite + ", t_content=" + t_content + "]";
	}
	
	
	
	
	

}
