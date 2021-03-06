package com.tradenow.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tradenow.domains.product.Product;
import com.tradenow.domains.user.IPrinciple;
import com.tradenow.domains.user.User;
import com.tradenow.domains.user.UserRole;
import com.tradenow.domains.user.UserRole.ROLES;
import com.tradenow.repository.user.IUserRepository;

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

		if(u.getPassword()!=null && !u.getPassword().equals(""))
		{	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(u.getPassword());
			u.setPassword(hashedPassword);
		}
		u.setIsnoob(true);
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

	@Override
	public void no_longer_noob() {
		User u = this.currentUser();
		u.setIsnoob(false);
		userRepository.update(u);
		
	}
}
