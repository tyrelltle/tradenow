package com.tianshao.cuige.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tianshao.cuige.domains.IEntity;
import com.tianshao.cuige.domains.user.User;

@Repository("userRepository")
public class UserRepository extends BaseRepository implements IUserRepository{

	
	@Override
	@Transactional
	public User getByUserid(int userid){
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from User where userid="+userid);
		
		return (User) query.uniqueResult();
	}


	@Override
	@Transactional
	public List<User> getByEmail(String email){
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from User where email='"+email+"'");
		
		return query.list();
	}
	
	@Override
	@Transactional
	public User getByEmailPassword(String email,String password){
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from User where email='"+email+"' and password='"+password+"'");
		
		return (User) query.uniqueResult();
	}
	
	/*
	 * when facebook signin, the provider controller will ask for an id to create a record in userconnection table
	 * the user id in userconnection table must be the same in user table!
	 * */
	@Override
	@Transactional
	public int getUserNextId(){
		Session seesion = sessionFactory.getCurrentSession();
		Query query=seesion.createQuery("select max(userid) from User");
		return (Integer) query.uniqueResult();
	}
	
	
	/**
	 * first time social user?
	 * @return
	 */
	@Override
	@Transactional
	public List<User> getByProvIdProvUserId(String providerid, String provideruserid){
		Session seesion = sessionFactory.getCurrentSession();
		Query query=seesion.createQuery("from User where providerid='"+providerid+"' and provideruserid='"+provideruserid+"'");
		return query.list();
	}

}
