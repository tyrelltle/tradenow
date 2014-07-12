package com.tianshao.cuige;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tianshao.cuige.domains.product.Category;
import com.tianshao.cuige.domains.product.Image;
import com.tianshao.cuige.domains.product.Product;
import com.tianshao.cuige.domains.user.User;
import com.tianshao.cuige.repository.product.IProductRepository;
import com.tianshao.cuige.repository.product.ProductRepository;
import com.tianshao.cuige.repository.user.IUserRepository;
import com.tianshao.cuige.repository.user.UserRepository;
import com.tianshao.cuige.services.product.IProductService;
import com.tianshao.cuige.services.product.ProductService;
import com.tianshao.cuige.services.user.IUserService;
import com.tianshao.cuige.services.user.UserService;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:servlet-context.xml"})
public class SearchTest {
	@Autowired
	IProductRepository productRepository;

	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	IProductService productService;

	@Autowired
	IUserService userService;

	User prof;
	Category cat;
	@Before
	public void init(){
		truncate();
		
		prof=new User();

		userRepository.addNew(prof);

		cat=new Category();
		cat.setName("testcat");
		productRepository.addNew(cat);

	}
	@Test
	public void testSearch(){
		Product prod=new Product();
		prod.setTitle("product1");
		prod.setOwner(prof);
		prod.setCategory(cat);
		productRepository.addNew(prod);
		
		prod=new Product();
		prod.setTitle("product2 product1");
		prod.setOwner(prof);
		prod.setCategory(cat);
		productRepository.addNew(prod);
		
		prod=new Product();
		prod.setTitle("product3");
		prod.setOwner(prof);
		prod.setCategory(cat);
		productRepository.addNew(prod);
		
		List<Product> lis=productRepository.searchByTitle("product1");
		assertEquals(lis.size(),2);
		
	}
	
	@After
	public void truncate(){
		
		try{
			productRepository.truncateTable("Product");
		}catch(Exception e){}
		
		try{
			productRepository.truncateTable("Category");
		}catch(Exception e){}
		try{
			productRepository.truncateTable("User");
		}catch(Exception e){}

	}
}
