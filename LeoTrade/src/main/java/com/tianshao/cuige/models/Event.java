package com.tianshao.cuige.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="event")
public class Event implements Serializable{
	
	@Id
    @Column(name="id")
    @GeneratedValue
	public int id;
	
	
	
	@Column(name="title")
	public String title;
	
	@Column(name="loc")
	public String loc;
	
	@Column(name="detail")
	public String detail;

	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public Event(){}
	

	public Event(String t,String l,String d){
		title=t;
		loc=l;
		detail=d;
		
	}
	
		
	
	}