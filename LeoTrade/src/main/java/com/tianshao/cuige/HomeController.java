package com.tianshao.cuige;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tianshao.cuige.database.DAO;
import com.tianshao.cuige.models.Event;
import com.tianshao.cuige.models.Product;
import com.tianshao.cuige.services.EventService;
import com.tianshao.cuige.services.ProductService;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/test")
public class HomeController {
    @Autowired
    ProductService service;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//@Transactional
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Product p=new Product("perfect stone", 10, "red;green");
		service.addProductWithCatId(p, 1);
		
		//service.removeEvent(e.id);
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", "Test");//formattedDate );
		
		return "home";
	}
	
}
