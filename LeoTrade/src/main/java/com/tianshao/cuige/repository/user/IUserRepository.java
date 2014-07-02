package com.tianshao.cuige.repository.user;

import java.util.List;

import com.tianshao.cuige.domains.IEntity;
import com.tianshao.cuige.domains.user.User;

public interface IUserRepository{

	public void addNew(IEntity user);

	public User getByUserid(int userid);

	public void update(IEntity user);

	public void remove(IEntity prof);

	public List<User> getByEmail(String email);

	User getByEmailPassword(String email, String password);

	int getUserNextId();

	List<User> getByProvIdProvUserId(String providerid, String provideruserid);


}
