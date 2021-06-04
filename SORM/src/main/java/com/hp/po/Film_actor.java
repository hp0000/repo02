package com.hp.po;

import java.sql.*;
import java.util.*;

public class Film_actor{
	private java.sql.Timestamp last_update;
	private Integer actor_id;
	private Integer film_id;
	public java.sql.Timestamp getLast_update(){
		return last_update;
	}
	public Integer getActor_id(){
		return actor_id;
	}
	public Integer getFilm_id(){
		return film_id;
	}


	public void setLast_update(java.sql.Timestamp last_update){
		this.last_update=last_update;
	}
	public void setActor_id(Integer actor_id){
		this.actor_id=actor_id;
	}
	public void setFilm_id(Integer film_id){
		this.film_id=film_id;
	}
}
