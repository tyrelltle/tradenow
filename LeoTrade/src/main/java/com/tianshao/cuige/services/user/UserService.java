package com.tianshao.cuige.services.user;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tianshao.cuige.domains.user.IPrinciple;
import com.tianshao.cuige.domains.user.User;
import com.tianshao.cuige.domains.user.UserRole;
import com.tianshao.cuige.domains.user.UserRole.ROLES;
import com.tianshao.cuige.repository.user.IUserRepository;

@Service ("userService")
public class UserService implements IUserService{
	@Autowired
	IUserRepository userRepository;
	@Override
	public User currentUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		IPrinciple u=  (IPrinciple) auth.getPrincipal();
		return u.getUser();
	}

	@Override
	public void addNewRoledUser(User u, ROLES r) {
		u.setEnabled(true);
		if(u.getPassword()!=null && !u.getPassword().equals(""))
		{	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(u.getPassword());
			u.setPassword(hashedPassword);
		}
		
		userRepository.addNew(u);
		
		UserRole role = new UserRole(u,r);
		role.setUser(u);
		userRepository.addNew(role);
		
	}
	
	@Override
	public User loadUserBySocialuid(String userId) {
		return userRepository.getBySocialUid(userId);
	}
}
