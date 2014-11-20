package com.tradenow.domains.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class Principle  extends org.springframework.security.core.userdetails.User implements IPrinciple{
	public  User user;

	public Principle(User u,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(u.getEmail(), u.getPassword(), u.isEnabled(), accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		this.user=u;
	}

	public Principle(String email, String password, boolean enabled, boolean b,
			boolean c, boolean d, List<GrantedAuthority> authorities) {
		super(email, password, enabled, b, c,
				d, authorities);
	}

	@Override
	public void setUser(User user){
		this.user=user;
	}
	
	@Override
	public User getUser(){
		return this.user;
	}
}
