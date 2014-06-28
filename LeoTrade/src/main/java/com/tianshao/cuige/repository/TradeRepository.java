package com.tianshao.cuige.repository;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tianshao.cuige.models.IEntity;
import com.tianshao.cuige.models.Trade;


@Repository("tradeRepository")

public class TradeRepository extends BaseRepository implements ITradeRepository{

	/**
	 * 
	 * check if two prod already have trade record
	 */
	@Override
	@Transactional
	public Trade getTradeWithGivenItem(int myuserid,int prod2_id){
		String str="from Trade t where ( t.prod1.owner.userid= %d and t.prod2.prod_id=%d) or ( t.prod2.owner.userid= %d and t.prod1.prod_id=%d)";
		String formstr=String.format(str, myuserid,prod2_id,myuserid,prod2_id);
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery(formstr);
		List<Trade> lis=query.list();
		if(null==lis || lis.size()==0)
			return null;
		return lis.get(0);

	}
	
	
	@Transactional
	public List<Trade> getByUserId(int profid,Trade.FROM_TO fromto){
		String str;
		String formstr;
		switch(fromto){
			case FROM:str="from Trade t where t.prod1.owner.userid= %d";
					  formstr=String.format(str, profid);
					  break;
			case TO: str="from Trade t where t.prod2.owner.userid= %d";
			  		  formstr=String.format(str, profid);
				      break;
			case BOTH:
					 str="from Trade t where  t.prod1.owner.userid= %d or t.prod2.owner.userid=%d";
					 formstr=String.format(str, profid,profid);
					 break;
		    default:
		    		 return null;
		}
		
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery(formstr);
		return query.list();
		
	}

	@Override
	@Transactional
	public Trade getByTradeid(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Trade where trade_id="+id);
		return (Trade) query.uniqueResult();
	}

	@Transactional
	@Override
	public void addNew(IEntity obj) {
		((Trade)obj).setTrans_date(new Date());
		super.addNew(obj);
	}





}
