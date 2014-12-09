package com.tradenow.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tradenow.domains.product.Category;
import com.tradenow.domains.product.Product;
import com.tradenow.domains.user.User;
import com.tradenow.repository.product.IProductRepository;
import com.tradenow.repository.user.IUserRepository;
import com.tradenow.services.Admin.IAdminService;
import com.tradenow.services.product.IProductService;
import com.tradenow.services.user.IUserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:servlet-context.xml"})
public class SearchTest{
	@Autowired
	Repo repo;
	@Autowired
	IProductRepository productRepository;

	@Autowired
	IAdminService adminService;
	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	IProductService productService;

	@Autowired
	IUserService userService;

	User u1,u2,u3,u4;
	Category cat;
	@Before
	public void init() throws InterruptedException{
		truncate();
		u1=new User();
		u1.setLatitude(49.211391);
		u1.setLongitude(-122.9014307);
		userRepository.addNew(u1);
		
		u2=new User();
		u2.setLatitude(49.1978814);
		u2.setEmail("e");
		u2.setLongitude(-122.8241993);
		userRepository.addNew(u2);

		u3=new User();
		u3.setLatitude(48.9897048);
		u3.setLongitude(-122.2916836);
		userRepository.addNew(u3);
		
		u4=new User();
		u4.setLatitude(39.5915411);
		u4.setLongitude(-16.1626502);
		u4.setEmail("e");
		userRepository.addNew(u4);

		cat=new Category();
		cat.setName("testcat");
		userRepository.addNew(cat);

	}

	
	@Test
	public void testSearch(){
		Product prod=new Product();
		prod.setTitle("product1");
		prod.setOwner(u1);
		prod.setCategory(cat);
		productRepository.addNew(prod);
		
		prod=new Product();
		prod.setTitle("product2 product1");
		prod.setOwner(u2);
		prod.setCategory(cat);
		productRepository.addNew(prod);
		
		prod=new Product();
		prod.setTitle("product3");
		prod.setOwner(u3);
		prod.setCategory(cat);
		productRepository.addNew(prod);
		
		List<Product> lis=productRepository.searchByTitle(u3.getUserid(),"product1",0,100);
		assertEquals(lis.size(),2);
		
	}
	
	
	@Test
	@Transactional
	public void testSerachByLocation() throws Exception{
		
		Product prod2=new Product();
		prod2=new Product();
		prod2.setTitle("product2 product1");
		prod2.setOwner(u2);
		prod2.setCategory(cat);
		productRepository.addNew(prod2);
		
		Product prod=new Product();
		prod.setTitle("product1");
		prod.setOwner(u1);
		prod.setCategory(cat);
		productRepository.addNew(prod);
		

		
		Product prod3=new Product();
		prod3.setTitle("product3");
		prod3.setOwner(u4);
		prod3.setCategory(cat);
		productRepository.addNew(prod3);
		//prod1 belong u1, prod2 belong u2, prod3 belong to u4 which is far from u1 and u2
		//test search u1's location, the result is sorted, first elements is prod1,2, last one is prod3
		List<Product> p =productRepository.getAllButMeByAddr(u3, u1.getLatitude(), u1.getLongitude(), 0, 100);
		assertTrue(p.get(0).getTitle().equals(prod.getTitle()));
		assertTrue(p.get(1).getTitle().equals(prod2.getTitle()));
		assertTrue(p.get(2).getTitle().equals(prod3.getTitle()));

	}
	
	@After
	public void truncate(){

	}
}
