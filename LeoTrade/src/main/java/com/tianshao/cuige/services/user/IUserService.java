package com.tianshao.cuige.services.user;

import com.tianshao.cuige.domains.user.User;
import com.tianshao.cuige.domains.user.UserRole;

public interface IUserService {

	void addNewRoledUser(User u,  UserRole.ROLES r);
	User currentUser();
	User loadUserBySocialuid(String userId);
	
}
