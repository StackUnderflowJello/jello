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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name="Jello_Bite")
public class Jello_Bite implements Serializable {
	@Cascade(CascadeType.DELETE)
	/**
	 * 
	 */ 
	private static final long serialVersionUID = -5738362805815909696L;
	@Id
	@Column
	@SequenceGenerator(name = "jello_bite_seq", sequenceName = "jello_bite_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator="jello_bite_seq")  
	private int bite_id;
	@Column
	private String bite_name;
	@ManyToOne
	@JoinColumn(name="lane_id")
	private Swim_Lane swim_lane;
	@Column
	private int jello_point;
	
	public Jello_Bite() {}
	
	public Jello_Bite(int bite_id, String bite_name, Swim_Lane swim_lane, int jello_point) {
		super();
		this.bite_id = bite_id;
		this.bite_name = bite_name;
		this.swim_lane = swim_lane;
		this.jello_point = jello_point;
	}


	public int getBite_id() {
		return bite_id;
	}

	public void setBite_id(int bite_id) {
		this.bite_id = bite_id;
	}

	public String getBite_name() {
		return bite_name;
	}

	public void setBite_name(String bite_name) {
		this.bite_name = bite_name;
	}

	public Swim_Lane getSwim_lane() {
		return swim_lane;
	}

	public void setSwim_lane(Swim_Lane swim_lane) {
		this.swim_lane = swim_lane;
	}

	public int getJello_point() {
		return jello_point;
	}

	public void setJello_point(int jello_point) {
		this.jello_point = jello_point;
	}

	@Override
	public String toString() {
		return "Jello_Bite [bite_id=" + bite_id + ", bite_name=" + bite_name + ", swim_lane=" + swim_lane
				+ ", jello_point=" + jello_point + "]";
	}
	
}
