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
@Table(name="Swim_Lane")
public class Swim_Lane implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7320695935422000005L;

	@Id
	@Column
	@SequenceGenerator(name="lane_seq", sequenceName="lane_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="lane_seq")//specifying that we are creating a sequence in a DB
	private int lane_id;
	
	@JoinColumn(name="b_id")
	@ManyToOne
	private Board board;
	
	@JoinColumn(name="col_id")
	@ManyToOne
	private Swim_Lane_Type swim_lane_type;
	
	public Swim_Lane(){}
	
	
	public Swim_Lane(int lane_id, Board board, Swim_Lane_Type swim_lane_type) {
		super();
		this.lane_id = lane_id;
		this.board = board;
		this.swim_lane_type = swim_lane_type;
	}



	public int getLane_id() {
		return lane_id;
	}

	public void setLane_id(int lane_id) {
		this.lane_id = lane_id;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Swim_Lane_Type getSwim_lane_type() {
		return swim_lane_type;
	}

	public void setSwim_lane_type(Swim_Lane_Type swim_lane_type) {
		this.swim_lane_type = swim_lane_type;
	}

	@Override
	public String toString() {
		return "Swim_Lane [lane_id=" + lane_id + ", board=" + board + ", swim_lane_type=" + swim_lane_type + "]";
	}
	
	
	
}
