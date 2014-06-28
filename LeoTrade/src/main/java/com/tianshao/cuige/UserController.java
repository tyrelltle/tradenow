package com.tianshao.cuige;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import com.tianshao.cuige.config.SecurityContext;
import com.tianshao.cuige.models.Category;
import com.tianshao.cuige.models.User;
import com.tianshao.cuige.models.User;
import com.tianshao.cuige.models.DTO.UserDTO;
import com.tianshao.cuige.repository.IUserRepository;
import com.tianshao.cuige.services.IUserService;
import com.tianshao.cuige.shared.Util;




/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/user")
public class UserController {
	    @Autowired
	    private IUserRepository userRepository;
	    @Autowired
	    Facebook facebook;
	    @Autowired
	    private IUserService userService;
	    
	    final String defaultimgurl="http://img.teapic.com/thumbs/201207/27/124104mawrcsfomsejkmvl.jpg.middle.jpg";
	    @RequestMapping( method=RequestMethod.GET)
	    public String home(Model model) {
			

	        return "profile";
	    }

	    

		
		@RequestMapping(value="api/user/{userid}",method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public @ResponseBody UserDTO get( @PathVariable int userid,HttpServletResponse resp) throws IOException {
	    	User user=userService.currentUser();
	    	user= userRepository.getByUserid(user.getUserid());
	    	if(user.isSocialUserAndNeedImage()){
	    		user.setImage(facebook.userOperations().getUserProfileImage());
	    		userRepository.update(user);
	    	}
	   
		   
	    	UserDTO profwrap=new UserDTO();
	        profwrap.setEmail(user.getEmail());
	        profwrap.setFirstname(user.getFirstname());
	        profwrap.setLastname(user.getLastname());
	        profwrap.setLocation(user.getLocation());
	        profwrap.setUserid(user.getUserid());
	        profwrap.setAboutme(user.getAboutme());
	        return profwrap;
	    	
	    	
		}
	    
		
		@RequestMapping(value="api/user/{userid}",method = RequestMethod.PUT,headers="Accept=application/json", produces="application/json")
		public @ResponseBody UserDTO update(@RequestBody UserDTO wrap,@PathVariable int userid, HttpServletResponse resp) throws IOException {
			User user=userService.currentUser();
			if(user.getUserid()!=(userid)){
	    		//currently logged on user is not claimed user
	            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
	            return null;
	    	}
	    	try{
	    		
	    		user.setAboutme(wrap.getAboutme());
	    		user.setLocation(wrap.getLocation());
	    		userRepository.update(user);
	    		return wrap;
	    		
	    	}catch(Exception e){
	            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
	            return null;
	    	}
	    	
		} 
		
		@RequestMapping(value="img",method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
		public @ResponseBody byte[] getimg() throws IOException {
			
			byte[] ret= userService.currentUser().getImage();
			if(ret==null)
				ret=Util.getimageByUrl(defaultimgurl);
			return ret;

		}
		
		@RequestMapping(value="img/userid/{userid}",method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
		public @ResponseBody byte[] getimgbyuid(@PathVariable int userid,HttpServletResponse resp) throws IOException {
			byte[] ret= userRepository.getByUserid(userid).getImage();
			if(ret==null)
				ret=Util.getimageByUrl(defaultimgurl);
			return ret;

	    }	    
	
}
