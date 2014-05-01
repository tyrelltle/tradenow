package com.tianshao.cuige.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianshao.cuige.database.DAO;
import com.tianshao.cuige.models.Category;
import com.tianshao.cuige.models.Product;
import com.tianshao.cuige.models.Profile;

@Service
public class ProductService extends AbstractService {
	
	@Autowired
	private ProfileService profileService;
	
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

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	
	


}
