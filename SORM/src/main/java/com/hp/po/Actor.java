package com.hp.po;

import java.sql.*;
import java.util.*;

public class Actor{
	private java.sql.Timestamp last_update;
	private String last_name;
	private Integer actor_id;
	private String first_name;
	public java.sql.Timestamp getLast_update(){
		return last_update;
	}
	public String getLast_name(){
		return last_name;
	}
	public Integer getActor_id(){
		return actor_id;
	}
	public String getFirst_name(){
		return first_name;
	}


	public void setLast_update(java.sql.Timestamp last_update){
		this.last_update=last_update;
	}
	public void setLast_name(String last_name){
		this.last_name=last_name;
	}
	public void setActor_id(Integer actor_id){
		this.actor_id=actor_id;
	}
	public void setFirst_name(String first_name){
		this.first_name=first_name;
	}

	@Override
	public String toString() {
		return "Actor{" +
				"last_update=" + last_update +
				", last_name='" + last_name + '\'' +
				", actor_id=" + actor_id +
				", first_name='" + first_name + '\'' +
				'}';
	}
}
