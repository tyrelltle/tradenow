package com.tianshao.cuige.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianshao.cuige.config.SecurityContext;
import com.tianshao.cuige.domains.user.User;
import com.tianshao.cuige.repository.user.IUserRepository;

@Service("userService")
public class UserService implements IUserService{
	@Autowired
	IUserRepository userRepository;
	public User currentUser(){
		User user=userRepository.getByUserid(SecurityContext.getCurrentUser().getUserid());
		return user;
		
	}
	
}
