package com.tradenow.repository.user;

import java.util.List;

import com.tradenow.domains.IEntity;
import com.tradenow.domains.user.User;

public interface IUserRepository{

	public void addNew(IEntity user);

	public User getByUserid(int userid);

	public void update(IEntity user);

	public void remove(IEntity prof);

	public User getByEmail(String email);
	
	public User getBySocialUid(String socialuid);

	User getByEmailPassword(String email, String password);

	int getUserNextId();

	List<User> getByProvIdProvUserId(String providerid, String provideruserid);

	public User loadUserBySocialuid(String userId) ;
	

	public User getUserWithProducts(int userid);
	public User getUserWithFavorites(int userid);
}
