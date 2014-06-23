package com.tianshao.cuige.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;
import com.tianshao.cuige.models.User;
import com.tianshao.cuige.models.DTO.ProviderInfo;

public class SimpleSignInAdapter implements SignInAdapter{
	private final UserCookieGenerator userCookieGenerator = new UserCookieGenerator();

	public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
		//rely on logoncontroller to load user
		ConnectionKey key=connection.getKey();
		UserProfile prof= connection.fetchUserProfile();
		User user=new User();
		user.setUserconid(userId);
		SecurityContext.setCurrentUser(user);
		userCookieGenerator.addProviderInfoCookie(new ProviderInfo(-1,
																   userId,
												  				   key.getProviderId(),
												  				   key.getProviderUserId(),
												  				   prof.getEmail(),
												  				   prof.getFirstName(),
												  				   prof.getLastName()),
												  request.getNativeResponse(HttpServletResponse.class));
		return null;
	}
}
