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
@Table(name="custproduct")
public class CustProduct implements Serializable{
	@Id
    @Column(name="custprodid")
    @GeneratedValue
	int custprodid;
	
	//uniquely identify a user session, which can be reloaded 
	@Column(name="guid")
	String guid;
	
	@ManyToOne
	@JoinColumn(name="id")
	Product product;


	@Column(name="quantity")
	int quantity;
	
	@Column(name="len")
	float len;
	
	@Column(name="color")
	String color;
	

	
	public CustProduct(){
		
	}
	
	public CustProduct(String guid, int quantity, float len, String color) {
		super();
		this.guid=guid;
		this.quantity = quantity;
		this.len = len;
		this.color = color;
	}



	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public int getCustprodid() {
		return custprodid;
	}



	public void setCustprodid(int custprodid) {
		this.custprodid = custprodid;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public float getLen() {
		return len;
	}



	public void setLen(float len) {
		this.len = len;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}
	

	
}