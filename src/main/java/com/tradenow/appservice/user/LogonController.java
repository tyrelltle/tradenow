package com.tradenow.appservice.user;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tradenow.config.SocialContext;
import com.tradenow.domains.mail.Regconfirm;
import com.tradenow.domains.mail.RegconfirmMail;
import com.tradenow.domains.user.PasswordChangeForm;
import com.tradenow.domains.user.Principle;
import com.tradenow.domains.user.User;
import com.tradenow.domains.user.UserLogonDTO;
import com.tradenow.domains.user.UserRegistrationDTO;
import com.tradenow.domains.user.UserRole;
import com.tradenow.repository.mail.IMailRepository;
import com.tradenow.repository.user.IUserRepository;
import com.tradenow.domains.mail.PswResetconfirmMailer;
import com.tradenow.domains.mail.RegconfirmMailer;
import com.tradenow.services.user.IUserService;
import com.tradenow.services.user.UserDetailService;



/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class LogonController  {
	  @Inject
      private final IUserRepository userRepository=null;
	  
	  @Autowired
	  RegconfirmMailer regconfirmMailer;

	  @Autowired
	  PswResetconfirmMailer pswMailer;
	  
	  @Autowired
	  IMailRepository mailRepository;

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


//========reset password		
		/**
		 *handles the address included in user password reset email
		 */
		@RequestMapping(value="pswcon/{regid}",method = RequestMethod.POST,headers="Accept=*/*")
		public String submitpswcon(@PathVariable String regid, @ModelAttribute("form") @Valid PasswordChangeForm form,BindingResult result, Model model,HttpServletRequest req,HttpServletResponse resp) throws IOException {
			Regconfirm regc=mailRepository.getRegconfirmById(regid);
			User u=regc.getUser();
			model.addAttribute("user", u);
			model.addAttribute("uuid",regid);
			
			if(result.hasErrors())
				return "pswconpage";
			
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(form.getPassword());
			u.setPassword(hashedPassword);
			userRepository.update(u);
			//remove request record 
			mailRepository.remove(regc);
			model.addAttribute("succ","true");
			return "pswconpage";
		}	
		@RequestMapping(value="pswcon/{regid}",method = RequestMethod.GET,headers="Accept=*/*")
		public String pswcon(@PathVariable String regid, @ModelAttribute("form")PasswordChangeForm form, Model model,HttpServletRequest req,HttpServletResponse resp) throws IOException {

			Regconfirm regc=mailRepository.getRegconfirmById(regid);
			User u=regc.getUser();
			model.addAttribute("user", u);
			model.addAttribute("uuid",regid);
			return "pswconpage";
		}	
		
		//sends email to user for reseting password. the email should include a callback link to password reset page
	    @RequestMapping(value="/resetpassword/{email}/", method = RequestMethod.POST)
		public @ResponseBody String send_resetpswdemail(@PathVariable String email, HttpServletResponse resp, HttpServletRequest req) throws IOException {			
	    	User u;
	    	
	    	if((u=userRepository.getByEmail(email))!=null)
			{   
				
	    		Regconfirm regc=mailRepository.newRegconfirm_gen(u);
				
			    RegconfirmMail mail = new RegconfirmMail(regc,"http://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath());
			    mail.setMailTo(u);
			    mail.setMailSubject("Confirm your password reset request!");
			    pswMailer.sendMail(mail);
				  
				return "An Email has been sent to you to confirm your password reset!";
			}else{
				return "Sorry, user does not exist with this email";
			}	
			
		}
	    
	    
//===========signin	   
		@RequestMapping(value="loginerror",method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public String failedlogin(@ModelAttribute("userForm")UserRegistrationDTO dto, @ModelAttribute("signinForm")UserRegistrationDTO dto2,Model model,HttpServletResponse resp) throws IOException {
			model.addAttribute("loginerror","Authentication Failed!");
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
		
//=======native register
		@RequestMapping(value="nativeregister",method = RequestMethod.POST,headers="Accept=*/*",produces="application/json")
		public String nativeregister(@ModelAttribute("userForm") @Valid UserRegistrationDTO dto,BindingResult result, @ModelAttribute("signinForm")UserLogonDTO dto2,Model model,HttpServletResponse resp,HttpServletRequest req) throws IOException {
	        if(result.hasErrors()) {
	            return "nativelogon";
	        }
			try{
			
				if(userRepository.getByEmail(dto.getEmail())==null)
				{   //register new user, send validation email
					User user=User.newNativeUser(dto);
					userService.addNewRoledUser(user, UserRole.ROLES.ROLE_USER);
					Regconfirm regc=mailRepository.newRegconfirm_gen(user);
					
				    RegconfirmMail mail = new RegconfirmMail(regc,req.getRequestURL().toString());
				    mail.setMailTo(user);
				    mail.setMailSubject("Confirm your account registration!");
				    regconfirmMailer.sendMail(mail);
					  
					model.addAttribute("succ", "An Email has been sent to you to verify your registration!");
				}else{
					throw new Exception("user exists");
				}	
			}catch(Exception e){
				model.addAttribute("error", e.getMessage());
				
			}
			return "nativelogon";
		}
	    
		/**
		 *handles the address included in user registration email
		 */
		@RequestMapping(value="nativeregister/regcon/{regid}",method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public String regcon(@PathVariable String regid,HttpServletRequest req,HttpServletResponse resp) throws IOException {

			Regconfirm regc=mailRepository.getRegconfirmById(regid);
			User u=regc.getUser();
			mailRepository.remove(regc);
			u.setEnabled(true);
			userRepository.update(u);
			
			
			Principle userDetails = (Principle) UserDetailService.toUser(u);
			Authentication authentication = new UsernamePasswordAuthenticationToken(
			                userDetails, userDetails.getPassword(), userDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return "redirect:/";
		}
		
		
		
		/**
		 * newbie controller
		 */
		@RequestMapping(value="unnewbie",method = RequestMethod.POST)
		public @ResponseBody String iamnotnewbie(HttpServletResponse resp) throws IOException {
			try{
				userService.no_longer_noob();
				
			}catch(Exception e){
				return e.getMessage();
			}
			return "succ";
		}
		
		
	    @RequestMapping( method=RequestMethod.GET)
	    public String home(Model model) {	 
	    	
	    	if(userService.currentUser().isIsnoob())
	    		//require first time user complete their address
	    		return "newbiehome";
	    	
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
	    @RequestMapping(value="location{loc}", method=RequestMethod.GET)
	    public String searchloc(@PathVariable String loc, Model model) {
	    	model.addAttribute("location",loc);	      
	        return "home";
	    }
	    @RequestMapping(value="likes", method=RequestMethod.GET)
	    public String likes( Model model) {
	    	model.addAttribute("likes",1);	      
	        return "home";
	    }
}
