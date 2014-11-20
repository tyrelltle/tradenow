package com.tradenow.repository.mail;

import com.tradenow.domains.IEntity;
import com.tradenow.domains.mail.Regconfirm;
import com.tradenow.domains.user.User;

public interface IMailRepository {
	Regconfirm newRegconfirm_gen(User user);
	Regconfirm getRegconfirmById(String id);
	void remove(IEntity obj);
}
