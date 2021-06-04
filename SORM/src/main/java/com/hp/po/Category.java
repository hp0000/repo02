package com.hp.po;

import java.sql.*;
import java.util.*;

public class Category{
	private Integer category_id;
	private java.sql.Timestamp last_update;
	private String name;
	public Integer getCategory_id(){
		return category_id;
	}
	public java.sql.Timestamp getLast_update(){
		return last_update;
	}
	public String getName(){
		return name;
	}


	public void setCategory_id(Integer category_id){
		this.category_id=category_id;
	}
	public void setLast_update(java.sql.Timestamp last_update){
		this.last_update=last_update;
	}
	public void setName(String name){
		this.name=name;
	}
}
