package com.tianshao.cuige.domains.mail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.tianshao.cuige.domains.IEntity;
import com.tianshao.cuige.domains.user.User;
@Entity
@Table(name="regconfirm")
public class Regconfirm implements IEntity{
	@Id
	@Column(name="id")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	String id;
	
	@ManyToOne
	@JoinColumn(name="userid")
	User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
