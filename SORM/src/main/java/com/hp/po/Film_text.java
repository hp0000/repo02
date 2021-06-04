package com.hp.po;

import java.sql.*;
import java.util.*;

public class Film_text{
	private String description;
	private Integer film_id;
	private String title;
	public String getDescription(){
		return description;
	}
	public Integer getFilm_id(){
		return film_id;
	}
	public String getTitle(){
		return title;
	}


	public void setDescription(String description){
		this.description=description;
	}
	public void setFilm_id(Integer film_id){
		this.film_id=film_id;
	}
	public void setTitle(String title){
		this.title=title;
	}
}
