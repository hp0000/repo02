package com.hp.po;

import java.sql.*;
import java.util.*;

public class Language{
	private java.sql.Timestamp last_update;
	private String name;
	private Integer language_id;
	public java.sql.Timestamp getLast_update(){
		return last_update;
	}
	public String getName(){
		return name;
	}
	public Integer getLanguage_id(){
		return language_id;
	}


	public void setLast_update(java.sql.Timestamp last_update){
		this.last_update=last_update;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setLanguage_id(Integer language_id){
		this.language_id=language_id;
	}
}
