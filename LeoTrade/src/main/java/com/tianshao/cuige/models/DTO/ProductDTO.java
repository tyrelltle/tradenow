package com.tianshao.cuige.models.DTO;

public class ProductDTO{
	int prod_id;
	
	
	//owner's social id
	int userid;
	
	int catid=0;

	String title="";
	
	String detail="";
	
	float price=0;
	
	int quantity=0;
	
	String status="";
	
	String tradefor="";
	
	String thumurl="";
	public ProductDTO(){}

	
	
	public String getTradefor() {
		return tradefor;
	}



	public void setTradefor(String tradefor) {
		this.tradefor = tradefor;
	}



	public int getCatid() {
		return catid;
	}



	public void setCatid(int catid) {
		this.catid = catid;
	}



	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public int  getUserid() {
		return userid;
	}

	public void setUserid(int id) {
		this.userid = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getThumurl() {
		return thumurl;
	}

	public void setThumurl(String thumurl) {
		this.thumurl = thumurl;
	}
	
	
	
	
}
