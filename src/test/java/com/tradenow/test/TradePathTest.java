package com.tradenow.test;

import com.tradenow.domains.product.Category;
import com.tradenow.domains.product.Product;
import com.tradenow.domains.trade.Trade;
import com.tradenow.domains.trade.Trade.FROM_TO;
import com.tradenow.domains.user.User;
import com.tradenow.repository.product.IProductRepository;
import com.tradenow.repository.trade.ITradeRepository;
import com.tradenow.repository.user.IUserRepository;
import com.tradenow.services.product.IProductService;
import com.tradenow.services.trade.ITradeService;
import com.tradenow.services.user.IUserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:servlet-context.xml"})
public class TradePathTest {
    @Autowired
    Repo repo;
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
    private Product prod1;
    private Product prod2;
    private Product prod3;
    private Product prod4;
    private Product prod6;
    private Product prod5;
    private Trade trade3;
    private Trade trade1;
    private Trade trade2;

    @Before
    public void init(){
        prof=new User();
        prof2=new User();
        prof3=new User();
        userRepository.addNew(prof);
        userRepository.addNew(prof2);
        userRepository.addNew(prof3);

        cat=new Category();
        cat.setName("testcat");
        userRepository.addNew(cat);

        prod1= new Product();
        prod1.setCategory(cat);
        prod1.setOwner(prof);
        productRepository.addNew(prod1);

        prod2= new Product();
        prod2.setCategory(cat);
        prod2.setOwner(prof2);
        productRepository.addNew(prod2);

        prod3= new Product();
        prod3.setCategory(cat);
        prod3.setOwner(prof);
        productRepository.addNew(prod3);

        prod4= new Product();
        prod4.setCategory(cat);
        prod4.setOwner(prof2);
        productRepository.addNew(prod4);

        prod5= new Product();
        prod5.setCategory(cat);
        prod5.setOwner(prof2);
        productRepository.addNew(prod5);

        prod6= new Product();
        prod6.setCategory(cat);
        prod6.setOwner(prof);
        productRepository.addNew(prod6);



    }




    @Test
    public void testTradePathAdd() throws Exception{

        TradePath tradepath=new TradePath();
        tradepath.add(prod1);
        tradepath.add(prod2);
        tradepath.add(prod3);

    }

    @Test
    public void testTradePathCollection(){
        trade1=new Trade();
        trade1.setProd1(prod1);
        trade1.setProd2(prod2);
        trade1.setDefaultValues();
        tradeRepository.addNew(trade1);

        trade2=new Trade();
        trade2.setProd1(prod2);
        trade2.setProd2(prod3);
        trade2.setDefaultValues();
        tradeRepository.addNew(trade2);

        trade3=new Trade();
        trade3.setProd1(prod3);
        trade3.setProd2(prod4);
        trade3.setDefaultValues();
        tradeRepository.addNew(trade3);
    }

}