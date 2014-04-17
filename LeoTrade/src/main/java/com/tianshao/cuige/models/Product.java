package com.tianshao.cuige.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="product")
public class Product implements Serializable{
	@Id
    @Column(name="id")
    @GeneratedValue
	int id;
	
	
	@Column(name="name")
	String name;
	
	@Column(name="unitprice")
	float unitprice;
	
	
	/**
	 * colorbag:  supported colors seperated with ';'. ex, "red;yellow;blue"
	 */
	@Column(name="colorbag")
	String colorbag;
	
	@ManyToOne
	@JoinColumn(name="catid")
	Category category;
	
	
	public Product(){
		
	}
	public Product(String nm, float cost, String color){
		name=nm;
		unitprice=cost;
		colorbag=color;
	}
	
	
	public float getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(float unitprice) {
		this.unitprice = unitprice;
	}
	public String getColorbag() {
		return colorbag;
	}
	public void setColorbag(String colorbag) {
		this.colorbag = colorbag;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	
}