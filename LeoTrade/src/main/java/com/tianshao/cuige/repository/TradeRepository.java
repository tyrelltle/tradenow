package com.tianshao.cuige.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tianshao.cuige.models.Trade;


@Repository("tradeRepository")

public class TradeRepository extends BaseRepository implements ITradeRepository{

	/**
	 * 
	 * check if two prod already have trade record
	 */
	@Override
	@Transactional
	public boolean pairexist(int prod1_id,int prod2_id){
		String str="Select count(*) from Trade t where ( t.prod1.prod_id= %d and t.prod2.prod_id=%d) or ( t.prod1.prod_id= %d and t.prod2.prod_id=%d)";
		String formstr=String.format(str, prod1_id,prod2_id,prod2_id,prod1_id);
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery(formstr);
		
		return (Long) query.uniqueResult()>0;

	}
	
	@Transactional
	public List<Trade> getByProdId(int prodid){
		String str="from Trade t where  t.prod1.prod_id= %d or t.prod2.prod_id=%d";
		String formstr=String.format(str, prodid,prodid);
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery(formstr);
		return query.list();
		
	}
	
	@Transactional
	public List<Trade> getByUserId(int profid,Trade.FROM_TO fromto){
		String str;
		String formstr;
		switch(fromto){
			case FROM:str="from Trade t where t.prod1.owner.prof_id= %d";
					  formstr=String.format(str, profid);
					  break;
			case TO: str="from Trade t where t.prod2.owner.prof_id= %d";
			  		  formstr=String.format(str, profid);
				      break;
			case BOTH:
					 str="from Trade t where  t.prod1.owner.prof_id= %d or t.prod2.owner.prof_id=%d";
					 formstr=String.format(str, profid,profid);
					 break;
		    default:
		    		 return null;
		}
		
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery(formstr);
		return query.list();
		
	}





}
