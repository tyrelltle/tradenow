package com.tradenow.domains.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.social.security.SocialUserDetails;

public class SocialPrinciple extends Principle implements IPrinciple, SocialUserDetails{
	public SocialPrinciple(User u,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(u, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		this.user=u;
	}

	public SocialPrinciple(String email, String password, boolean enabled, boolean b,
			boolean c, boolean d, List<GrantedAuthority> authorities) {
		super(email, password, enabled, b, c,
				d, authorities);
	}

	public  User user;

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void setUser(User user) {
		this.user=user;
	}

	@Override
	public String getUserId() {
		return user.getSocialuid();
	}

}
