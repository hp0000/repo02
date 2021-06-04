package com.hp.po;

import java.sql.*;
import java.util.*;

public class Inventory{
	private Integer store_id;
	private Integer inventory_id;
	private java.sql.Timestamp last_update;
	private Integer film_id;
	public Integer getStore_id(){
		return store_id;
	}
	public Integer getInventory_id(){
		return inventory_id;
	}
	public java.sql.Timestamp getLast_update(){
		return last_update;
	}
	public Integer getFilm_id(){
		return film_id;
	}


	public void setStore_id(Integer store_id){
		this.store_id=store_id;
	}
	public void setInventory_id(Integer inventory_id){
		this.inventory_id=inventory_id;
	}
	public void setLast_update(java.sql.Timestamp last_update){
		this.last_update=last_update;
	}
	public void setFilm_id(Integer film_id){
		this.film_id=film_id;
	}
}
