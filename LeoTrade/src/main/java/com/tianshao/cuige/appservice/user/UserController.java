   package com.tianshao.cuige.appservice.user;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tianshao.cuige.domains.product.Image;
import com.tianshao.cuige.domains.product.Product;
import com.tianshao.cuige.domains.user.User;
import com.tianshao.cuige.domains.user.UserDTO;
import com.tianshao.cuige.repository.user.IUserRepository;
import com.tianshao.cuige.services.user.IUserService;
import com.tianshao.cuige.shared.Util;




/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/user")
public class UserController {
	    @Autowired
	    private IUserRepository userRepository;
	    
	    private @Autowired ServletContext servletContext;
	    
	    @Autowired
	    private IUserService userService;
	    
	    final String defaultimgurl="defaultusericon.png";//"http://img.teapic.com/thumbs/201207/27/124104mawrcsfomsejkmvl.jpg.middle.jpg";
	    @RequestMapping( method=RequestMethod.GET)
	    public String home(Model model) {
			

	        return "profile";
	    }

	    

		
		@RequestMapping(value="api/user/{userid}",method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public @ResponseBody UserDTO get( @PathVariable int userid,HttpServletResponse resp) throws IOException {
	    	User user=userService.currentUser();
	    	user= userRepository.getByUserid(user.getUserid());
//	    	if(user.isSocialUserAndNeedImage()){
//	    		user.setImage(facebook.userOperations().getUserProfileImage());
//	    		userRepository.update(user);
//	    	}
	   
	    	return User.toUserDTO(user);
	    	
	    	
	    	
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
	    		user.updateFromDTO(wrap);
	    	
	    		userRepository.update(user);
	    		return wrap;
	    		
	    	}catch(Exception e){
	            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
	            return null;
	    	}
	    	
		} 
		
		@RequestMapping(value="img",method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
		public @ResponseBody byte[] getimg(HttpServletRequest req) throws IOException {
			
			byte[] ret= userService.currentUser().getImage();
			if(ret==null){
				InputStream in=servletContext.getResourceAsStream("/resources/img/"+defaultimgurl);				
				ret=IOUtils.toByteArray(in);
				
			}
			return ret;

		}
		
		@RequestMapping(value="img/userid/{userid}",method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
		public @ResponseBody byte[] getimgbyuid(@PathVariable int userid,HttpServletRequest req) throws IOException {
			byte[] ret= userRepository.getByUserid(userid).getImage();
			if(ret==null){
				InputStream in=servletContext.getResourceAsStream("/resources/img/"+defaultimgurl);				
				ret=IOUtils.toByteArray(in);			
			}
			return ret;

	    }	    
		 @RequestMapping(value = "/img/upload", method = RequestMethod.POST)
		   public @ResponseBody String upload(MultipartHttpServletRequest request, HttpServletResponse resp) throws IOException {                 
			
			 User user=userService.currentUser();
	    	
			 
		     //0. notice, we have used MultipartHttpServletRequest
		 
		     //1. get the files from the request object
		     Iterator<String> itr =  request.getFileNames();
		 
		     MultipartFile mpf = request.getFile(itr.next());
		     user.setImage(mpf.getBytes());
		     userRepository.update(user);
		 
		     return "success";
		 
		  }
}
