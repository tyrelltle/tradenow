package com.tianshao.cuige;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tianshao.cuige.domains.IEntity;

@Repository("repo")
public  class Repo {
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

	@Transactional
	public int truncateTable(String tab){
		Session session = sessionFactory.getCurrentSession();
	    String hql = String.format("delete from %s",tab);
	    Query query = session.createQuery(hql);
	    return query.executeUpdate();
	}

}
