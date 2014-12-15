package com.tradenow.domains.notification;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tradenow.domains.IEntity;
import com.tradenow.domains.user.User;


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

	@Column(name="isnew")
	int isnew=1;
	
	@Column(name="create_date")
	Date create_date;
	
	public Notification(){}
	
	
	
	public int getIsnew() {
		return isnew;
	}



	public void setIsnew(int isnew) {
		this.isnew = isnew;
	}



	public Date getCreate_date() {
		return create_date;
	}



	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}



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
	
	@SuppressWarnings("deprecation")
	public NotificationDTO toDTO(){
		NotificationDTO dto=new NotificationDTO();
		dto.setDate(this.create_date.toGMTString());
		dto.setMessage(this.msg);
		dto.setUrl(this.url);
		dto.setId(this.noti_id);
		return dto;
	}
	
	



	
	
	
	
}
