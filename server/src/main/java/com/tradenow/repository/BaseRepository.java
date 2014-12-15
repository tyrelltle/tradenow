package com.tradenow.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.tradenow.domains.IEntity;


public abstract class BaseRepository {
	@Autowired
	protected SessionFactory sessionFactory;
	
	@Transactional
	public void addNew(IEntity obj){
		sessionFactory.getCurrentSession().save(obj);
	}
	
	
	@Transactional
	public void remove(IEntity obj){
		
	    sessionFactory.getCurrentSession().delete(obj);
	}
	

	@Transactional
	public void update(IEntity obj){
		if(obj != null)
		sessionFactory.getCurrentSession().update(obj);
	}
}
