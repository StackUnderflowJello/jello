DROP TABLE history;
DROP TABLE task;
DROP TABLE jello_bite;
DROP TABLE swim_lane;
DROP TABLE swim_lane_type;
DROP TABLE user_table;
DROP TABLE board;
DROP TABLE roles;
DROP TABLE users;

CREATE TABLE users(
  u_id INT,
  u_email VARCHAR2(100) NOT NULL UNIQUE,
  u_password VARCHAR2(100) NOT NULL,
  PRIMARY KEY(u_id)
);

CREATE TABLE roles(
  r_id INT,
  r_name VARCHAR2(100) NOT NULL UNIQUE,
  PRIMARY KEY(r_id)
);

CREATE TABLE board(
  b_id INT,
  b_name VARCHAR2(100) NOT NULL,
  PRIMARY KEY(b_id)
);

CREATE TABLE user_board(
  u_id INT,
  b_id INT,
  r_id INT,
  PRIMARY KEY(u_id, b_id),
  FOREIGN KEY(u_id) REFERENCES USERS(u_id),
  FOREIGN KEY(b_id) REFERENCES BOARD(b_id),
  FOREIGN KEY(r_id) REFERENCES roles(r_id)
);

CREATE TABLE swim_lane_type(
  col_id INT,
  col_name VARCHAR2(100) UNIQUE NOT NULL,
  PRIMARY KEY(col_id)
);

CREATE TABLE swim_lane(
  lane_id INT,
  b_id INT NOT NULL,
  col_id INT NOT NULL,
  PRIMARY KEY(lane_id),
  FOREIGN KEY(b_id) REFERENCES BOARD(b_id),
  FOREIGN KEY(col_id) REFERENCES SWIM_LANE_TYPE(col_id)
);

CREATE TABLE jello_bite(
  bite_id INT,
  bite_name VARCHAR2(1000) NOT NULL,
  lane_id INT NOT NULL,
  jello_point INT,
  PRIMARY KEY(bite_id),
  FOREIGN KEY(lane_id) REFERENCES SWIM_LANE(lane_id)
);

CREATE TABLE task(
  t_id INT,
  bite_id INT NOT NULL,
  t_content VARCHAR2(1000),
  PRIMARY KEY(t_id),
  FOREIGN KEY(bite_id) REFERENCES JELLO_BITE(bite_id)
);

CREATE TABLE history(
  history_id INT,
  bite_id INT,
  prev_lane_id INT,
  new_lane_id INT,
  action_date VARCHAR2(100),
  PRIMARY KEY(history_id),
  FOREIGN KEY(bite_id) REFERENCES JELLO_BITE(bite_id),
  FOREIGN KEY(prev_lane_id) REFERENCES SWIM_LANE_TYPE(col_id),
  FOREIGN KEY(new_lane_id) REFERENCES SWIM_LANE_TYPE(col_id)
);

