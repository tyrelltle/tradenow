package com.tianshao.cuige.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="trade")
public class Trade implements Serializable {

	@Id
	@Column(name="trade_id")
	@GeneratedValue
	int trade_id;
	
	@ManyToOne
	@JoinColumn(name="prod1_id")
	Product prod1;
	
	
	@ManyToOne
	@JoinColumn(name="prod2_id")
	Product prod2;
	
	@Column(name="trans_date")
	Date trans_date;
	
	@Column(name="status1")
	String status1;
	
	@Column(name="status2")
	String status2;
	
	@Column(name="method1")
	String method1;
	
	@Column(name="method2")
	String method2;

	public int getTrade_id() {
		return trade_id;
	}

	public void setTrade_id(int trade_id) {
		this.trade_id = trade_id;
	}

	public Product getProd1() {
		return prod1;
	}

	public void setProd1(Product prod1) {
		this.prod1 = prod1;
	}

	public Product getProd2() {
		return prod2;
	}

	public void setProd2(Product prod2) {
		this.prod2 = prod2;
	}

	public Date getTrans_date() {
		return trans_date;
	}

	public void setTrans_date(Date trans_date) {
		this.trans_date = trans_date;
	}

	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}

	public String getStatus2() {
		return status2;
	}

	public void setStatus2(String status2) {
		this.status2 = status2;
	}

	public String getMethod1() {
		return method1;
	}

	public void setMethod1(String method1) {
		this.method1 = method1;
	}

	public String getMethod2() {
		return method2;
	}

	public void setMethod2(String method2) {
		this.method2 = method2;
	}
	


}
