package com.tianshao.cuige.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianshao.cuige.database.DAO;
import com.tianshao.cuige.models.Category;
import com.tianshao.cuige.models.Product;

@Service
public class ProductService {
	@Autowired
	DAO dao;

	@Autowired
	CategoryService catservice;
	
	public ProductService(){}
	public int addProduct(Product Product)  {
			 dao.addNew(Product);
			 return Product.getId();
	}

	/**
	 * transform model object to simplified version,
	 * only store ids of composite persistent object
	 * @param prod
	 * @return
	 */
	public SimplizedForm toSimplified(Product prod){
		return new SimplizedForm(prod.getId(),
								 prod.getCategory().getCatid(), 
								 prod.getColorbag(), 
								 prod.getUnitprice(),
								 prod.getName());
	}
	/**
	 * transform simplified model object to full model object
	 * @return
	 */
	public Product toFullModel(SimplizedForm sim){
		Category cat=catservice.getCategory(sim.catid);
		if ( null==cat)
			return null;
		Product ret =new Product();
		ret.setCategory(cat);
		ret.setColorbag(sim.colorbag);
		ret.setId(sim.id);
		ret.setName(sim.name);
		ret.setUnitprice(sim.unitprice);
		return ret;
		
	}
	/**
	 * add new product with existing category 
	 * @param product
	 * @param catid
	 * @return
	 */
	public int addProductWithCatId(Product product, int catid){
		Category cat=catservice.getCategory(catid);
		if(null == cat){
			return -1;
		}
		product.setCategory(cat);
		dao.addNew(product);
		return product.getId();
	}

	public List<Product> getProducts()  {
		return (List<Product>)dao.list("Product");
		
	}
	
	public List<Product> getProductsByCat(int catid){
		return (List<Product>)dao.getByColumnByFoeignKey("Product", "category","catid",catid);
	}


	public Product getProduct(int id) {
		
		return (Product)dao.getById("Product", id);
	}


	
	public void removeProduct(int i) {
		dao.remove(Product.class, i);		
	}

	
	public void update(Product e) {

		
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
	public static class SimplizedForm{

		public int id;
		public int catid;
		public String colorbag;
		public float unitprice;
		public String name;
		public SimplizedForm(){}
		public SimplizedForm(int id, int catid, String colorbag,
				float unitprice, String name) {
			super();
			this.id = id;
			this.catid = catid;
			this.colorbag = colorbag;
			this.unitprice = unitprice;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getCatid() {
			return catid;
		}

		public void setCatid(int catid) {
			this.catid = catid;
		}

		public String getColorbag() {
			return colorbag;
		}

		public void setColorbag(String colorbag) {
			this.colorbag = colorbag;
		}

		public float getUnitprice() {
			return unitprice;
		}

		public void setUnitprice(float unitprice) {
			this.unitprice = unitprice;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		
	}

}
