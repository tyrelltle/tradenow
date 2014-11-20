package com.tradenow.services.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.tradenow.domains.user.UserRole;

public class BaseUserDetailService {



	public static List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
	
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
	
		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
	
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
	
		return Result;
	}

}
