package com.tianshao.cuige;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tianshao.cuige.domains.product.Category;
import com.tianshao.cuige.domains.product.Product;
import com.tianshao.cuige.domains.trade.Trade;
import com.tianshao.cuige.domains.trade.Trade.FROM_TO;
import com.tianshao.cuige.domains.user.User;
import com.tianshao.cuige.repository.product.IProductRepository;
import com.tianshao.cuige.repository.product.ProductRepository;
import com.tianshao.cuige.repository.trade.ITradeRepository;
import com.tianshao.cuige.repository.trade.TradeRepository;
import com.tianshao.cuige.repository.user.IUserRepository;
import com.tianshao.cuige.services.product.IProductService;
import com.tianshao.cuige.services.product.ProductService;
import com.tianshao.cuige.services.trade.ITradeService;
import com.tianshao.cuige.services.trade.TradeService;
import com.tianshao.cuige.services.user.IUserService;
import com.tianshao.cuige.services.user.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:servlet-context.xml"})
public class TradeTest {
	@Autowired
	IProductService productserv;

	@Autowired
	IUserService userService;
	
	@Autowired
	ITradeService tradeService;
	
	@Autowired
	IProductRepository productRepository;

	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	ITradeRepository tradeRepository;
	
	
	User prof;
	User prof2;
	User prof3;
	Category cat;
	
	@Before
	public void init(){
		truncate();
		prof=new User();
		prof2=new User();
		prof3=new User();
		userRepository.addNew(prof);
		userRepository.addNew(prof2);
		userRepository.addNew(prof3);

		cat=new Category();
		cat.setName("testcat");
		productRepository.addNew(cat);
	}
	/*

	@Test
	public void testadd() throws Exception{
	
		
		Product prod1= new Product();
		prod1.setCategory(cat);
		prod1.setOwner(prof);
		productRepository.addNew(prod1);
		
		Product prod2= new Product();
		prod2.setCategory(cat);
		prod2.setOwner(prof2);
		productRepository.addNew(prod2);
		
		Trade trade=new Trade();
		trade.setProd1(prod1);
		trade.setProd2(prod1);
		tradeRepository.addNew(trade);
		//make sure prevent trading with self
		assertEquals(-1,trade.getTrade_id());
		assertEquals(0,tradeserv.count());
		
		
		
		trade.setProd2(prod2);
		tradeserv.add(trade);
		assertFalse(-1==trade.getTrade_id());
		assertEquals(1,tradeserv.count());
		
		List<Trade> tlis=tradeserv.getByProdId(prod1.getProd_id());
		assertEquals(1,tlis.size());
		
		//since tradealready exists, this time cant add anymore
		Trade trade2=new Trade();
		trade2.setProd1(prod2);
		trade2.setProd2(prod1);
		tradeserv.add(trade2);
		assertEquals(-1,trade2.getTrade_id());

	}
	*/
	@Test
	public void testupdatecolumns() throws Exception{
		//trade1: prod1->prod2 owner1 -> owner2
		//trade2: prod3->prod4 owner1 -> owner2
		//trade3: prod5->prod6 owner2 -> owner1
		
		Product prod1= new Product();
		prod1.setCategory(cat);
		prod1.setOwner(prof);
		productRepository.addNew(prod1);
		
		Product prod2= new Product();
		prod2.setCategory(cat);
		prod2.setOwner(prof2);
		productRepository.addNew(prod2);
		
		Trade t=new Trade();
		t.setProd1(prod1);
		t.setProd2(prod2);
		t.setDefaultValues();
		tradeRepository.addNew(t);
		
		t.setMethod1("1");
		t=tradeService.updateProposedTrade(t, "FROM");
		t.setDefaultValues();
		t.setMethod2("2");
		t=tradeService.updateProposedTrade(t, "TO");
		assertTrue(t.getMethod1().equals("1") && t.getMethod2().equals("2"));

	}
	@Test
	public void deeptestadd() throws Exception{
		//trade1: prod1->prod2 owner1 -> owner2
		//trade2: prod3->prod4 owner1 -> owner2
		//trade3: prod5->prod6 owner2 -> owner1
		
		Product prod1= new Product();
		prod1.setCategory(cat);
		prod1.setOwner(prof);
		productRepository.addNew(prod1);
		
		Product prod2= new Product();
		prod2.setCategory(cat);
		prod2.setOwner(prof2);
		productRepository.addNew(prod2);
		
		Product prod3= new Product();
		prod3.setCategory(cat);
		prod3.setOwner(prof);
		productRepository.addNew(prod3);
		
		Product prod4= new Product();
		prod4.setCategory(cat);
		prod4.setOwner(prof2);
		productRepository.addNew(prod4);
		
		Product prod5= new Product();
		prod5.setCategory(cat);
		prod5.setOwner(prof2);
		productRepository.addNew(prod5);
		
		Product prod6= new Product();
		prod6.setCategory(cat);
		prod6.setOwner(prof);
		productRepository.addNew(prod6);
		
		Trade trade1=new Trade();
		trade1.setProd1(prod1);
		trade1.setProd2(prod2);
		tradeRepository.addNew(trade1);

		Trade trade2=new Trade();
		trade2.setProd1(prod3);
		trade2.setProd2(prod4);
		tradeRepository.addNew(trade2);		
		
		Trade trade3=new Trade();
		trade3.setProd1(prod5);
		trade3.setProd2(prod6);
		tradeRepository.addNew(trade3);
		
		//test there are totally 3 trades
		assertEquals(3,tradeRepository.getByUserId(prof.getUserid(),FROM_TO.BOTH).size());
		assertEquals(3,tradeRepository.getByUserId(prof2.getUserid(),FROM_TO.BOTH).size());
		//test 2 trades are from user 1
		assertEquals(2,tradeRepository.getByUserId(prof.getUserid(),FROM_TO.FROM).size());
		//test 1 trade is from user 2
		assertEquals(1,tradeRepository.getByUserId(prof2.getUserid(),FROM_TO.FROM).size());
		//test 2 trades are to user 2
		assertEquals(2,tradeRepository.getByUserId(prof2.getUserid(),FROM_TO.TO).size());
		//test 1 trade is to user 1
		assertEquals(1,tradeRepository.getByUserId(prof.getUserid(),FROM_TO.TO).size());


	}
	@After
	public void truncate(){
		try{
			tradeRepository.truncateTable("Trade");
		}catch(Exception e){}	
		
		try{
			tradeRepository.truncateTable("Product");
		}catch(Exception e){}
		
		try{
			tradeRepository.truncateTable("Category");
		}catch(Exception e){}
		try{
			tradeRepository.truncateTable("Image");
		}catch(Exception e){}
		
		try{
			tradeRepository.truncateTable("Profile");
		}catch(Exception e){}

	}
	
}