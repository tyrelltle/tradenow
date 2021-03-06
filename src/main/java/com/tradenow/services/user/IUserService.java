package com.tradenow.services.user;

import com.tradenow.domains.product.Product;
import com.tradenow.domains.user.User;
import com.tradenow.domains.user.UserRole;

public interface IUserService {

	void addNewRoledUser(User u,  UserRole.ROLES r);
	User currentUser();
	User loadUserBySocialuid(String userId);
	User loadUserWithLikes();
	void addFavorite(Product p) throws Exception;
	void delFavorite(int prod_id) throws Exception;
	/*
	 * set current user's isnoon to false
	 */
	void no_longer_noob();
}
