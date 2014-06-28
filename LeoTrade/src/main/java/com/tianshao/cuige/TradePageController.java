package com.tianshao.cuige;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianshao.cuige.config.SecurityContext;
import com.tianshao.cuige.models.Category;
import com.tianshao.cuige.models.Product;
import com.tianshao.cuige.models.Trade;
import com.tianshao.cuige.models.User;
import com.tianshao.cuige.models.DTO.TradePageDTO;
import com.tianshao.cuige.models.DTO.UserRegistrationDTO;
import com.tianshao.cuige.repository.IProductRepository;
import com.tianshao.cuige.repository.ITradeRepository;
import com.tianshao.cuige.repository.IUserRepository;
import com.tianshao.cuige.services.IProductService;
import com.tianshao.cuige.services.ITradeService;
import com.tianshao.cuige.services.IUserService;




/**
 * Handles requests for the application home page.
 */
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
	    				   @ModelAttribute("tradeForm")TradePageDTO dto, 
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
	    	int userid=SecurityContext.getCurrentUser().getUserid();
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
		    	fromprod = makeDummyFromProd(SecurityContext.getCurrentUser().getUserid());
		    	toprod=productRepository.getByProductId(toprod_id);
	    	}
	    	trade.setProd1(fromprod);
	    	trade.setProd2(toprod);
	    	//3
	    	model.addAttribute("trade",trade);
	    	//4
	    	dto.setSide(trade.getSideByUserId(userid).name());
		    dto.setMethod(trade.getMethodByUserId(userid));      
	    	dto.setTradeid(String.valueOf(trade.getTrade_id()));
	    	dto.setProd2id(String.valueOf(toprod_id));
	    	dto.setProd1id(String.valueOf(fromprod.getProd_id()));
	    			   
	    	
	        return "tradepage";
	    }
	    
	    @RequestMapping(value="{trade_id}", method=RequestMethod.GET)
	    public String getbyid(Model model, 
	    				   @ModelAttribute("tradeForm")TradePageDTO dto, 
	    				   @PathVariable int trade_id,
	    				   HttpServletRequest req,
	    				   HttpServletResponse resp) throws IOException {
	    	int userid=SecurityContext.getCurrentUser().getUserid();
	    	Trade trade=tradeRepository.getByTradeid(trade_id);
	    	Product fromprod;
	    	if(trade!=null){
	    		//user already have a trade associated with toprod
	    		fromprod=trade.getProd1();
	    		dto.setProd1id(String.valueOf(fromprod.getProd_id()));
		    	dto.setSide(trade.getSideByUserId(userid).name());
		    	dto.setMethod(trade.getMethodByUserId(userid));  	
	    	}else{
	    		resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Trade not exist");
    			return null;		  
	    	}
	    	model.addAttribute("trade",trade);
	    	dto.setProd2id(String.valueOf(trade.getProd2().getProd_id()));
	    	dto.setTradeid(String.valueOf(trade.getTrade_id()));
	        return "tradepage";
	    }

	    /*called to first time start trade page, while fromprod is not choosen yet*/
	    @RequestMapping(value="submit", method=RequestMethod.POST)
	    public String submit(Model model, 
	    				   @ModelAttribute("tradeForm")TradePageDTO dto, 
	    				   HttpServletResponse resp) throws Exception {

	    	boolean prod1specified=false;
	    	Product prod1;
	    	Product prod2;
	    	if(dto.getProd1id()==null || dto.getProd1id().equals("-1")){
	    		prod1=this.makeDummyFromProd(Integer.valueOf(dto.getProd1id()));
	    		model.addAttribute("msgtype",msg_err);
		    	model.addAttribute("msg","Please choose an item from your inventory!");		    	
		    	prod1specified=false;
	    	}else{
	    		prod1=productRepository.getByProductId(Integer.valueOf(dto.getProd1id()));
	    		model.addAttribute("msgtype",msg_suc);
		    	model.addAttribute("msg","you have proposed a new item!");
		    	prod1specified=true;
	    	}
	    	
	    	Trade trade=null;
	    	if(prod1specified){
	    		//create or update the trade
	    		boolean firsttime=false;
		    	trade=tradeRepository.getByTradeid(Integer.valueOf(dto.getTradeid()));
	    		if(trade==null){	
	    			firsttime=true;
	    			trade=new Trade();
	    			prod2=productRepository.getByProductId(Integer.valueOf(dto.getProd2id()));

	    		}else{
	    			prod2=trade.getProd2();
	    		}
	    		trade.setProd1(prod1);
	    		trade.setProd2(prod2);
	    		if(firsttime){
	    			tradeService.addNewTrade(trade);
	    			trade.setDefaultValues();
	    		}
	    		else{
	    			tradeRepository.update(trade);
	    		}
		    	dto.setTradeid(String.valueOf(trade.getTrade_id()));
		    	trade.setMethodBySide(dto.getMethod(), dto.getSide());

	    	}else{
	    		//still use dummy trade
		    	trade=new Trade();
		    	prod2=productRepository.getByProductId(Integer.valueOf(dto.getProd2id()));
		    	trade.setProd1(prod1);
		    	trade.setProd2(prod2);
	    	}
	    	dto.setSide(trade.getSideByUserId(SecurityContext.getCurrentUser().getUserid()).name());

	    	model.addAttribute("trade",trade);    	
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
