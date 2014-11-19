package com.tianshao.cuige.domains.user;

import org.springframework.security.core.userdetails.UserDetails;

public interface IPrinciple extends UserDetails{
	public static enum PRINCIPLE_TYPE{
		STANDARD,
		SOCIAL
	}
	public abstract User getUser();

	public abstract void setUser(User user);


}
