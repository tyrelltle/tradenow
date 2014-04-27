package com.tianshao.cuige.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="profile")
public class Profile implements Serializable{
	

	@Id
    @Column(name="prof_id")
    @GeneratedValue
	private int prof_id;
	
	/**
	 * facebook id. or later other social network ids
	 */
	@Column(name="social_id")
	private String social_id;
	
	@Column(name="aboutme")
	private String aboutme;
	
	@Column(name="location")
	private String location;
	
	public Profile(){}

	public int getProf_id() {
		return prof_id;
	}

	public void setProf_id(int prof_id) {
		this.prof_id = prof_id;
	}

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
	
    
	


	
}