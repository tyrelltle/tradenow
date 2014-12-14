package com.tradenow.test;

import com.tradenow.domains.product.Category;
import com.tradenow.domains.product.Product;
import com.tradenow.domains.trade.Trade;
import com.tradenow.domains.trade.TradePath;
import com.tradenow.domains.trade.TradePathGenerator;
import com.tradenow.domains.user.User;
import com.tradenow.repository.product.IProductRepository;
import com.tradenow.repository.trade.ITradeRepository;
import com.tradenow.repository.user.IUserRepository;
import com.tradenow.services.product.IProductService;
import com.tradenow.services.trade.ITradeService;
import com.tradenow.services.user.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

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
    User prof4;
    User prof5;
    User prof6;
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
        prof4=new User();
        prof5=new User();
        prof6=new User();


        userRepository.addNew(prof);
        userRepository.addNew(prof2);
        userRepository.addNew(prof3);
        userRepository.addNew(prof4);
        userRepository.addNew(prof5);
        userRepository.addNew(prof6);

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
        prod3.setOwner(prof3);
        productRepository.addNew(prod3);

        prod4= new Product();
        prod4.setCategory(cat);
        prod4.setOwner(prof4);
        productRepository.addNew(prod4);

        prod5= new Product();
        prod5.setCategory(cat);
        prod5.setOwner(prof5);
        productRepository.addNew(prod5);

        prod6= new Product();
        prod6.setCategory(cat);
        prod6.setOwner(prof6);
        productRepository.addNew(prod6);



    }




    @Test
    public void testTradePathAdd() throws Exception{
        Trade dummytrade=new Trade();
        dummytrade.setTrade_id(1);
        TradePath tradepath=new TradePath(prod1);
        tradepath.addNode(prod2,dummytrade);
        tradepath.addNode(prod3,dummytrade);
        assertEquals(tradepath.getInitialProduct().getProd_id(),prod1.getProd_id());
        assertEquals(tradepath.getNode(0).getProduct().getProd_id(),prod2.getProd_id());
        assertEquals(tradepath.getNode(1).getProduct().getProd_id(),prod3.getProd_id());
    }


    @Test
    public void testTradePathGenerator_TraverseMap(){
        Trade dummytrade=new Trade();
        dummytrade.setTrade_id(1);
        TradePathGenerator.TraverseMap map=new TradePathGenerator.TraverseMap();
        map.putOrCreate(prod1,prod2,dummytrade);
        map.putOrCreate(prod2,prod3,dummytrade);
        map.putOrCreate(prod4,prod5,dummytrade);
        ArrayList<TradePath> lis=map.retrieveTradePaths();

        assertEquals(lis.size(),2);

        TradePath path1,path2;
        if(lis.get(0).size()==2){
            path1=lis.get(0);
            path2=lis.get(1);
        }else{
            path1=lis.get(1);
            path2=lis.get(0);
        }

        //ensure the map contains correct tradepath
        assertEquals(path1.getInitialProduct().getProd_id(),prod1.getProd_id());
        assertEquals(path1.getNode(0).getProduct().getProd_id(),prod2.getProd_id());
        assertEquals(path1.getNode(1).getProduct().getProd_id(),prod3.getProd_id());

        assertEquals(path2.getInitialProduct().getProd_id(),prod4.getProd_id());
        assertEquals(path2.getNode(0).getProduct().getProd_id(),prod5.getProd_id());
    }

    @Test
    public void testTradePathGenerator() throws Exception{
        /**
         * initialize trades
         */
        List<Trade> tradelis=new ArrayList<Trade>();

        Trade t1=createtrade(prod1,prod2);
        tradelis.add(t1);

        Trade t2=createtrade(prod2,prod3);
        tradelis.add(t2);

        Trade t3=createtrade(prod3,prod4);
        tradelis.add(t3);

        Trade t4=createtrade(prod4,prod5);
        tradelis.add(t4);


        List<TradePath> paths=TradePathGenerator.generatorFromTrades(prof.getUserid(),tradelis);

        assertEquals(paths.size(),1);
        assertEquals(paths.get(0).size(),4);
        assertEquals(paths.get(0).getInitialProduct().getProd_id(),prod1.getProd_id());

        assertEquals(paths.get(0).getNode(0).getProduct().getProd_id(),prod2.getProd_id());
        assertEquals(paths.get(0).getNode(0).getTrade().getTrade_id(),t1.getTrade_id());

        assertEquals(paths.get(0).getNode(1).getProduct().getProd_id(),prod3.getProd_id());
        assertEquals(paths.get(0).getNode(1).getTrade().getTrade_id(),t2.getTrade_id());

        assertEquals(paths.get(0).getNode(2).getProduct().getProd_id(),prod4.getProd_id());
        assertEquals(paths.get(0).getNode(2).getTrade().getTrade_id(),t3.getTrade_id());

        assertEquals(paths.get(0).getNode(3).getProduct().getProd_id(),prod5.getProd_id());
        assertEquals(paths.get(0).getNode(3).getTrade().getTrade_id(),t4.getTrade_id());

    }


    @Test
    public void testTradePathGenerator_multiplePaths() throws Exception{
        /**
         * initialize trades
         */
        List<Trade> tradelis=new ArrayList<Trade>();

        //trades that will form user1's tradepath
        Trade t1=createtrade(prod1,prod2);
        tradelis.add(t1);

        Trade t2=createtrade(prod2,prod3);
        tradelis.add(t2);

        Trade t3=createtrade(prod3,prod4);
        tradelis.add(t3);
        //create trades for another tradepath of he user
        prod5.setOwner(prof);
        productRepository.update(prod5);
        Trade t4=createtrade(prod5,prod6);
        tradelis.add(t4);


        List<TradePath> paths=TradePathGenerator.generatorFromTrades(prof.getUserid(),tradelis);

        TradePath path1,path2;
        if(paths.get(0).size()==3){
            path1=paths.get(0);
            path2=paths.get(1);
        }else{
            path1=paths.get(1);
            path2=paths.get(0);
        }

        assertEquals(paths.size(),2);
        assertEquals(path1.size(),3);
        assertEquals(path2.size(),1);

        assertEquals(path1.getInitialProduct().getProd_id(),prod1.getProd_id());

        assertEquals(path1.getNode(0).getProduct().getProd_id(),prod2.getProd_id());
        assertEquals(path1.getNode(0).getTrade().getTrade_id(),t1.getTrade_id());

        assertEquals(path1.getNode(1).getProduct().getProd_id(),prod3.getProd_id());
        assertEquals(path1.getNode(1).getTrade().getTrade_id(),t2.getTrade_id());

        assertEquals(path1.getNode(2).getProduct().getProd_id(),prod4.getProd_id());
        assertEquals(path1.getNode(2).getTrade().getTrade_id(),t3.getTrade_id());

        assertEquals(path2.getInitialProduct().getProd_id(),prod5.getProd_id());
        assertEquals(path2.getNode(0).getProduct().getProd_id(),prod6.getProd_id());
        assertEquals(path2.getNode(0).getTrade().getTrade_id(),t4.getTrade_id());


    }


    private Trade createtrade(Product proda,Product prodb) throws Exception {
        Trade t1=new Trade();
        t1.setDefaultValues();
        t1.setProd1(proda);
        t1.setProd2(prodb);
        tradeRepository.addNew(t1);
        t1.setStatus1(Trade.STATUS.ACCEPTED.name());
        t1.setStatus2(Trade.STATUS.ACCEPTED.name());
        tradeService.closeTradeAndPersist(t1);
        return t1;
    }
}