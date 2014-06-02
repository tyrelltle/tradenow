package com.tianshao.cuige.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianshao.cuige.database.DAO;
import com.tianshao.cuige.models.Category;
import com.tianshao.cuige.models.Image;
import com.tianshao.cuige.models.Product;
import com.tianshao.cuige.models.Profile;

@Service
public class ProductService extends AbstractService {
	
	@Autowired
	private ProfileService profileService;
	
	
	/*
	 * 
	 * */
	public List<Product> getAll(Integer ...limit) throws Exception{
		if(limit.length!=0 && limit.length!=2)
			throw new Exception("invalid LIMIT parameter for getting all records: neither 0 or 2 parameters ");
		if(limit.length==0)
			return (List<Product>) dao.getAll("Product");
		else
			return (List<Product>) dao.getAll("Product",limit[0],limit[1]);
	}
	
	public List<Product> getBySocialId(String social_id){

		List<Product> lis=(List<Product>) dao.getByFoeignColumn("Product", 
							  "owner", 
							  "social_id", social_id);
		
		if(null == lis || lis.size()==0)
			return null;
		
		return lis;
		
	}

	/**
	 * creates a new product object, assigned category and profile
	 * objects to it with given ids
	 * @throws Exception 
	 */
	public Product populate(String social_id, int catid) throws Exception{
		Profile prof=(Profile) dao.getByColumn("Profile", "social_id", social_id);
		if(null==prof)
			throw new Exception("invalid social id");
		
		Category cat=(Category) dao.getByColumn("Category", "catid", catid);
		if(null==cat)
			throw new Exception("invalid category id");
		
		Product prod=new Product();
		prod.setCategory(cat);
		prod.setOwner(prof);

		
		return prod;
	}
	

	public List<Image> getProductImages(int prod_id){
		List<Image> img=(List<Image>) dao.getByFoeignColumn("Image", "product", "prod_id", prod_id);
		return img;
	}
	public long countProductImage(int prod_id){
		return (Long) dao.directSql("select count(*) from Image i where i.product.prod_id="+prod_id);
	}
	public Image getProductImageByImgId(int img_id){
		return (Image) dao.getByColumn("Image", "img_id", img_id);
		
	}
	

	/**
	 * return: image table record id of the new image 
	 */
	public int addProductImage(Image img){
		dao.addNew(img);
		
		if(this.countProductImage(img.getProduct().getProd_id())==1){
			//this is the first image uploaded for the product. make it thumbail
			Product ownerPro=img.getProduct();
			ownerPro.setThumurl("http://localhost:8080/cuige/api/product/img/"+img.getImg_id());
			dao.update(ownerPro);
		}
		return img.getImg_id();
	}
	@Override
	public String getTableName() {
		return "Product";
	}

	
	

	
	


}
