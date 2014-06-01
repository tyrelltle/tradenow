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
import com.tianshao.cuige.models.Image;
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
	
	
	/**
	 * test if update is not adding new record
	 * @throws Exception 
	 */
	@Test
	public void testupdate() throws Exception {
		Profile prof=profserv.get_create_Profile("test social id");
		Category cat=new Category();
		cat.setName("testcat");
		dao.addNew(cat);
		
		Product prod=prodserv.populate("test social id", cat.getCatid());
		prodserv.add(prod);
		
		List<Product> lis=prodserv.getBySocialId("test social id");
		int numofrecords=lis.size();
		
		Product updatep=lis.get(0);
		updatep.setDetail("detail updated");
		prodserv.update(updatep);
		
		lis=prodserv.getBySocialId("test social id");
		assertEquals(numofrecords,lis.size());
		prodserv.remove(prod);
		profserv.remove(prof);
		dao.remove(cat);
		
	}
	
	@Test
	public void testImageAdd() throws Exception{
		Profile prof=profserv.get_create_Profile("test social id");
		Category cat=new Category();
		cat.setName("testcat");
		dao.addNew(cat);
		
		Product prod=prodserv.populate("test social id", cat.getCatid());
		prodserv.add(prod);
		assertEquals(0,prodserv.getProductImages(prod.getProd_id()).size());
		
		Image img = new Image();
		img.setImage_name("image_name");
		img.setImage_size(123456);
		img.setImage_type("jpeg");
		img.setProduct(prod);
		prodserv.addProductImage(img);
		
		//assert the new image id is set to normal key value
		assertTrue(img.getImg_id()>=0);
		
		assertEquals(1,prodserv.getProductImages(prod.getProd_id()).size());

		prodserv.addProductImage(img);
		
		assertEquals(2,prodserv.getProductImages(prod.getProd_id()).size());

		
		prodserv.remove(prod);
		profserv.remove(prof);
		dao.remove(cat);
		
	}
	
	@Test
	public void testImageCount() throws Exception{
		Profile prof=profserv.get_create_Profile("test social id");
		Category cat=new Category();
		cat.setName("testcat");
		dao.addNew(cat);
		
		Product prod=prodserv.populate("test social id", cat.getCatid());
		prodserv.add(prod);
		assertEquals(0,prodserv.countProductImage(prod.getProd_id()));
		
		Image img = new Image();
		img.setImage_name("image_name");
		img.setImage_size(123456);
		img.setImage_type("jpeg");
		img.setProduct(prod);
		prodserv.addProductImage(img);
		
		assertEquals(1,prodserv.countProductImage(prod.getProd_id()));

		prodserv.addProductImage(img);
		
		assertEquals(2,prodserv.countProductImage(prod.getProd_id()));

		
		prodserv.remove(prod);
		profserv.remove(prof);
		dao.remove(cat);
		
	}
	
	
	//test thumurl is added when first image is added
	@Test
	public void testThumUrlt() throws Exception{
		Profile prof=profserv.get_create_Profile("test social id");
		Category cat=new Category();
		cat.setName("testcat");
		dao.addNew(cat);
		
		Product prod=prodserv.populate("test social id", cat.getCatid());
		prodserv.add(prod);
		assertEquals("",prod.getThumurl());
		
		Image img = new Image();
		img.setImage_name("image_name");
		img.setImage_size(123456);
		img.setImage_type("jpeg");
		img.setProduct(prod);
		prodserv.addProductImage(img);
		
		assertEquals("http://localhost:8080/cuige/api/product/img/"+img.getImg_id(),prod.getThumurl());

		
		prodserv.remove(prod);
		profserv.remove(prof);
		dao.remove(cat);
		
	}
}
