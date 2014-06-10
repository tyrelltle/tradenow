package com.tianshao.cuige.services;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tianshao.cuige.models.Trade;


@Service
public class TradeService extends AbstractService{

	
	public static enum FROM_TO{
		FROM,TO,BOTH
	}
	
	
	@Override
	public void add(Object obj) {
		Trade trade=(Trade) obj;
		String socid=trade.getProd1().getOwner().getSocial_id();
		String socid2=trade.getProd2().getOwner().getSocial_id();
		int prodid=trade.getProd1().getProd_id();
		int prodid2=trade.getProd2().getProd_id();
		
		if(socid.equals(socid2)||prodid==prodid2||pairexist(prodid,prodid2)){
			//you cant trade with yourself
			trade.setTrade_id(-1);
			
		}else{
			trade.setTrans_date(new Date());
			super.add(trade);
		}
	}
	
	
	public List<Trade> getByProdId(int prodid){
		String str="from Trade t where  t.prod1.prod_id= %d or t.prod2.prod_id=%d";
		String formstr=String.format(str, prodid,prodid);
		return (List<Trade>) dao.directSqltoList(formstr);
		
	}
	
	
	public List<Trade> getByUserId(int profid,FROM_TO fromto){
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
		
		return (List<Trade>) dao.directSqltoList(formstr);
		
	}
	
	/**
	 * 
	 * check if two prod already have trade record
	 */
	public boolean pairexist(int prod1_id,int prod2_id){
		String str="Select count(*) from Trade t where ( t.prod1.prod_id= %d and t.prod2.prod_id=%d) or ( t.prod1.prod_id= %d and t.prod2.prod_id=%d)";
		String formstr=String.format(str, prod1_id,prod2_id,prod2_id,prod1_id);
		Long ret=(Long) dao.directSql(formstr);
		return ret > 0;

	}

	@Override
	public String getTableName() {
		return "Trade";
	}

}
