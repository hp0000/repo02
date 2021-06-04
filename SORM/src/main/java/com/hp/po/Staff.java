package com.hp.po;

import java.sql.*;
import java.util.*;

public class Staff{
	private Integer store_id;
	private String password;
	private Integer staff_id;
	private java.sql.Timestamp last_update;
	private Integer address_id;
	private String last_name;
	private Integer active;
	private String first_name;
	private java.sql.Blob picture;
	private String email;
	private String username;
	public Integer getStore_id(){
		return store_id;
	}
	public String getPassword(){
		return password;
	}
	public Integer getStaff_id(){
		return staff_id;
	}
	public java.sql.Timestamp getLast_update(){
		return last_update;
	}
	public Integer getAddress_id(){
		return address_id;
	}
	public String getLast_name(){
		return last_name;
	}
	public Integer getActive(){
		return active;
	}
	public String getFirst_name(){
		return first_name;
	}
	public java.sql.Blob getPicture(){
		return picture;
	}
	public String getEmail(){
		return email;
	}
	public String getUsername(){
		return username;
	}


	public void setStore_id(Integer store_id){
		this.store_id=store_id;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setStaff_id(Integer staff_id){
		this.staff_id=staff_id;
	}
	public void setLast_update(java.sql.Timestamp last_update){
		this.last_update=last_update;
	}
	public void setAddress_id(Integer address_id){
		this.address_id=address_id;
	}
	public void setLast_name(String last_name){
		this.last_name=last_name;
	}
	public void setActive(Integer active){
		this.active=active;
	}
	public void setFirst_name(String first_name){
		this.first_name=first_name;
	}
	public void setPicture(java.sql.Blob picture){
		this.picture=picture;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public void setUsername(String username){
		this.username=username;
	}
}
