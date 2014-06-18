package com.tianshao.cuige.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

import com.tianshao.cuige.config.UserCookieGenerator.ProviderInfo;
import com.tianshao.cuige.models.User;

public class SimpleSignInAdapter implements SignInAdapter{
	private final UserCookieGenerator userCookieGenerator = new UserCookieGenerator();

	public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
		//rely on logoncontroller to load user
		User user=new User();
		user.setUserconid(userId);
		SecurityContext.setCurrentUser(user);
		userCookieGenerator.addProviderInfoCookie(new ProviderInfo(userId,
												  				   connection.getKey().getProviderId(),
												  				   connection.getKey().getProviderUserId(),
												  				   "1"),
												  request.getNativeResponse(HttpServletResponse.class));
		return null;
	}
}
