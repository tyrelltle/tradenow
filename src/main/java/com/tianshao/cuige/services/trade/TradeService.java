package com.tianshao.cuige.services.trade;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianshao.cuige.domains.trade.Message;
import com.tianshao.cuige.domains.trade.MessageDTO;
import com.tianshao.cuige.domains.trade.Trade;
import com.tianshao.cuige.domains.trade.TradePageDTO;
import com.tianshao.cuige.repository.trade.ITradeRepository;
import com.tianshao.cuige.shared.Pair;


@Service("tradeService")
public class TradeService implements ITradeService{
	@Autowired
	ITradeRepository tradeRepository=null;
	
	public Message addTradeMessage(MessageDTO dto,int tradeid){
		Message msg=new Message();
		msg.setCreate_date(new Timestamp(new Date().getTime()));
		msg.setMsg(dto.getMessage());
		msg.setSide(dto.getSide());
		msg.setTrade(tradeRepository.getByTradeid(tradeid));
		tradeRepository.addNewMessage(msg);
		return msg;
	}
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
