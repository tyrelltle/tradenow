package com.tianshao.cuige.config;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.social.connect.NotConnectedException;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.RedirectView;

import com.tianshao.cuige.models.User;
import com.tianshao.cuige.models.DTO.ProviderInfo;
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
				request.getRequestURI().contains("signin") ||	
//				request.getRequestURI().contains("signout") ||
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

	
	/*
	 * reload securitycontext.user.  
	 * user always has userid= user table's id, not userconnection id
	 * When user logon to repository, userid cookie always there
	 * when user logon to facebook etc, provinfo cookie is added but not userid.  
	 * 
	 * */
	private void rememberUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ProviderInfo provinfo = userCookieGenerator.readProviderInfoCookieValue(request);
		String userid = userCookieGenerator.readUserIdCookieValue(request);
		User newcuruser = new User();
		if((provinfo==null || provinfo.equals("")) && (userid==null  || userid.equals("")))
			return;
		if (provinfo!=null && userNotFound(provinfo.userconid)) {
			userCookieGenerator.removeCookie(response);
			return;
		}
		
		
		if (provinfo == null) {
			//user signedin as repository
			newcuruser.setUserid(Integer.valueOf(userid));
			
		}else if(provinfo != null) {
			//user signedin as social
			if(provinfo.justloggedin.equals("1")||userid==null||userid.equals("")){
				//user just logged on, check if need to persist it
				User u=null;
				List<User> ulis = (userRepository.getByProvIdProvUserId(provinfo.providerid, provinfo.provideruserid));
				if(ulis==null||ulis.size()==0){
					//user first time signedin as social user
					u=new User(provinfo);
					userRepository.addNew(u);
					userid=String.valueOf(u.getUserid());
					
					userCookieGenerator.addUserIdCookie(userid, response);
					ulis = (userRepository.getByProvIdProvUserId(provinfo.providerid, provinfo.provideruserid));
				}//if(ulis==null||ulis.size()==0)
				provinfo.justloggedin="0";
				userCookieGenerator.addProviderInfoCookie(provinfo, response);
				userid=String.valueOf(ulis.get(0).getUserid());
			}//if(provinfo.justloggedin=="1")

			newcuruser.setUserid(Integer.valueOf(userid));
			newcuruser.setUserconid(provinfo.userconid);
			newcuruser.setProviderid(provinfo.providerid);
		}//else if(provinfo != null)
		SecurityContext.setCurrentUser(newcuruser);

		
	}

	private void handleSignOut(HttpServletRequest request, HttpServletResponse response) {
		if (SecurityContext.userSignedIn() && request.getServletPath().startsWith("/signout")) {
			try{
				ProviderInfo provinfo = userCookieGenerator.readProviderInfoCookieValue(request);
				if(provinfo!=null)
					connectionRepository.createConnectionRepository(provinfo.userconid).removeConnections("facebook");
			}catch(NotConnectedException e){} catch (Exception e) {
				e.printStackTrace();
			}
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
		boolean infacebook= connectionRepository.createConnectionRepository(userId).findPrimaryConnection(Facebook.class) == null;
		return infacebook;
	}
	
}
