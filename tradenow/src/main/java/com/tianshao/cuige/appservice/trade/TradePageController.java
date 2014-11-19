package com.tianshao.cuige.appservice.trade;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tianshao.cuige.domains.product.Product;
import com.tianshao.cuige.domains.trade.Trade;
import com.tianshao.cuige.domains.user.User;
import com.tianshao.cuige.repository.product.IProductRepository;
import com.tianshao.cuige.repository.trade.ITradeRepository;
import com.tianshao.cuige.repository.user.IUserRepository;
import com.tianshao.cuige.services.trade.ITradeService;
import com.tianshao.cuige.services.user.IUserService;


@Controller
@RequestMapping("/tradepage")
public class TradePageController {
		private final String msg_suc="alert-success";
		private final String msg_err="alert-danger";
	    @Autowired 
	    private IUserService userService;
	    @Autowired 
	    private IUserRepository userRepository;
	    @Autowired
	    private IProductRepository productRepository;
	    @Autowired
	    private ITradeService tradeService;
	    @Autowired
	    private ITradeRepository tradeRepository;	    
	    
	    /*called to first time start trade page, while fromprod is not choosen yet*/
	    @RequestMapping(value="toprod/{toprod_id}", method=RequestMethod.GET)
	    public String home(Model model, 
	    				   @PathVariable int toprod_id,
	    				   HttpServletRequest req,
	    				   HttpServletResponse resp) throws IOException {
	    	/**
	    	 * 1.if trade exists, get the trade and tell user already have
	    	 * 	  get prod1 prod2
	    	 * 2.if trade not exist, create trade object not persist. 
	    	 * 	  get prod2 by toprod_id
	    	 * 	  create dummy prod1
	    	 *    set prod1 prod2 to trade
	    	 * 3.add trade to model attribute
	    	 * 4.add to/from prod_id to dto
	    	 */
	    	boolean newtrade=false;
	    	int userid=userService.currentUser().getUserid();
	    	Product toprod = null;
	    	Product fromprod = null;
	    	
	    	//1
	    	Trade trade=tradeRepository.getTradeWithGivenItem(userid, toprod_id);
	    	if(trade!=null){
	    		model.addAttribute("msgtype",msg_suc);
		    	model.addAttribute("msg","you already have a trade with this item!");
		    	fromprod=trade.getProd1();
		    	toprod=trade.getProd2();
	    	}	    	
	    	//2
	    	else{
	    		newtrade=true;
		    	trade=new Trade();
		    	fromprod = makeDummyFromProd(userService.currentUser().getUserid());
		    	toprod=productRepository.getByProductId(toprod_id);
		    	trade.setDefaultValues();
	    	}
	    	trade.setProd1(fromprod);
	    	trade.setProd2(toprod);
	    	//3
	    	model.addAttribute("trade",trade);
	    	model.addAttribute("side",trade.getSideByUserId(userService.currentUser().getUserid()));

	        return "tradepage";
	    }
	    
	    @RequestMapping(value="{trade_id}", method=RequestMethod.GET)
	    public String getbyid(Model model, 
	    				   @PathVariable int trade_id,
	    				   HttpServletRequest req,
	    				   HttpServletResponse resp) throws IOException {
	    	int userid=userService.currentUser().getUserid();
	    	Trade trade=tradeRepository.getByTradeid(trade_id);
	    	Product fromprod;
	    	if(trade!=null){
	    		//user already have a trade associated with toprod
	    		fromprod=trade.getProd1();
	    	}else{
	    		resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Trade not exist");
    			return null;		  
	    	}
	    	model.addAttribute("trade",trade);
	    	model.addAttribute("side",trade.getSideByUserId(userid));

	        return "tradepage";
	    }


	    
		private Product makeDummyFromProd(int ownerid) {
			Product fromprod=new Product();
	    	User fromuser=userRepository.getByUserid(ownerid);
	    	fromprod.setOwner(fromuser);
	    	fromprod.setThumurl("http://img.vip.xunlei.com/img/banner/201307291420313509.jpg");
	    	fromprod.setTitle("Please select an Item");
			return fromprod;
		}

}
