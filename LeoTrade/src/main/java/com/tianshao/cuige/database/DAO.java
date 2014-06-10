package com.tianshao.cuige.database;

import java.util.List;

import org.hibernate.Query;
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
	public Object getByColumn(String tablenm,String columnnm, int columnval){
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
	public List<? extends Object> getListByColumn(String tablenm,String columnnm, int columnval){
		Session session = sessionFactory.getCurrentSession();
		List<Object> list = session.createQuery("from "+tablenm+" b where b."+columnnm+" = :"+columnnm)
			.setParameter(columnnm, columnval)
			.list();
		return list;
	}

	
	@Transactional
	public List<? extends Object> getByFoeignColumn(String tablenm,String tablenm2, String columnnm, String columnval){
		Session session = sessionFactory.getCurrentSession();
		List<Object> list = session.createQuery("from "+tablenm+" b where b."+tablenm2+"."+columnnm+" = :"+columnnm)
			.setParameter(columnnm, columnval)
			.list();
		return list;
	}
	
	@Transactional
	public List<? extends Object> getByFoeignColumn(String tablenm,String tablenm2, String columnnm, int columnval){
		Session session = sessionFactory.getCurrentSession();
		List<Object> list = session.createQuery("from "+tablenm+" b where b."+tablenm2+"."+columnnm+" = :"+columnnm)
			.setParameter(columnnm, columnval)
			.list();
		return list;	}
	

	@Transactional
	public Object directSql(String sql){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(sql).uniqueResult();			
	}
	
	
	@Transactional
	public List<? extends Object> directSqltoList(String sql){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(sql).list();			
	}
	
	
	
	
	@Transactional
	public List<? extends Object> getAll(String tablenm){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from "+tablenm).list();			
	}
	
	/**
	 * 
	 * @param tablenm  
	 * tablename
	 * @param limitL  
	 * first value used in LIMIT x,x
	 * @param limitR
	 * second value used in LIMIT x,x
	 * @return
	 */
	@Transactional
	public List<? extends Object> getAll(String tablenm, int limitL,int limitR){
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from "+tablenm);	
		query.setFirstResult(limitL);
		query.setMaxResults(limitR);
		return query.list();
	}
	@Transactional

	public int truncateTable(String tab){
		Session session = sessionFactory.getCurrentSession();
	    String hql = String.format("delete from %s",tab);
	    Query query = session.createQuery(hql);
	    return query.executeUpdate();
	}
}
