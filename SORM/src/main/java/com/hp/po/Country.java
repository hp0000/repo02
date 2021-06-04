package com.hp.po;

import java.sql.*;
import java.util.*;

public class Country{
	private String country;
	private java.sql.Timestamp last_update;
	private Integer country_id;
	public String getCountry(){
		return country;
	}
	public java.sql.Timestamp getLast_update(){
		return last_update;
	}
	public Integer getCountry_id(){
		return country_id;
	}


	public void setCountry(String country){
		this.country=country;
	}
	public void setLast_update(java.sql.Timestamp last_update){
		this.last_update=last_update;
	}
	public void setCountry_id(Integer country_id){
		this.country_id=country_id;
	}
}
