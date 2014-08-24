package com.tianshao.cuige.repository.mail;

import com.tianshao.cuige.domains.IEntity;
import com.tianshao.cuige.domains.mail.Regconfirm;
import com.tianshao.cuige.domains.user.User;

public interface IMailRepository {
	Regconfirm newRegconfirm_gen(User user);
	Regconfirm getRegconfirmById(String id);
	void remove(IEntity obj);
}
