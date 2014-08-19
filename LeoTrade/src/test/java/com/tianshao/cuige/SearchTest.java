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
import com.tianshao.cuige.repository.BaseRepository;
import com.tianshao.cuige.repository.product.IProductRepository;
import com.tianshao.cuige.repository.product.ProductRepository;
import com.tianshao.cuige.repository.user.IUserRepository;
import com.tianshao.cuige.repository.user.UserRepository;
import com.tianshao.cuige.services.Admin.IAdminService;
import com.tianshao.cuige.services.product.IProductService;
import com.tianshao.cuige.services.product.ProductService;
import com.tianshao.cuige.services.user.IUserService;
import com.tianshao.cuige.services.user.UserService;




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
	public void testProductSpatialSearch_getbycategory() throws Exception{
		Product prod1,prod2,prod3,prod4;
		Category cat2=new Category();
		cat2.setName("wowcat");
		userRepository.addNew(cat2);
		
		prod1=new Product();
		prod1.setCategory(cat);
		prod1.setOwner(u1);
		userRepository.addNew(prod1);
		
		prod2=new Product();
		prod2.setCategory(cat2);
		prod2.setOwner(u3);
		userRepository.addNew(prod2);
		
		prod3=new Product();
		prod3.setCategory(cat2);
		prod3.setOwner(u3);
		userRepository.addNew(prod3);
		
		prod4=new Product();
		prod4.setCategory(cat2);
		prod4.setOwner(u4);
		userRepository.addNew(prod4);
		
//		search by cat2. prod2,3,4 are under cat2, but prod4 is too far. so result is prod2,3 		
		List<Product> lis=productRepository.getByCatId(u1, cat2.getCatid(), 0, 100);
		
		assertEquals(2,lis.size());
		for(Product i : lis)
		{
			assertEquals(u3.getLatitude(),i.getLatitude());
			assertEquals(u3.getLongitude(),i.getLongitude());
		}
	
	}
	
	
	@Test
	public void testProductSpatialSearch_getallbutme() throws Exception{
		Product prod1,prod2,prod3,prod4;
		
		prod1=new Product();
		prod1.setCategory(cat);
		prod1.setOwner(u1);
		productRepository.addNew(prod1);
		
		prod2=new Product();
		prod2.setCategory(cat);
		prod2.setOwner(u1);
		productRepository.addNew(prod2);
		
		prod3=new Product();
		prod3.setCategory(cat);
		prod3.setOwner(u3);
		productRepository.addNew(prod3);
		
		prod4=new Product();
		prod4.setCategory(cat);
		prod4.setOwner(u4);
		productRepository.addNew(prod4);
		
		
		//prod1 and prod2 belong to u1. prod4 is far from all prod1,2,3.  so result of get all but me should be only prod3
		List<Product> lis=productRepository.getAllButMe(u1, 0, 100);
		
		assertEquals(1,lis.size());
		assertEquals(prod3.getLatitude(),lis.get(0).getLatitude());
		assertEquals(prod3.getLongitude(),lis.get(0).getLongitude());
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
	
	@After
	public void truncate(){
		repo.truncateTable("Notification");
	
		
		repo.truncateTable("Product");
		
		repo.truncateTable("Category");
		repo.truncateTable("User");

	}
}
