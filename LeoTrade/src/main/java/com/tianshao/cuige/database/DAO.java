package com.tianshao.cuige.database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("dao")
//@Transactional
public class DAO {
	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	public void addNew(Object obj){
		sessionFactory.getCurrentSession().save(obj);
	}
	
	@Transactional
	public void remove(Class c,int id){
		Object obj=sessionFactory.getCurrentSession().load(c, id);
		if(obj!=null)
			sessionFactory.getCurrentSession().delete(obj);
	}
	
	@Transactional
	public void remove(Object obj){
		
	    sessionFactory.getCurrentSession().delete(obj);
	}
	
	/**
	 * 
	 * @param tablenm  name of the class of the entity, ex, Product
	 * @return
	 */
	@Transactional
	public List<? extends Object> list(String tablenm){
		return sessionFactory.getCurrentSession()
				.createQuery("from "+tablenm).list();
	}
	@Transactional
	public void update(Object obj){
		if(obj != null)
		sessionFactory.getCurrentSession().update(obj);
	}

	
	@Transactional
	public Object getByColumn(String tablenm,String columnnm, String columnval){
		Session session = sessionFactory.getCurrentSession();
		List<Object> list = session.createQuery("from "+tablenm+" b where b."+columnnm+" = :"+columnnm)
			.setParameter(columnnm, columnval)
			.list();
		if(list==null || list.size()==0)
			return null;
		return list.get(0);
	}
	
	@Transactional
	public List<? extends Object> getListByColumn(String tablenm,String columnnm, String columnval){
		Session session = sessionFactory.getCurrentSession();
		List<Object> list = session.createQuery("from "+tablenm+" b where b."+columnnm+" = :"+columnnm)
			.setParameter(columnnm, columnval)
			.list();
		return list;
	}

	@Transactional
	public List<? extends Object> getByColumnByFoeignKey(String tablenm,String tablenm2, String columnnm, int columnval){
		Session session = sessionFactory.getCurrentSession();
		List<Object> list = session.createQuery("from "+tablenm+" b where b."+tablenm2+"."+columnnm+" = :"+columnnm)
			.setParameter(columnnm, columnval)
			.list();
		return list;
	}
}
