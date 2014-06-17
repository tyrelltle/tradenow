package com.tianshao.cuige.config;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.social.connect.NotConnectedException;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.RedirectView;

import com.tianshao.cuige.models.User;
import com.tianshao.cuige.repository.IUserRepository;
import com.tianshao.cuige.services.IUserService;

public final class UserInterceptor extends HandlerInterceptorAdapter {

	@Inject
	IUserRepository userRepository=null;
	
	@Inject 
	Facebook facebook=null;
	private final UsersConnectionRepository connectionRepository;
	
	private final UserCookieGenerator userCookieGenerator = new UserCookieGenerator();

	public UserInterceptor(UsersConnectionRepository connectionRepository) {
		this.connectionRepository = connectionRepository;
	}
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(request.getRequestURI().contains("resources/") || 
		   request.getRequestURI().contains("nativelogon")||
		   request.getRequestURI().contains("nativesignin")||
		   request.getRequestURI().contains("nativeregister"))
			return true;
		rememberUser(request, response);
		handleSignOut(request, response);			
		if (SecurityContext.userSignedIn() || requestForSignIn(request)) {
			return true;
		} else {
			return requireSignIn(request, response);
		}
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		SecurityContext.remove();
	}

	// internal helpers

	private void rememberUser(HttpServletRequest request, HttpServletResponse response) {
		String userId = userCookieGenerator.readCookieValue(request);
		if (userId == null) {
			return;
		}
		if (!userNotFound(userId)) {
			userCookieGenerator.removeCookie(response);
			return;
		}
		SecurityContext.setCurrentUser(new User(Integer.valueOf(userId)));
	}

	private void handleSignOut(HttpServletRequest request, HttpServletResponse response) {
		if (SecurityContext.userSignedIn() && request.getServletPath().startsWith("/signout")) {
			try{
				connectionRepository.createConnectionRepository(String.valueOf(SecurityContext.getCurrentUser().getUserid())).removeConnections("facebook");
			}catch(NotConnectedException e){}
			userCookieGenerator.removeCookie(response);
			SecurityContext.remove();			
		}
	}
		
	private boolean requestForSignIn(HttpServletRequest request) {
		return request.getServletPath().startsWith("/signin");
	}
	
	private boolean requireSignIn(HttpServletRequest request, HttpServletResponse response) throws Exception {
		new RedirectView("/signin", true).render(null, request, response);

		return false;
	}

	private boolean userNotFound(String userId) {
		// doesn't bother checking a local user database: simply checks if the userId is connected to Facebook
		boolean infacebook= connectionRepository.createConnectionRepository(userId).findPrimaryConnection(Facebook.class) != null;
		if(userId=="")
			return infacebook;
		boolean innative=userRepository.getByUserid(Integer.valueOf(userId))!=null;
		return infacebook || innative;
	}
	
}
