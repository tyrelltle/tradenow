package com.tianshao.cuige.services;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianshao.cuige.models.Trade;
import com.tianshao.cuige.repository.ITradeRepository;
import com.tianshao.cuige.shared.Pair;


@Service("tradeService")
public class TradeService implements ITradeService{
	@Autowired
	ITradeRepository tradeRepository=null;
	
	
	public Trade updateProposedTrade(Trade trade, String side) throws Exception{
		ArrayList<Pair<String,Object>> lis=new ArrayList<Pair<String,Object>>();
		if(side.equals(Trade.FROM_TO.FROM.name())){
			lis.add(new Pair<String,Object>("setProd1",trade.getProd1()));
			lis.add(new Pair<String,Object>("setMethod1",trade.getMethod1()));

		}else if(side.equals(Trade.FROM_TO.TO.name())){

			lis.add(new Pair<String,Object>("setProd1",trade.getProd1()));
			lis.add(new Pair<String,Object>("setMethod2",trade.getMethod2()));

		}else{
			throw new Exception("invalid side string:"+side);
			
		}

		return tradeRepository.update(trade.getTrade_id(), lis);
		
	}
	
	public Trade updateAcceptedTrade(Trade trade, String side) throws Exception{
		ArrayList<Pair<String,Object>> lis=new ArrayList<Pair<String,Object>>();
		if(side.equals(Trade.FROM_TO.FROM.name())){
			lis.add(new Pair<String,Object>("setStatus1",trade.getStatus1()));

		}else if(side.equals(Trade.FROM_TO.TO.name())){
			lis.add(new Pair<String,Object>("setStatus2",trade.getStatus2()));
		}else{
			throw new Exception("invalid side string:"+side);
			
		}

		return tradeRepository.update(trade.getTrade_id(), lis);
		
	}

	

}
