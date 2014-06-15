package com.tianshao.cuige.services;


import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianshao.cuige.models.Trade;
import com.tianshao.cuige.repository.ITradeRepository;


@Service("tradeService")
public class TradeService implements ITradeService{
	@Autowired
	ITradeRepository tradeRepository;
	

	
	
	/* (non-Javadoc)
	 * @see com.tianshao.cuige.services.ITradeService#validateAndAddTrade(java.lang.Object)
	 */
	@Override
	public boolean validateAndAddTrade(Object obj) {
		Trade trade=(Trade) obj;
		int uid1=trade.getProd1().getOwner().getUserid();
		int uid2=trade.getProd2().getOwner().getUserid();
		int prodid=trade.getProd1().getProd_id();
		int prodid2=trade.getProd2().getProd_id();
		
		if(uid1==uid2||prodid==prodid2||tradeRepository.pairexist(prodid,prodid2)){
			//you cant trade with yourself
			trade.setTrade_id(-1);
			return false;
		}else{
			trade.setTrans_date(new Date());
			tradeRepository.addNew(trade);
			return true;
		}
	}
	
	

}
