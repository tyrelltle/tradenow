package com.tianshao.cuige.domains.trade;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tianshao.cuige.domains.IEntity;
import com.tianshao.cuige.domains.product.Product;
import com.tianshao.cuige.domains.user.User;

@Entity
@Table(name="message")
public class Message implements IEntity{

	
	@Id
	@Column(name="msgid")
	@GeneratedValue
	int msgid;
	
	@ManyToOne
	@JoinColumn(name="trade_id")
	Trade trade;

	@Column(name="side")
	int side;//left 0 right 1
	
	@Column(name="msg")
	String msg="";

	@Column(name="create_date",columnDefinition="TIMESTAMP")
	Timestamp create_date;
	
	public Message(){}

	public int getMsgid() {
		return msgid;
	}
	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}
	public Trade getTrade() {
		return trade;
	}
	public void setTrade(Trade trade) {
		this.trade = trade;
	}
	public int getSide() {
		return side;
	}
	public void setSide(int side) {
		this.side = side;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}

	public MessageDTO toDTO(){
		MessageDTO dto=new MessageDTO();
		User owner;
		if(this.side==0)
			owner=this.trade.getProd1().getOwner();
		else
			owner=this.trade.getProd2().getOwner();

		dto.setImgurl("user/img/userid/"+owner.getUserid());
		dto.setMessage(this.msg);
		dto.setSide(this.side);
		dto.setUsernm(owner.getFirstname()+" "+owner.getLastname());
		dto.setDate(this.create_date.toGMTString());
		dto.setId(this.msgid);
		return dto;
	}
}
