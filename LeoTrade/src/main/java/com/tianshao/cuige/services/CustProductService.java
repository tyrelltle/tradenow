package com.tianshao.cuige.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianshao.cuige.database.DAO;
import com.tianshao.cuige.models.Category;
import com.tianshao.cuige.models.CustProduct;
import com.tianshao.cuige.models.Product;

@Service
public class CustProductService {
	@Autowired
	DAO dao;

	@Autowired
	ProductService prodService;
	
	public CustProductService(){}
	
	public int addCustProduct(CustProduct c)  {
			 dao.addNew(c);
			 return c.getCustprodid();
	}

	/**
	 * transform model object to simplified version,
	 * only store ids of composite persistent object
	 * @param prod
	 * @return
	 */
	public SimplizedForm toSimplified(CustProduct c){
		Product prod=c.getProduct();
		return new SimplizedForm(c.getCustprodid(), 
								 c.getGuid(),
								 prod.getId(),
								 prod.getName(),
								 prod.getUnitprice(),
								 prod.getColorbag(),
								 c.getColor(), 
								 c.getLen(), 
								 c.getQuantity());
	}
	/**
	 * transform simplified model object to full model object
	 * @return
	 */
	public CustProduct toFullModel(SimplizedForm sim){
		Product prod=prodService.getProduct(sim.getId());
		if ( null==prod)
			return null;
		CustProduct ret =new CustProduct();
		ret.setProduct(prod);
		ret.setColor(sim.getColor());
		ret.setCustprodid(sim.getCustprodid());
		ret.setLen(sim.getLen());
		ret.setQuantity(sim.getQuantity());
		ret.setGuid(sim.getGuid());
		return ret;
		
	}
		
	
	/**
	 * get a list of custproducts (user customizations) by GUID
	 * A GUID represents a user customization session
	 */
	public List<SimplizedForm> getListByGUID(String guid){
		List<CustProduct> custs = (List<CustProduct>) dao.getByColumn("CustProduct", "guid", guid);
		List<SimplizedForm> ret= new ArrayList<SimplizedForm>();
		for(CustProduct i : custs){
			ret.add(this.toSimplified(i));
		}
		return ret;
	}
	
	/**
	 * add new product with existing category 
	 * @param product
	 * @param catid
	 * @return
	 */
	public int addCustProductWithProdId(CustProduct c, int prodid){
		Product prod=prodService.getProduct(prodid);
		if(null == prod){
			return -1;
		}
		c.setProduct(prod);
		dao.addNew(c);
		return c.getCustprodid();
	}

	public List<CustProduct> getCustProducts()  {
		return (List<CustProduct>)dao.list("CustProduct");
		
	}


	public CustProduct getCustProduct(int id) {
		
		return (CustProduct)dao.getById("CustProduct", id);
	}


	
	public void removeCustProduct(int i) {
		dao.remove(CustProduct.class, i);		
	}

	
	public void update(CustProduct e) {

		
			dao.update(e);
	
	}
	
	/**
	 * this is the simplified form of Product model, 
	 * which does not contain a reference to Category object,
	 * instead, only category id is stored.
	 * The purpose is to ease the client
	 * 
	 * @author tsa45
	 *
	 */
	
	public static class SimplizedForm extends SimplizedForm_{
		public String guid;
		public int id; //NOTE: this is product id
		public String prodNm;//product name associated with id
		public String prodColors;//product supported colors
		public float prodPrice;//product unit costs
		public String color;
		public float len;
		public int quantity;
		public SimplizedForm(){}

		public SimplizedForm(int cusid,String guid, int id, String pn,float prodp,String prodCs, String color, float len,
				int quantity) {
			super(cusid);
			this.guid=guid;
			
			this.id = id;
			this.color = color;
			this.len = len>0?len:1;
			this.quantity = quantity>0?quantity:1;
			this.prodNm=pn;
			this.prodColors=prodCs;
			this.prodPrice=prodp;
			
		}
		
		public String getGuid() {
			return guid;
		}
		public void setGuid(String guid) {
			this.guid = guid;
		}
		public String getProdColors() {
			return prodColors;
		}
		public void setProdColors(String prodColors) {
			this.prodColors = prodColors;
		}
		public float getProdPrice() {
			return prodPrice;
		}
		public void setProdPrice(float prodPrice) {
			this.prodPrice = prodPrice;
		}
		public String getProdNm() {
			return prodNm;
		}
		public void setProdNm(String prodNm) {
			this.prodNm = prodNm;
		}
	
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public float getLen() {
			return len;
		}
		public void setLen(float len) {
			this.len = len;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
	}
	public static class SimplizedForm_{
		public int custprodid;
		
		public SimplizedForm_(){}
		
		public SimplizedForm_(int i) {
			
			this.custprodid = i;
		}
		
		public void setCustprodid(int custprodid) {
			this.custprodid = custprodid;
		}
		public int getCustprodid() {
			return custprodid;
		}
		


	}

}
