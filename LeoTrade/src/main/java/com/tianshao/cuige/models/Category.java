package com.tianshao.cuige.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="category")
public class Category implements IEntity{
	

	@Id
    @Column(name="catid")
    @GeneratedValue
	public int catid=0;
	
	
	@Column(name="name")
	public String name;
	
	
	
	public Category(){}
	

	public Category(String nm){
		name=nm;
		
	}
	
	public int getCatid() {
		return catid;
	}


	public void setCatid(int id) {
		this.catid = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	
}