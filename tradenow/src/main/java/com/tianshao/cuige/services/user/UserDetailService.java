package com.tianshao.cuige.services.user;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tianshao.cuige.domains.user.Principle;
import com.tianshao.cuige.domains.user.SocialPrinciple;
import com.tianshao.cuige.repository.user.IUserRepository;
@Component ("userDetailsService")
public class UserDetailService extends BaseUserDetailService implements UserDetailsService {
	@Autowired
	private SessionFactory sessionFactory;	
	
	public UserDetailService(){}
	@Override
	@Transactional
	public UserDetails loadUserByUsername(final String email) 
		throws UsernameNotFoundException {
		com.tianshao.cuige.domains.user.User u;
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from User where enabled=true and email='"+email+"'");
		try{
		u=(com.tianshao.cuige.domains.user.User) query.uniqueResult();	
		}catch(Exception e){
			throw new UsernameNotFoundException(e.getMessage());
		}
		if(u==null)
			throw new UsernameNotFoundException("user email "+email+" not found");
		List<GrantedAuthority> authorities = 
                                      buildUserAuthority(u.getUserRoles());
 
		return buildUserForAuthentication(u, authorities);
 
	}
	public static User toUser(com.tianshao.cuige.domains.user.User user){
		List<GrantedAuthority> authorities = 
                buildUserAuthority(user.getUserRoles());
		return buildUserForAuthentication(user, authorities);
		
	}
	public static User buildUserForAuthentication(com.tianshao.cuige.domains.user.User user, List<GrantedAuthority> authorities) {
		
		
		User p = new Principle (user, true, true, true, authorities);
		
		return p;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
}
