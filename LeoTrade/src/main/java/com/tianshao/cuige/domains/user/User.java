package com.tianshao.cuige.domains.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Latitude;
import org.hibernate.search.annotations.Longitude;
import org.hibernate.search.annotations.Spatial;

import com.tianshao.cuige.config.ProviderInfo;
import com.tianshao.cuige.domains.IEntity;
import com.tianshao.cuige.domains.product.Product;
import com.tianshao.cuige.domains.trade.Trade;
@Spatial(name="location") @Indexed @Entity
@Table(name="user")
public class User implements IEntity{

	@Id
    @Column(name="userid")
    @GeneratedValue
	private int userid=-1;
	
	@Column(name="userconid")
	String userconid;
	
	@Column(name="providerid")
	String providerid;
	
	@Column(name="provideruserid")
	String provideruserid;
	
	@Column(name="password")
	private String password;

	@Column(name="firstname")
	private String firstname="";
	
	@Column(name="lastname")
	private String lastname="";

	@Column(name="email")
	private String email="";
	
	@Column(name="aboutme")
	private String aboutme="";
	
	@Column(name="location")
	private String location="";
	
	@Column(name="image")
	private byte[] image;
	
	@Column(name="latitude")
	@Latitude(of="location")
	Double latitude=0.0;
	
	@Column(name="longitude")
    @Longitude(of="location")
    Double longitude=0.0;
	

	
	public User(int userid){this.userid=userid;}

	public User(){}

	public User(UserRegistrationDTO dto){
		this.email=dto.getEmail();
		this.firstname=dto.getFirstname();
		this.lastname=dto.getLastname();
		this.password=dto.getPassword();
		
	}
	
	public User(ProviderInfo provinfo){
		this.setProviderid(provinfo.providerid);
		this.setProvideruserid(provinfo.provideruserid);
		this.setFirstname(provinfo.firstname);
		this.setLastname(provinfo.lastname);
		this.setEmail(provinfo.email);
		this.setUserconid(provinfo.userconid);
	}



	public boolean signedinAsFacebookUser(){
		return this.userconid!="";
	}
	
	public String getAboutme() {
		return aboutme;
	}

	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserconid() {
		return userconid;
	}

	public void setUserconid(String userconid) {
		this.userconid = userconid;
	}

	public String getProviderid() {
		return providerid;
	}

	public void setProviderid(String providerid) {
		this.providerid = providerid;
	}

	public String getProvideruserid() {
		return provideruserid;
	}

	public void setProvideruserid(String provideruserid) {
		this.provideruserid = provideruserid;
	}
	
    public boolean isSocialUserAndNeedImage(){
    	return this.providerid!=null && this.providerid.equals("facebook")&&this.image==null;
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
	


	
}