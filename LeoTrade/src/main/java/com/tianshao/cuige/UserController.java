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

import com.tianshao.cuige.models.Category;
import com.tianshao.cuige.models.Profile;
import com.tianshao.cuige.models.DTO.ProfileDTO;
import com.tianshao.cuige.services.ProfileService;




/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {
	    @Autowired
	    private ProfileService serv;
	   
	    private final Facebook facebook;

	    @Inject
	    public ProfileController(Facebook facebook) {
	        this.facebook = facebook;
	    }

	    @RequestMapping( method=RequestMethod.GET)
	    public String home(Model model) {
	    	
	        return "profile";
	    }

	    
	    
		@RequestMapping(value="api/user",method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public @ResponseBody ProfileDTO get( HttpServletResponse resp) throws IOException {
	    	FacebookProfile facebookprofile=facebook.userOperations().getUserProfile();
	    	
	    	Profile prof=serv.getByProfid(facebookprofile.getId());
		    	if(prof==null){
		    		//TODO solve later, cant just automatically add user and user image
		    		serv.create_Profile(facebookprofile.getId(), 
		    									 facebookprofile.getFirstName(), 
		    									 facebookprofile.getLastName(), 
		    									 facebookprofile.getEmail());
		    	
		    		prof.setImage(facebook.userOperations().getUserProfileImage());
		    		serv.update(prof);
		    	
	    	}
	    	
	    	ProfileDTO profwrap=new ProfileDTO();
	        profwrap.setEmail(facebookprofile.getEmail());
	        profwrap.setFirstname(facebookprofile.getFirstName());
	        profwrap.setLastname(facebookprofile.getLastName());
	        profwrap.setLocation(prof.getLocation());
	        profwrap.setSocial_id(prof.getSocial_id());
	        profwrap.setAboutme(prof.getAboutme());
	        return profwrap;
	    	
	    	
		}
	    
		
		@RequestMapping(value="api/user/{social_id}",method = RequestMethod.PUT,headers="Accept=application/json", produces="application/json")
		public @ResponseBody ProfileDTO update(@RequestBody ProfileDTO wrap,@PathVariable String social_id, HttpServletResponse resp) throws IOException {
			FacebookProfile facebookprofile=facebook.userOperations().getUserProfile();
	    	if(!facebookprofile.getId().equals(social_id)){
	    		//currently logged on user is not claimed user
	            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
	            return null;
	    	}
	    	try{
	    		Profile prof=serv.getByProfid(facebookprofile.getId());
	    		prof.setAboutme(wrap.getAboutme());
	    		prof.setLocation(wrap.getLocation());
	    		serv.update(prof);
	    		return wrap;
	    		
	    	}catch(Exception e){
	            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
	            return null;
	    	}
	    	
		}
		
		@RequestMapping(value="img",method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
		public @ResponseBody byte[] getimg() {
			
			return facebook.userOperations().getUserProfileImage();
			

	    }
		
		@RequestMapping(value="img/socid/{social_id}",method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
		public @ResponseBody byte[] getimg(@PathVariable String social_id) {
			Profile prof=serv.getByProfid(social_id);
			return prof.getImage();
			

	    }	    
	
}
