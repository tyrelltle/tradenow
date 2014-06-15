package com.tianshao.cuige.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="user")
public class User implements IEntity{
	
	@Id
    @Column(name="userid")
    @GeneratedValue
	private int userid;

	
	/**
	 * facebook id. or later other social network ids
	 */
	@Column(name="social_id")
	private String social_id;
	
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

	public String getSocial_id() {
		return social_id;
	}

	public void setSocial_id(String social_id) {
		this.social_id = social_id;
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
	
    
	


	
}