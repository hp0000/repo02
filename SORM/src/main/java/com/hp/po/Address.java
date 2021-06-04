package com.hp.po;

import java.sql.*;
import java.util.*;

public class Address{
	private String address;
	private String address2;
	private String phone;
	private String district;
	private java.sql.Timestamp last_update;
	private Integer address_id;
	private String location;
	private String postal_code;
	private Integer city_id;
	public String getAddress(){
		return address;
	}
	public String getAddress2(){
		return address2;
	}
	public String getPhone(){
		return phone;
	}
	public String getDistrict(){
		return district;
	}
	public java.sql.Timestamp getLast_update(){
		return last_update;
	}
	public Integer getAddress_id(){
		return address_id;
	}
	public String getLocation(){
		return location;
	}
	public String getPostal_code(){
		return postal_code;
	}
	public Integer getCity_id(){
		return city_id;
	}


	public void setAddress(String address){
		this.address=address;
	}
	public void setAddress2(String address2){
		this.address2=address2;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public void setDistrict(String district){
		this.district=district;
	}
	public void setLast_update(java.sql.Timestamp last_update){
		this.last_update=last_update;
	}
	public void setAddress_id(Integer address_id){
		this.address_id=address_id;
	}
	public void setLocation(String location){
		this.location=location;
	}
	public void setPostal_code(String postal_code){
		this.postal_code=postal_code;
	}
	public void setCity_id(Integer city_id){
		this.city_id=city_id;
	}
}
