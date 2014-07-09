package com.tianshao.cuige.repository.trade;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tianshao.cuige.domains.IEntity;
import com.tianshao.cuige.domains.trade.Message;
import com.tianshao.cuige.domains.trade.Trade;
import com.tianshao.cuige.repository.BaseRepository;
import com.tianshao.cuige.shared.Pair;


@Repository("tradeRepository")

public class TradeRepository extends BaseRepository implements ITradeRepository{
	
	/**
	 * 
	 * @param trade  must contain tradeid and column values that are to be updated
	 * @param columns  array of pair of setter name and value
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	@Override
	@Transactional
	public Trade update(int trade_id, List<Pair<String, Object>>columns) throws NoSuchMethodException, 
																		  SecurityException, 
																		  IllegalAccessException, 
																		  IllegalArgumentException, 
																		  InvocationTargetException {
		//to avoid race condition, only update specific column
		Session session = sessionFactory.getCurrentSession();
		Trade trade = (Trade) session.get(Trade.class,trade_id); 
		for(int i=0;i<columns.size();i++){
			Method method=Trade.class.getMethod(columns.get(i).first, columns.get(i).second.getClass());
			method.invoke(trade, columns.get(i).second);
		}
		return trade;

	}


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

	@Transactional
	@Override
	public List<Message> getMessageByTradeId(int tradeid) {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Message where trade.trade_id=%d order by create_date desc";
		Query query=session.createQuery(String.format(hql, tradeid));
		return query.list();
	}

	@Transactional
	@Override
	public void addNewMessage(Message msg) {
		msg.setCreate_date(new Timestamp(new Date().getTime()));
		super.addNew(msg);
	}




}
