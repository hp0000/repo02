package com.hp.po;

import java.sql.*;
import java.util.*;

public class City{
	private String city;
	private java.sql.Timestamp last_update;
	private Integer country_id;
	private Integer city_id;
	public String getCity(){
		return city;
	}
	public java.sql.Timestamp getLast_update(){
		return last_update;
	}
	public Integer getCountry_id(){
		return country_id;
	}
	public Integer getCity_id(){
		return city_id;
	}


	public void setCity(String city){
		this.city=city;
	}
	public void setLast_update(java.sql.Timestamp last_update){
		this.last_update=last_update;
	}
	public void setCountry_id(Integer country_id){
		this.country_id=country_id;
	}
	public void setCity_id(Integer city_id){
		this.city_id=city_id;
	}
}
