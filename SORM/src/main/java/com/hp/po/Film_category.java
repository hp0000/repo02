package com.hp.po;

import java.sql.*;
import java.util.*;

public class Film_category{
	private Integer category_id;
	private java.sql.Timestamp last_update;
	private Integer film_id;
	public Integer getCategory_id(){
		return category_id;
	}
	public java.sql.Timestamp getLast_update(){
		return last_update;
	}
	public Integer getFilm_id(){
		return film_id;
	}


	public void setCategory_id(Integer category_id){
		this.category_id=category_id;
	}
	public void setLast_update(java.sql.Timestamp last_update){
		this.last_update=last_update;
	}
	public void setFilm_id(Integer film_id){
		this.film_id=film_id;
	}
}
