package com.tianshao.cuige.domains.Notification;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tianshao.cuige.domains.IEntity;
import com.tianshao.cuige.domains.user.User;


@Entity
@Table(name="notification")
public class Notification implements IEntity{
	@Id
	@Column(name="noti_id")
	@GeneratedValue
	int noti_id=-1;
	
	@ManyToOne
	@JoinColumn(name="userid")
	User user;
	
	@Column(name="msg")
	String msg="";
	
	@Column(name="url")
	String url="";

	public Notification(){}
	public int getNoti_id() {
		return noti_id;
	}

	public void setNoti_id(int noti_id) {
		this.noti_id = noti_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	



	
	
	
	
}
