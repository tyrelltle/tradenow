package com.tianshao.cuige;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
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

	    @Autowired 
	    private IUserService userService;
	    @Autowired
	    private IProductRepository productRepository;
	    @Autowired
	    private ITradeService tradeService;
	    
	    
	    
	    /*called to first time start trade page, while fromprod is not choosen yet*/
	    @RequestMapping(value="toprod/{toprod_id}", method=RequestMethod.GET)
	    public String home(Model model, 
	    				   @ModelAttribute("tradeForm")TradePageDTO dto, 
	    				   @PathVariable int toprod_id,
	    				   HttpServletResponse resp) throws IOException {
	    	//get toprod
	    	Product toprod=productRepository.getByProductId(toprod_id);
	    	//make fromprod
	    	Product fromprod=new Product();
	    	User fromuser=userService.currentUser();
	    	fromprod.setOwner(fromuser);
	    	fromprod.setThumurl("http://img.vip.xunlei.com/img/banner/201307291420313509.jpg");
	    	fromprod.setTitle("Please select an Item");
	    	
	    	Trade trade=new Trade();
	    	trade.setMethod1(Trade.INPERSON);
	    	trade.setMethod2(Trade.INPERSON);
	    	trade.setProd2(toprod);
	    	trade.setStatus1(Trade.PEND);
	    	trade.setStatus2(Trade.PEND);
	    	boolean success=tradeService.addTradeWithoutValidation(trade);
	    	if(!success){
	    		resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Item not exist");
    			return null;
    		}
	    	
	    	dto.setSide(Trade.FROM_TO.FROM.toString());
	    	dto.setTradeid(String.valueOf(trade.getTrade_id()));
	    	model.addAttribute("prod1",fromprod);
	    	model.addAttribute("trade",trade);
	    	
	    	
	        return "tradepage";
	    }

	    
}
