package com.tradenow.test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tradenow.domains.product.Category;
import com.tradenow.domains.product.Product;
import com.tradenow.domains.user.User;
import com.tradenow.repository.product.IProductRepository;
import com.tradenow.repository.user.IUserRepository;
import com.tradenow.services.product.IProductService;
import com.tradenow.services.user.IUserService;


/*
 * Since major architecture changed, ProductTest.java is not runnable. will fix later. 
 * for now, all the new product features will be test in NewProductTest.java
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:servlet-context.xml"})
public class NewProductTest{
	@Autowired
	Repo repo;
	@Autowired
	IProductRepository productRepository;

	
	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	IProductService productService;

	@Autowired
	IUserService userService;


	@Before
	public void init() throws InterruptedException{
		truncate();

	
	}
	
	
	@Test
	public void testUserFavorite() throws Exception{
		User u1,u2,u3,u4;
		Product p1,p2,p3,p4;
		Category cat;
		u1=new User();
		u1.setAboutme("u1");
		u1.setLatitude(49.211391);
		u1.setLongitude(-122.9014307);
		userRepository.addNew(u1);
		
		u2=new User();
		u2.setAboutme("u2");
		u2.setLatitude(49.1978814);
		u2.setEmail("e");
		u2.setLongitude(-122.8241993);
		userRepository.addNew(u2);

		u3=new User();
		u3.setAboutme("u3");
		u3.setLatitude(48.9897048);
		u3.setLongitude(-122.2916836);
		userRepository.addNew(u3);
		
		u4=new User();
		u4.setAboutme("u4");
		u4.setLatitude(39.5915411);
		u4.setLongitude(-16.1626502);
		u4.setEmail("e");
		userRepository.addNew(u4);


		cat=new Category();
		cat.setName("testcat");
		userRepository.addNew(cat);
		
		p1=new Product();
		p1.setOwner(u4);
		p1.setCategory(cat);
		p1.setTitle("product1");
		productRepository.addNew(p1);

	
		p2=new Product();
		p2.setOwner(u4);
		p2.setCategory(cat);
		p2.setTitle("product2");
		productRepository.addNew(p2);
		
		p3=new Product();
		p3.setOwner(u4);
		p3.setCategory(cat);
		p3.setTitle("product3");
		productRepository.addNew(p3);
		
		
		p4=new Product();
		p4.setOwner(u4);
		p4.setCategory(cat);
		p4.setTitle("product4");
		productRepository.addNew(p4);
		
		
		User user1=userRepository.getUserWithFavorites(u1.getUserid());
		User user2=userRepository.getUserWithFavorites(u2.getUserid());
		User user3=userRepository.getUserWithFavorites(u3.getUserid());
		User user4=userRepository.getUserWithFavorites(u4.getUserid());

		user1.addFavorite(p1);
		user1.addFavorite(p2);
		user1.addFavorite(p3);
		user1.addFavorite(p4);
		
		user2.addFavorite(p1);
		user3.addFavorite(p1);
		user4.addFavorite(p1);
		
		userRepository.update(user1);
		userRepository.update(user2);
		userRepository.update(user3);
		userRepository.update(user4);

		user1=userRepository.getUserWithFavorites(u1.getUserid());
		user2=userRepository.getUserWithFavorites(u2.getUserid());
		user3=userRepository.getUserWithFavorites(u3.getUserid());
		user4=userRepository.getUserWithFavorites(u4.getUserid());

		
		assertEquals(4,user1.getFavorites().size());
		assertEquals(1,user2.getFavorites().size());
		assertEquals(1,user3.getFavorites().size());
		assertEquals(1,user4.getFavorites().size());
		
		Iterator<Product> i=user1.getFavorites().iterator();
		while(i.hasNext()){
			Product next=i.next();
			assertTrue(next.getTitle().equals("product1")||
						next.getTitle().equals("product2")||
						next.getTitle().equals("product3")||
						next.getTitle().equals("product4"));
		}

		Product testproduct=productRepository.getProductWithLikers(p1.getProd_id());
		assertEquals(4,testproduct.getLikers().size());
		
		testproduct=productRepository.getProductWithLikers(p2.getProd_id());
		assertEquals(1,testproduct.getLikers().size());
		
		testproduct=productRepository.getProductWithLikers(p2.getProd_id());
		assertEquals(1,testproduct.getLikers().size());
		
		testproduct=productRepository.getProductWithLikers(p3.getProd_id());
		assertEquals(1,testproduct.getLikers().size());
		Iterator<User> ui=testproduct.getLikers().iterator();
		while(ui.hasNext()){
			User next=ui.next();
			assertTrue(next.getAboutme().equals("u1")||
						next.getAboutme().equals("u2")||
						next.getAboutme().equals("u3")||
						next.getAboutme().equals("u4"));
		}

	}
	
	
	@After
	public void truncate(){
	
		
		repo.truncateTable("Product");
		
		repo.truncateTable("Category");
        repo.truncateTable("Regconfirm");
		repo.truncateTable("User");

	}
}
