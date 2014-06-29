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
												  info.toCookieString());
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


	
}
