package com.tianshao.cuige.appservice.user;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tianshao.cuige.config.SocialContext;
import com.tianshao.cuige.domains.user.User;
import com.tianshao.cuige.domains.user.UserLogonDTO;
import com.tianshao.cuige.domains.user.UserRegistrationDTO;
import com.tianshao.cuige.domains.user.UserRole;
import com.tianshao.cuige.repository.user.IUserRepository;
import com.tianshao.cuige.services.user.IUserService;



/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class LogonController  {
	  @Inject
      private final IUserRepository userRepository=null;

	  @Autowired
	  private final SocialContext socialContext=null;
	  @Inject
	  private final IUserService userService=null;
	  
	   
	    public LogonController(){
	    }
	    
	 
	    @RequestMapping(value="signout",method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public String postlogout(@ModelAttribute("userForm")UserRegistrationDTO dto, @ModelAttribute("signinForm")UserRegistrationDTO dto2,HttpServletResponse resp) throws IOException {
	    	String socialuid=userService.currentUser().getSocialuid();
	    	if(socialuid!=null)
	    		socialContext.disconnect(socialuid);
			return "redirect:signout_";
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
		public String nativeregister(@ModelAttribute("userForm") @Valid UserRegistrationDTO dto,BindingResult result, @ModelAttribute("signinForm")UserLogonDTO dto2,Model model,HttpServletResponse resp,HttpServletRequest req) throws IOException {
			
	        if(result.hasErrors()) {
	            return "nativelogon";
	        }
			
			try{
			
				if(userRepository.getByEmail(dto.getEmail())==null)
				{
					User user=new User(dto);
					userService.addNewRoledUser(user, UserRole.ROLES.ROLE_USER);

					
					model.addAttribute("succ", "Success!");
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
	        return "home";
	    }
	    
/**
 * 	    
 * TODO: 
 * because ajax reloading masonary product list has defects, we have to refresh the 
 * whole page when filtering on the product list.
 */
	    @RequestMapping(value="catid{catid}", method=RequestMethod.GET)
	    public String homebycate(@PathVariable int catid, Model model) {
	    	model.addAttribute("catid",catid);	      
	        return "home";
	    }

	    @RequestMapping(value="search{key}", method=RequestMethod.GET)
	    public String homesearch(@PathVariable String key, Model model) {
	    	model.addAttribute("searchkey",key);	      
	        return "home";
	    }
}
