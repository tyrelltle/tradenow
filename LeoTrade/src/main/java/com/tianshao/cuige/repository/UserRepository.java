package com.tianshao.cuige.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tianshao.cuige.models.IEntity;
import com.tianshao.cuige.models.User;

@Repository("userRepository")
public class UserRepository extends BaseRepository implements IUserRepository{

	
	@Transactional
	public User getByUserid(int userid){
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from User where userid="+userid);
		
		return (User) query.uniqueResult();
	}


}
