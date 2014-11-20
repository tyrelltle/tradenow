package com.tradenow.repository.mail;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tradenow.domains.mail.Regconfirm;
import com.tradenow.domains.user.User;
import com.tradenow.repository.BaseRepository;

@Repository("mailRepository")
public class MailRepository extends BaseRepository implements IMailRepository{

	@Override
	@Transactional
	public Regconfirm newRegconfirm_gen(User u) {
		Regconfirm rc=new Regconfirm();
		rc.setUser(u);
		rc.setUser(u);
		addNew(rc);
		return rc;
	}

	@Override
	@Transactional
	public Regconfirm getRegconfirmById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Regconfirm where id = '"+ id+"'");
		Regconfirm ret=(Regconfirm) query.uniqueResult();
		Hibernate.initialize(ret.getUser().getUserRoles());
		return ret;
	}

}
