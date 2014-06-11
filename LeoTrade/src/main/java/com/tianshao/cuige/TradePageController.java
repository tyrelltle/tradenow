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
	    private ProductService serv;
	   
	    private final Facebook facebook;

	    @Inject
	    public TradePageController(Facebook facebook) {
	        this.facebook = facebook;
	    }

	    @RequestMapping(value="toprod/{toprod_id}", method=RequestMethod.GET)
	    public String home(Model model,@PathVariable int toprod_id) {
	    	Product toprod=serv.getByProdId(toprod_id);
	    	model.addAttribute("toprod",toprod);
	        return "tradepage";
	    }

	    
}
