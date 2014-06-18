package com.tianshao.cuige.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tianshao.cuige.models.DTO.ProviderInfo;
import com.tianshao.cuige.models.DTO.UserRegistrationDTO;
@Entity
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
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;

	@Column(name="email")
	private String email;
	
	@Column(name="aboutme")
	private String aboutme;
	
	@Column(name="location")
	private String location;
	
	@Column(name="image")
	private byte[] image;
	
	
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
	
    
	


	
}