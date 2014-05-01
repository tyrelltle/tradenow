package com.tianshao.cuige;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tianshao.cuige.database.DAO;
import com.tianshao.cuige.models.Category;
import com.tianshao.cuige.models.Product;
import com.tianshao.cuige.models.Profile;
import com.tianshao.cuige.services.ProductService;
import com.tianshao.cuige.services.ProfileService;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:servlet-context.xml"})
public class ProductTest {
	@Autowired
	ProductService prodserv;

	@Autowired
	ProfileService profserv;
	
	@Autowired
	DAO dao;
	
	
	

	
	
	@Test
	/**
	 * test when user first time trying to get a 
	 * profile record but dosent exist, see if profile service
	 * create a new record
	 */
	public void testadd() throws Exception{
	
		Profile prof=profserv.get_create_Profile("test social id");
		Category cat=new Category();
		cat.setName("testcat");
		dao.addNew(cat);
		
		Product prod=prodserv.populate("test social id", cat.getCatid());
		prodserv.add(prod);
		
		
		List<Product> lis=prodserv.getBySocialId("test social id");
		assertEquals(lis.size(),1);
		assertEquals(lis.get(0).getCategory().getName(), "testcat");
		assertEquals(lis.get(0).getOwner().getSocial_id(), "test social id");
		
		prodserv.remove(prod);
		profserv.remove(prof);
		dao.remove(cat);
		
		
	}
	
	
}
