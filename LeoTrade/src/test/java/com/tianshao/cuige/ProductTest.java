package com.tianshao.cuige;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tianshao.cuige.models.Category;
import com.tianshao.cuige.models.Image;
import com.tianshao.cuige.models.Product;
import com.tianshao.cuige.models.User;
import com.tianshao.cuige.repository.IProductRepository;
import com.tianshao.cuige.repository.IUserRepository;
import com.tianshao.cuige.repository.ProductRepository;
import com.tianshao.cuige.repository.UserRepository;
import com.tianshao.cuige.services.IProductService;
import com.tianshao.cuige.services.IUserService;
import com.tianshao.cuige.services.ProductService;
import com.tianshao.cuige.services.UserService;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:servlet-context.xml"})
public class ProductTest {
/*	@Autowired
	IProductRepository productRepository;

	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	IProductService productService;

	@Autowired
	IUserService userService;
	
	

	
	
	public void testadd() throws Exception{
	
		User prof=new User();
		Category cat=new Category();
		cat.setName("testcat");
		productRepository.addNew(cat);
		userRepository.addNew(prof);

		Product prod= new Product();
		prod.setOwner(prof);
		productRepository.addNew(prod);
		
		
		List<Product> lis=productRepository.getByUserId(prof.getUserid());
		assertEquals(lis.size(),1);
		assertEquals(lis.get(0).getCategory().getName(), "testcat");
		assertEquals(lis.get(0).getOwner().getSocial_id(), "test social id");
		
		productRepository.remove(prod);
		userRepository.remove(prof);
		productRepository.remove(cat);
		
		
	}
	
	
	
	@Test
	public void testupdate() throws Exception {

		User prof=new User();
		Category cat=new Category();
		cat.setName("testcat");
		productRepository.addNew(cat);
		userRepository.addNew(prof);
		Product prod= new Product();
		prod.setOwner(prof);
		prod.setCategory(cat);
		productRepository.addNew(prod);
		
		List<Product> lis=productRepository.getByUserId(prof.getUserid());
		int numofrecords=lis.size();
		
		Product updatep=lis.get(0);
		updatep.setDetail("detail updated");
		productRepository.update(updatep);
		
		lis=productRepository.getByUserId(prof.getUserid());
		assertEquals(numofrecords,lis.size());
		productRepository.remove(prod);
		userRepository.remove(prof);
		productRepository.remove(cat);
		
	}
	
	@Test
	public void testImageAdd() throws Exception{

		User prof=new User();
		Category cat=new Category();
		cat.setName("testcat");
		productRepository.addNew(cat);
		userRepository.addNew(prof);

		Product prod= new Product();
		prod.setOwner(prof);
		prod.setCategory(cat);

		productRepository.addNew(prod);
		assertEquals(0,prod.getImages().size());
		assertEquals(0,productRepository.countProductImage(prod.getProd_id()));
		
		Image img = new Image();
		img.setImage_name("image_name");
		img.setImage_size(123456);
		img.setImage_type("jpeg");
		img.setProduct(prod);
		prod.getImages().add(img);
		productRepository.update(prod);
		
		//assert the new image id is set to normal key value
		assertTrue(img.getImg_id()>=0);
		
		assertEquals(1,prod.getImages().size());
		assertEquals(1,productRepository.countProductImage(prod.getProd_id()));

		Image img2 = new Image();
		img2.setImage_name("image_name");
		img2.setImage_size(123456);
		img2.setImage_type("jpeg");
		img2.setProduct(prod);
		prod.getImages().add(img2);
		productRepository.update(prod);
		
		assertEquals(2,productRepository.countProductImage(prod.getProd_id()));
		assertEquals(2,prod.getImages().size());
		
		productRepository.remove(prod);
		userRepository.remove(prof);
		productRepository.remove(cat);
		
	}
	
	@Test
	public void testImageCount() throws Exception{
		User prof=new User();
		Category cat=new Category();
		cat.setName("testcat");
		productRepository.addNew(cat);
		userRepository.addNew(prof);

		Product prod= new Product();
		prod.setOwner(prof);
		prod.setCategory(cat);

		productRepository.addNew(prod);
		assertEquals(0,productRepository.countProductImage(prod.getProd_id()));
		
		Image img = new Image();
		img.setImage_name("image_name");
		img.setImage_size(123456);
		img.setImage_type("jpeg");
		img.setProduct(prod);
		productService.addProductImage(img);
		
		assertEquals(1,productRepository.countProductImage(prod.getProd_id()));

		productService.addProductImage(img);
		
		assertEquals(2,productRepository.countProductImage(prod.getProd_id()));

		
		productRepository.remove(prod);
		userRepository.remove(prof);
		productRepository.remove(cat);
		
	}
	
	
	//test thumurl is added when first image is added
	@Test
	public void testThumUrlt() throws Exception{
		User prof=new User();
		Category cat=new Category();
		cat.setName("testcat");
		productRepository.addNew(cat);
		userRepository.addNew(prof);

		Product prod= new Product();
		prod.setOwner(prof);
		prod.setCategory(cat);

		productRepository.addNew(prod);
		assertEquals("",prod.getThumurl());
		
		Image img = new Image();
		img.setImage_name("image_name");
		img.setImage_size(123456);
		img.setImage_type("jpeg");
		img.setProduct(prod);
		productService.addProductImage(img);
		
		assertEquals("http://localhost:8080/cuige/api/product/img/"+img.getImg_id(),prod.getThumurl());

		
		productRepository.remove(prod);
		userRepository.remove(prof);
		productRepository.remove(cat);
		
	}*/
}
