package com.tianshao.cuige.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name="product")
public class Product{
	@Id
	@Column(name="prod_id")
	@GeneratedValue
	int prod_id;
	
	@ManyToOne
	@JoinColumn(name="ownerid")
	Profile owner;
	
	@ManyToOne
	@JoinColumn(name="catid")
	Category category;
	
	@Column(name="title")
	String title="";
	
	@Column(name="tradefor")
	String tradefor="";
	
	@Column(name="detail")
	String detail="";
	
	@Column(name="price")
	float price=0;
	
	@Column(name="quantity")
	int quantity=0;
	
	@Column(name="status")
	String status="";
	
	@OneToMany(fetch = FetchType.LAZY, 
		       cascade = {CascadeType.ALL}, 
		       mappedBy = "product")
	@Fetch(FetchMode.SELECT)
	Set<Image> images=new HashSet<Image>();
	
	
	@OneToMany(fetch = FetchType.LAZY, 
		       cascade = {CascadeType.ALL}, 
		       mappedBy = "prod1")
	@Fetch(FetchMode.SELECT)
	Set<Trade> trades1=new HashSet<Trade>();
	
	
	@OneToMany(fetch = FetchType.LAZY, 
		       cascade = {CascadeType.ALL}, 
		       mappedBy = "prod2")
	@Fetch(FetchMode.SELECT)
	Set<Trade> trades2=new HashSet<Trade>();
	
	
	@Column(name="thumurl")
	String thumurl="";
	public Product(){}

	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public Profile getOwner() {
		return owner;
	}

	public void setOwner(Profile owner) {
		this.owner = owner;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTradefor() {
		return tradefor;
	}

	public void setTradefor(String tradefor) {
		this.tradefor = tradefor;
	}

	public String getThumurl() {
		return thumurl;
	}

	public void setThumurl(String thumurl) {
		this.thumurl = thumurl;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public Set<Trade> getTrades1() {
		return trades1;
	}

	public void setTrades1(Set<Trade> trades1) {
		this.trades1 = trades1;
	}

	public Set<Trade> getTrades2() {
		return trades2;
	}

	public void setTrades2(Set<Trade> trades2) {
		this.trades2 = trades2;
	}


	
	



	
	
	
	
}
