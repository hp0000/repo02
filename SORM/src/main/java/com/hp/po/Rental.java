package com.hp.po;

import java.sql.*;
import java.util.*;

public class Rental{
	private Integer inventory_id;
	private Integer staff_id;
	private java.sql.Timestamp last_update;
	private java.sql.Timestamp rental_date;
	private Integer customer_id;
	private Integer rental_id;
	private java.sql.Timestamp return_date;
	public Integer getInventory_id(){
		return inventory_id;
	}
	public Integer getStaff_id(){
		return staff_id;
	}
	public java.sql.Timestamp getLast_update(){
		return last_update;
	}
	public java.sql.Timestamp getRental_date(){
		return rental_date;
	}
	public Integer getCustomer_id(){
		return customer_id;
	}
	public Integer getRental_id(){
		return rental_id;
	}
	public java.sql.Timestamp getReturn_date(){
		return return_date;
	}


	public void setInventory_id(Integer inventory_id){
		this.inventory_id=inventory_id;
	}
	public void setStaff_id(Integer staff_id){
		this.staff_id=staff_id;
	}
	public void setLast_update(java.sql.Timestamp last_update){
		this.last_update=last_update;
	}
	public void setRental_date(java.sql.Timestamp rental_date){
		this.rental_date=rental_date;
	}
	public void setCustomer_id(Integer customer_id){
		this.customer_id=customer_id;
	}
	public void setRental_id(Integer rental_id){
		this.rental_id=rental_id;
	}
	public void setReturn_date(java.sql.Timestamp return_date){
		this.return_date=return_date;
	}
}
