package com.tianshao.cuige.config;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tianshao.cuige.domains.user.User;

public class SecurityContext {
	private static final ThreadLocal<User> currentUser = new ThreadLocal<User>();

	public static User getCurrentUser() {
		User user = (User) session().getAttribute("user");
		if (user == null) {
			throw new IllegalStateException("No user is currently signed in");
		}
		return user;
	}

	public static void setCurrentUser(User user) {
		session().setAttribute("user", user);
	}

	public static boolean userSignedIn() {
		return session().getAttribute("user")!=null;
	}

	public static void remove() {
	    session().removeAttribute("user");
	}
	
	public static HttpSession session() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession(true); // true == allow create
	}
}
