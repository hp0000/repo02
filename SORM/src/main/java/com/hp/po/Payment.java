package com.hp.po;

import java.sql.*;
import java.util.*;

public class Payment{
	private java.math.BigDecimal amount;
	private Integer payment_id;
	private Integer staff_id;
	private java.sql.Timestamp last_update;
	private Integer customer_id;
	private java.sql.Timestamp payment_date;
	private Integer rental_id;
	public java.math.BigDecimal getAmount(){
		return amount;
	}
	public Integer getPayment_id(){
		return payment_id;
	}
	public Integer getStaff_id(){
		return staff_id;
	}
	public java.sql.Timestamp getLast_update(){
		return last_update;
	}
	public Integer getCustomer_id(){
		return customer_id;
	}
	public java.sql.Timestamp getPayment_date(){
		return payment_date;
	}
	public Integer getRental_id(){
		return rental_id;
	}


	public void setAmount(java.math.BigDecimal amount){
		this.amount=amount;
	}
	public void setPayment_id(Integer payment_id){
		this.payment_id=payment_id;
	}
	public void setStaff_id(Integer staff_id){
		this.staff_id=staff_id;
	}
	public void setLast_update(java.sql.Timestamp last_update){
		this.last_update=last_update;
	}
	public void setCustomer_id(Integer customer_id){
		this.customer_id=customer_id;
	}
	public void setPayment_date(java.sql.Timestamp payment_date){
		this.payment_date=payment_date;
	}
	public void setRental_id(Integer rental_id){
		this.rental_id=rental_id;
	}
}
