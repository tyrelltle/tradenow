package com.tianshao.cuige.repository;

import java.util.List;

import com.tianshao.cuige.models.IEntity;
import com.tianshao.cuige.models.User;

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
