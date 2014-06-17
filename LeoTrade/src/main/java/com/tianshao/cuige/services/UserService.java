package com.tianshao.cuige.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.stereotype.Service;

import com.tianshao.cuige.config.SecurityContext;
import com.tianshao.cuige.models.Category;
import com.tianshao.cuige.models.User;
import com.tianshao.cuige.repository.IUserRepository;
import com.tianshao.cuige.repository.UserRepository;

@Service("userService")
public class UserService implements IUserService{
	@Autowired
	IUserRepository userRepository;
	
	@Autowired 
	Facebook facebook;
	

	/**
	 * when xxx.execute->userid.increase: its ok, leave it there when go to signinadapter, 
	 * create new user (just class instance not db) with empty userid but userconnection->userid, 
	 * provid and provuserid 
	 * 
	 * in home, if current user's uconid,provid and provuserid != null and 
	 * provid and provuserid pair can not be found in user table,  create it! AND set email and 
	 * something.    else if provid and provuserid can be found in table, load it and get to 
	 * securitycontext when userInterceptor try to load facebook connection using userid, dont,  
	 * just use user table's userconid! AS well as when loading cookie!
	 */
	@Override
	public void userSocialInitialize(){
		 
 	   FacebookProfile prof=facebook.userOperations().getUserProfile();
		User user=SecurityContext.getCurrentUser();
	       List<User> queryuserlis = userRepository.getByProvIdProvUserId(user.getProviderid(), 
						 user.getProvideruserid());
	       
	       if(user.signedinAsFacebookUser() && (queryuserlis==null || queryuserlis.size()==0)){
	    	   //facebook user
	    	   //create new user, and set email, first/last name and so on from Facebook connection
	    	   user.setFirstname(prof.getFirstName());
	    	   user.setLastname(prof.getLastName());
	    	   user.setAboutme(prof.getAbout());
	    	   user.setLocation(prof.getLocation().getName());
	    	   userRepository.addNew(user);
	    	   SecurityContext.setCurrentUser(user);
	       }else if(!user.signedinAsFacebookUser() && queryuserlis.size()>0){
	    	   SecurityContext.setCurrentUser(queryuserlis.get(0));
	       }
		
	}
}
