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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianshao.cuige.models.Category;
import com.tianshao.cuige.models.Product;
import com.tianshao.cuige.models.Profile;
import com.tianshao.cuige.services.ProductService;
import com.tianshao.cuige.services.ProfileService;




/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/tradepage")
public class TradePageController {
	    @Autowired
	    private ProductService prodserv;
	    @Autowired ProfileService profserv;
	   
	    private final Facebook facebook;

	    @Inject
	    public TradePageController(Facebook facebook) {
	        this.facebook = facebook;
	    }

	    /*called to first time start trade page, while fromprod is not choosen yet*/
	    @RequestMapping(value="toprod/{toprod_id}", method=RequestMethod.GET)
	    public String home(Model model,@PathVariable int toprod_id) {
	    	Product toprod=prodserv.getByProdId(toprod_id);
	    	Product fromprod=new Product();
	    	Profile fromuser=profserv.getByProfid(facebook.userOperations().getUserProfile().getId());
	    	fromprod.setOwner(fromuser);
	    	fromprod.setThumurl("http://img.vip.xunlei.com/img/banner/201307291420313509.jpg");
	    	fromprod.setTitle("Please select an Item");
	    	model.addAttribute("toprod",toprod);
	    	model.addAttribute("fromprod", fromprod);
	    	
	        return "tradepage";
	    }

	    
}
