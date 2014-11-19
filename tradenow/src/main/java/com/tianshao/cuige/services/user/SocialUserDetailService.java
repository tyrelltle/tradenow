package com.tianshao.cuige.services.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tianshao.cuige.config.SocialContext;
import com.tianshao.cuige.domains.user.IPrinciple;
import com.tianshao.cuige.domains.user.SocialPrinciple;
import com.tianshao.cuige.domains.user.User;
import com.tianshao.cuige.domains.user.UserRole;
import com.tianshao.cuige.repository.user.IUserRepository;
import com.tianshao.cuige.shared.googlegeo.AddressConverter;
import com.tianshao.cuige.shared.googlegeo.GoogleResponse;
import com.tianshao.cuige.shared.googlegeo.Location;
@Component ("socialUserDetailsService")
public class SocialUserDetailService extends BaseUserDetailService implements SocialUserDetailsService{
	@Autowired
	private SessionFactory sessionFactory;	
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private SocialContext socialContext;
	@Autowired
	private IUserService userService;
	public SocialUserDetailService(){}
	
	public SocialUserDetailService(UserDetailsService userDetailsService) {
		super();
		this.userDetailsService = userDetailsService;
	}

	@Override
	public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException, DataAccessException {
		boolean success=true;
		User u = null;
		try{
			 u = userService.loadUserBySocialuid(userId);
		}catch(Exception e){
			success=false;
		}
		if(u == null || success==false)
		{
			Facebook api=socialContext.facebook(userId);
			u=User.newFacebookUser(api);
			AddressConverter a=new AddressConverter();
			try{
				if(u.getLocation()!=null && !u.getLocation().equals("")){
					GoogleResponse gres=a.convertToLatLong(u.getLocation());
					Location loc=gres.getResults()[0].getGeometry().getLocation();
					u.setLatitude(Double.valueOf(loc.getLat()));
					u.setLongitude(Double.valueOf(loc.getLng()));
				}
				u.setSocialuid(userId);
				userService.addNewRoledUser(u, UserRole.ROLES.ROLE_USER);
				
			}catch(Exception e){
				return null;
			}
		}
		Set<UserRole> roles=new HashSet<UserRole>();
		roles.add(new UserRole(UserRole.ROLES.ROLE_USER));
		return (SocialUserDetails) buildUserForAuthentication(u, buildUserAuthority(roles));
	}

	

	public SocialPrinciple buildUserForAuthentication(com.tianshao.cuige.domains.user.User user, List<GrantedAuthority> authorities) {
		
		
		SocialPrinciple p = new SocialPrinciple (user, true, true, true, authorities);
		
		return p;
	}
	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

}
