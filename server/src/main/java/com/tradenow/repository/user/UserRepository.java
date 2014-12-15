package com.tradenow.repository.user;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tradenow.domains.user.User;
import com.tradenow.repository.BaseRepository;

@Repository("userRepository")
public class UserRepository extends BaseRepository implements IUserRepository{

	@Override
	@Transactional
	public User loadUserBySocialuid(String userId) {
		com.tradenow.domains.user.User u;
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from User where socialuid='"+userId+"'");
		return (User) query.uniqueResult();
	}
	@Override
	@Transactional
	public User getByUserid(int userid){
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from User where userid="+userid);
		
		return (User) query.uniqueResult();
	}
	
	@Override
	@Transactional
	public User getBySocialUid(String socialuid) {
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from User where socialuid='"+socialuid+"'");
		List<User> lis=query.list();
		if(lis.size()==0)
			return null;
		return lis.get(0);
	}

	@Override
	@Transactional
	public User getByEmail(String email){
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from User where email='"+email+"'");
		List<User> lis=query.list();
		if(lis.size()==0)
			return null;
		return lis.get(0);
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
	@Override
	@Transactional	
	public User getUserWithProducts(int userid){
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from User where userid = "+userid);
		User u=(User) query.uniqueResult();
		Hibernate.initialize(u.getProducts());
		return u;
	}
	@Override
	@Transactional	
	public User getUserWithFavorites(int userid) {
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from User where userid = "+userid);
		User u=(User) query.uniqueResult();
		Hibernate.initialize(u.getFavorites());
		return u;
	}




}
