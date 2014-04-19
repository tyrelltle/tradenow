package com.tianshao.cuige;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Reference;
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
@RequestMapping("/")
public class HomeController {
	  private final Facebook facebook;

	    @Inject
	    public HomeController(Facebook facebook) {
	        this.facebook = facebook;
	    }

	    @RequestMapping( method=RequestMethod.GET)
	    public String home(Model model) {
	        List<Reference> friends = facebook.friendOperations().getFriends();
	        model.addAttribute("friends", friends);
	        return "home";
	    }

	
}
