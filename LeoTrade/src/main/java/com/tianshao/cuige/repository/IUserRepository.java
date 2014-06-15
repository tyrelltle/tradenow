package com.tianshao.cuige.repository;

import com.tianshao.cuige.models.IEntity;
import com.tianshao.cuige.models.User;

public interface IUserRepository{

	void addNew(IEntity user);

	User getByUserid(int userid);

	void update(IEntity user);

	void remove(IEntity prof);

}
