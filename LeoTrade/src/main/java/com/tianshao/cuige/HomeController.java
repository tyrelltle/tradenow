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
import org.springframework.social.facebook.api.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tianshao.cuige.config.SecurityContext;
import com.tianshao.cuige.config.UserCookieGenerator;
import com.tianshao.cuige.models.User;
import com.tianshao.cuige.repository.IUserRepository;
import com.tianshao.cuige.services.IUserService;



/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {
	  @Inject
      private final IUserRepository userRepository=null;
	  private final UserCookieGenerator userCookieGenerator = new UserCookieGenerator();
	   
	    public HomeController(){}
	    
	 
	    

		@RequestMapping(value="nativelogon",method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public String nativelogon( HttpServletResponse resp) throws IOException {
			User user=new User();
			userRepository.addNew(user);
			SecurityContext.setCurrentUser(user);
			userCookieGenerator.addCookie(String.valueOf(user.getUserid()), resp);
			return "home";
		}
		
	    
	    @RequestMapping( method=RequestMethod.GET)
	    public String home(Model model) {
	       
	        return "home";
	    }

	
}
