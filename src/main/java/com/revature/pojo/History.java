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
@Table(name="history")
public class History implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1154197383618743680L;
	
	@Id
	@Column
	@SequenceGenerator(name = "history_seq", sequenceName = "history_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator="history_seq")  
	private int history_id;
	@ManyToOne
	@JoinColumn(name="bite_id")
	private Jello_Bite jello_bite;
	@ManyToOne
	@JoinColumn(name="prev_lane_id",referencedColumnName="col_id") //what lane the jello bite was moved out of
	private Swim_Lane swim_lane;
	@ManyToOne
	@JoinColumn(name="new_lane_id",referencedColumnName="col_id") //what lane the jello bite was moved into
	private Swim_Lane swim_lane_new;
	@Column
	private String action_date;
	
	public History(){}

	public History(int history_id, Jello_Bite jello_bite, Swim_Lane swim_lane,
			Swim_Lane swim_lane_new, String action_date) {
		super();
		this.history_id = history_id;
		this.jello_bite = jello_bite;
		this.swim_lane = swim_lane;
		this.swim_lane_new = swim_lane_new;
		this.action_date = action_date;
	}

	public int getHistory_id() {
		return history_id;
	}

	public void setHistory_id(int history_id) {
		this.history_id = history_id;
	}

	public Jello_Bite getJello_bite() {
		return jello_bite;
	}

	public void setJello_bite(Jello_Bite jello_bite) {
		this.jello_bite = jello_bite;
	}

	public Swim_Lane getSwim_lane() {
		return swim_lane;
	}

	public void setSwim_lane(Swim_Lane swim_lane) {
		this.swim_lane = swim_lane;
	}

	public Swim_Lane getSwim_lane_new() {
		return swim_lane_new;
	}

	public void setSwim_lane_new(Swim_Lane swim_lane_new) {
		this.swim_lane_new = swim_lane_new;
	}

	public String getAction_date() {
		return action_date;
	}

	public void setAction_date(String action_date) {
		this.action_date = action_date;
	}

	@Override
	public String toString() {
		return "History [history_id=" + history_id + ", jello_bite=" + jello_bite + ", swim_lane=" + swim_lane
				+ ", swim_lane_new=" + swim_lane_new + ", action_date=" + action_date + "]";
	}
		
}