package com.hp.po;

import java.sql.*;
import java.util.*;

public class Film{
	private String special_features;
	private Integer rental_duration;
	private java.math.BigDecimal rental_rate;
	private java.sql.Date release_year;
	private Integer length;
	private java.math.BigDecimal replacement_cost;
	private java.lang.Enum rating;
	private String description;
	private Integer language_id;
	private String title;
	private Integer original_language_id;
	private java.sql.Timestamp last_update;
	private Integer film_id;
	public String getSpecial_features(){
		return special_features;
	}
	public Integer getRental_duration(){
		return rental_duration;
	}
	public java.math.BigDecimal getRental_rate(){
		return rental_rate;
	}
	public java.sql.Date getRelease_year(){
		return release_year;
	}
	public Integer getLength(){
		return length;
	}
	public java.math.BigDecimal getReplacement_cost(){
		return replacement_cost;
	}
	public java.lang.Enum getRating(){
		return rating;
	}
	public String getDescription(){
		return description;
	}
	public Integer getLanguage_id(){
		return language_id;
	}
	public String getTitle(){
		return title;
	}
	public Integer getOriginal_language_id(){
		return original_language_id;
	}
	public java.sql.Timestamp getLast_update(){
		return last_update;
	}
	public Integer getFilm_id(){
		return film_id;
	}


	public void setSpecial_features(String special_features){
		this.special_features=special_features;
	}
	public void setRental_duration(Integer rental_duration){
		this.rental_duration=rental_duration;
	}
	public void setRental_rate(java.math.BigDecimal rental_rate){
		this.rental_rate=rental_rate;
	}
	public void setRelease_year(java.sql.Date release_year){
		this.release_year=release_year;
	}
	public void setLength(Integer length){
		this.length=length;
	}
	public void setReplacement_cost(java.math.BigDecimal replacement_cost){
		this.replacement_cost=replacement_cost;
	}
	public void setRating(java.lang.Enum rating){
		this.rating=rating;
	}
	public void setDescription(String description){
		this.description=description;
	}
	public void setLanguage_id(Integer language_id){
		this.language_id=language_id;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public void setOriginal_language_id(Integer original_language_id){
		this.original_language_id=original_language_id;
	}
	public void setLast_update(java.sql.Timestamp last_update){
		this.last_update=last_update;
	}
	public void setFilm_id(Integer film_id){
		this.film_id=film_id;
	}
}
