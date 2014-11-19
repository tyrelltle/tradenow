package com.tianshao.cuige.repository.user;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import com.tianshao.cuige.domains.IEntity;
import com.tianshao.cuige.domains.product.Product;
import com.tianshao.cuige.domains.user.User;

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
