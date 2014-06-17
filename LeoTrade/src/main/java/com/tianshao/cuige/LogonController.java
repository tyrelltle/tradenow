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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tianshao.cuige.config.SecurityContext;
import com.tianshao.cuige.config.UserCookieGenerator;
import com.tianshao.cuige.models.User;
import com.tianshao.cuige.models.DTO.UserLogonDTO;
import com.tianshao.cuige.models.DTO.UserRegistrationDTO;
import com.tianshao.cuige.repository.IUserRepository;
import com.tianshao.cuige.services.IUserService;
import com.tianshao.cuige.services.UserService;



/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class LogonController  {
	  @Inject
      private final IUserRepository userRepository=null;
	  @Inject
	  private final Facebook facebook=null;
	  
	  @Inject
	  private final IUserService userService=null;
	  
	  private final UserCookieGenerator userCookieGenerator = new UserCookieGenerator();
	   
	    public LogonController(){
	    }
	    
	 
	    

		@RequestMapping(value="nativelogon",method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public String nativelogon(@ModelAttribute("userForm")UserRegistrationDTO dto, @ModelAttribute("signinForm")UserRegistrationDTO dto2,HttpServletResponse resp) throws IOException {

			return "nativelogon";
		}
		
		@RequestMapping(value="nativesignin",method = RequestMethod.POST,headers="Accept=*/*",produces="application/json")
		public String nativesignin(@ModelAttribute("signinForm")UserLogonDTO dto, @ModelAttribute("userForm")UserRegistrationDTO dto2,Model model,HttpServletResponse resp,HttpServletRequest req) throws IOException {
			try{
				User user=(userRepository.getByEmailPassword(dto.getEmail(),dto.getPassword()));
				if(null!=user)
				{
					SecurityContext.setCurrentUser(user);
					userCookieGenerator.addCookie(String.valueOf(user.getUserid()), resp);
					return "home";
				}else{
					throw new Exception("user does not exists");
				
				}	
			}catch(Exception e){
				model.addAttribute("errorlogin", e.getMessage());
				return "nativelogon";
			}
	
		}
		@RequestMapping(value="nativeregister",method = RequestMethod.POST,headers="Accept=*/*",produces="application/json")
		public String nativeregister(@ModelAttribute("userForm")UserRegistrationDTO dto, @ModelAttribute("signinForm")UserLogonDTO dto2,Model model,HttpServletResponse resp,HttpServletRequest req) throws IOException {
			try{
			
				if(0==userRepository.getByEmail(dto.getEmail()).size())
				{
					User user=new User(dto);
					userRepository.addNew(user);

					
					model.addAttribute("error", "Success!");
				}else{
					throw new Exception("user exists");
				}	
			}catch(Exception e){
				model.addAttribute("error", e.getMessage());
				
			}
			return "nativelogon";
		}
	    
		
	    @RequestMapping( method=RequestMethod.GET)
	    public String home(Model model) {
	    	
	    	//userService.userSocialInitialize();
	      
	        return "home";
	    }

	
}
