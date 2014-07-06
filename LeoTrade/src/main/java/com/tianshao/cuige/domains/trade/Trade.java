package com.tianshao.cuige.domains.trade;

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

@Entity
@Table(name="trade")
public class Trade implements IEntity{

	public static enum FROM_TO{
		FROM,TO, BOTH
	}
	
	public static enum STATUS{
		PENDING,ACCEPTED,DONE
		
	}
	
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
	String status1="";
	
	@Column(name="status2")
	String status2="";
	
	@Column(name="method1")
	String method1="";
	
	@Column(name="method2")
	String method2="";

	public Trade(){}
	
	
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
	
	
    public static final String DELIVERY="Delivery";
    public static final String INPERSON="In Person";

    //set 
	public void setMethodBySide(String method, String side) {
		if(side.equals(Trade.FROM_TO.FROM.toString())){
    		setMethod1(method);
    	}else if (side.equals(Trade.FROM_TO.TO.toString())){
    		setMethod2(method);
    	}
		
	}

	public Trade.FROM_TO getSideByUserId(int userid){
		if(this.prod1!=null && prod1.getOwner().getUserid()==userid)
			return FROM_TO.FROM;
		else if(this.prod2!=null && prod2.getOwner().getUserid()==userid)
			return FROM_TO.TO;
		return null;
	} 
	public void setDefaultValues(){
    	this.setMethod1(Trade.INPERSON);
    	this.setMethod2(Trade.INPERSON);
    	this.setStatus1(Trade.STATUS.PENDING.name());
    	this.setStatus2(Trade.STATUS.PENDING.name());
	}
	
	public void setStatusBySide(String side, STATUS status) throws Exception{

		if(side.equals(FROM_TO.FROM.name())){
			this.setStatus1(status.name());
		}else if(side.equals(FROM_TO.TO.name())){
			this.setStatus2(status.name());
		}else{
			throw new Exception("Internal error: wrong side string. must be either FROM or TO");
		}
	}


	public String getMethodByUserId(int userid) {
		FROM_TO ft=this.getSideByUserId(userid);
		switch(ft){
			case FROM: return method1; 
			case TO: return method2; 
		}
		return null;
	}
	
	public TradeDTO toTradeDTO(){
		TradeDTO dto=new TradeDTO();
		dto.setImg1url(prod1.getThumurl());
		dto.setImg2url(prod2.getThumurl());
		
		if(this.status1.equals(STATUS.ACCEPTED.name())&& this.status2.equals(STATUS.ACCEPTED.name()))
			dto.setStatus(STATUS.DONE.name());
		else
			dto.setStatus(STATUS.PENDING.name());
		
		dto.setTitle1(prod1.getTitle());
		dto.setTitle2(prod2.getTitle());
		dto.setTradeid(this.getTrade_id());
		dto.setTradeurl("wow! to be determined!!!!!!");
		return dto;
	}
	
	public boolean bothAccepted(){
		return this.status1.equals(this.status2) && this.status1.equals(STATUS.ACCEPTED.name());
	}
}
