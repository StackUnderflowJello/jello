package com.revature.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
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
	@SequenceGenerator(name = "task_seq", sequenceName = "task_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator="task_seq")  
	private int t_id;
	@ManyToOne
	@JoinColumn(name="bite_id")
	private Jello_Bite jello_bite;
	@Column
	private String t_content;
	@Column
	private int t_isCompleted;
	
	public Task(){}
	
	public Task(int t_id, Jello_Bite jello_bite, String t_content, int t_isCompleted) {
		super();
		this.t_id = t_id;
		this.jello_bite = jello_bite;
		this.t_content = t_content;
		this.t_isCompleted = t_isCompleted;
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

	public int isT_isCompleted() {
		return t_isCompleted;
	}

	public void setT_isCompleted(int t_isCompleted) {
		this.t_isCompleted = t_isCompleted;
	}

	@Override
	public String toString() {
		return "Task [t_id=" + t_id + ", jello_bite=" + jello_bite + ", t_content=" + t_content + ", t_isCompleted="
				+ t_isCompleted + "]";
	}
	

}
