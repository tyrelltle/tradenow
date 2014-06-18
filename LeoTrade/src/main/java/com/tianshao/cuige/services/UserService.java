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

	@Override
	public void userSocialInitialize() {
		// TODO Auto-generated method stub
		
	}

}
