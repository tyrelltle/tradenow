package com.tianshao.cuige.config;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.util.CookieGenerator;

public class UserCookieGenerator {


		private final CookieGenerator userIdCookieGenerator = new CookieGenerator();
		private final CookieGenerator providerinfoCookieGenerator = new CookieGenerator();

		public UserCookieGenerator() {
			userIdCookieGenerator.setCookieName("quickstart_user");
			providerinfoCookieGenerator.setCookieName("providerinfo");
		}

		public void addUserIdCookie(String userId, HttpServletResponse response) {
			userIdCookieGenerator.addCookie(response, userId);
		}

		public void addProviderInfoCookie(ProviderInfo info,HttpServletResponse response) {
			providerinfoCookieGenerator.addCookie(response, 
												  info.userconid+"-"+info.providerid+"-"+info.provideruserid+"-"+info.justloggedin);
		}

		
		public void removeCookie(HttpServletResponse response) {
			userIdCookieGenerator.addCookie(response, "");
			providerinfoCookieGenerator.addCookie(response, "");

		}

		public String readUserIdCookieValue(HttpServletRequest request) {
			Cookie[] cookies = request.getCookies();
			if (cookies == null) {
				return null;
			}
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(userIdCookieGenerator.getCookieName())) {
					return cookie.getValue();
				}
			}
			return null;
		}
		
		public ProviderInfo readProviderInfoCookieValue(HttpServletRequest request) throws Exception {
			Cookie[] cookies = request.getCookies();
			if (cookies == null) {
				return null;
			}
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(providerinfoCookieGenerator.getCookieName())) {
					String ret=cookie.getValue();
					if(ret==null||ret=="")
						return null;
					return new ProviderInfo(ret);
				}
			}
			return null;
		}

		public static class ProviderInfo{
			public String justloggedin;
			public String userconid;
			public String providerid;
			public String provideruserid;
			
			public ProviderInfo(String uid, String provid, String provuid,String justin){
				userconid=uid;
				providerid=provid;
				provideruserid=provuid;
				justloggedin=justin;
			}
			public ProviderInfo(String input) throws Exception{
				String[] lis=input.split("-");
				if(lis==null || lis.length!=4)
					throw new Exception("wrongly formatted providerinfo from cookie");
				userconid=lis[0];
				providerid=lis[1];
				provideruserid=lis[2];
				justloggedin=lis[3];
			}
		}
	
}
