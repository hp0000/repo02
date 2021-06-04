package com.hp.po;

import java.sql.*;
import java.util.*;

public class Customer{
	private Integer store_id;
	private java.sql.Timestamp last_update;
	private Integer address_id;
	private String last_name;
	private Integer active;
	private Integer customer_id;
	private java.sql.Timestamp create_date;
	private String first_name;
	private String email;
	public Integer getStore_id(){
		return store_id;
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
	public Integer getCustomer_id(){
		return customer_id;
	}
	public java.sql.Timestamp getCreate_date(){
		return create_date;
	}
	public String getFirst_name(){
		return first_name;
	}
	public String getEmail(){
		return email;
	}


	public void setStore_id(Integer store_id){
		this.store_id=store_id;
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
	public void setCustomer_id(Integer customer_id){
		this.customer_id=customer_id;
	}
	public void setCreate_date(java.sql.Timestamp create_date){
		this.create_date=create_date;
	}
	public void setFirst_name(String first_name){
		this.first_name=first_name;
	}
	public void setEmail(String email){
		this.email=email;
	}
}
