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

import com.tianshao.cuige.domains.product.Product;
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
		if(!(auth.getPrincipal() instanceof IPrinciple))
			return null;
		IPrinciple u=  (IPrinciple) auth.getPrincipal();
		return u.getUser();
	}

	@Override
	public void addNewRoledUser(User u, ROLES r) {
		/*
		 * new user needs to be enabled by activating with email
		 */
		u.setEnabled(false);
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

	@Override
	public void addFavorite(Product p) throws Exception {
			User u=this.currentUser();
			u=userRepository.getUserWithFavorites(u.getUserid());
			u.addFavorite(p);
			userRepository.update(u);

	}

	@Override
	public void delFavorite(int prod_id) throws Exception {
		User u=this.currentUser();
		u=userRepository.getUserWithFavorites(u.getUserid());
		u.delFavorite(prod_id);
		userRepository.update(u);
	}

	@Override
	public User loadUserWithLikes(){
		User u=this.currentUser();
		return userRepository.getUserWithFavorites(u.getUserid());
	}
}
