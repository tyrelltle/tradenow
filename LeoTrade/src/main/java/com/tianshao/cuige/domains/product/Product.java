package com.tianshao.cuige.domains.product;

import java.sql.Timestamp;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Latitude;
import org.hibernate.search.annotations.Longitude;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.Spatial;
import org.hibernate.search.annotations.Store;

import com.tianshao.cuige.domains.ICEntity;
import com.tianshao.cuige.domains.IEntity;
import com.tianshao.cuige.domains.trade.Trade;
import com.tianshao.cuige.domains.user.User;


@Entity
@Indexed
@Spatial(name="location") 
@Table(name="product")
public class Product implements IEntity{
	@Id
	@Column(name="prod_id")
	@GeneratedValue
	int prod_id=-1;
	
	@ManyToOne
	@JoinColumn(name="ownerid")
	User owner;
	
	@ManyToOne
	@JoinColumn(name="catid")
	Category category;
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
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
	
	@Column(name="latitude")
	@Latitude(of="location")
	Double latitude=0.0;
	
	@Column(name="longitude")
    @Longitude(of="location")
    Double longitude=0.0;
	
	
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
	
    @ManyToMany(fetch = FetchType.LAZY, 
    			cascade = {CascadeType.ALL}, 
    			mappedBy="favorites")
    private Set<User> likers = new HashSet<User>();
	
	@Column(name="thumurl")
	String thumurl="";
	
	@Column(name="update_date")
	Timestamp update_date;
	
	public Product(){}

	
	
	
	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
		this.latitude=owner.getLatitude();
		this.longitude=owner.getLongitude();
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




	public Double getLatitude() {
		return latitude;
	}




	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}




	public Double getLongitude() {
		return longitude;
	}




	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}




	public Timestamp getUpdate_date() {
		return update_date;
	}




	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}


	public Set<User> getLikers(){
		return likers;
	}
	



	
	
	
	
}
