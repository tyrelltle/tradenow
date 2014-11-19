package com.tianshao.cuige.services.trade;

import java.lang.reflect.InvocationTargetException;

import com.tianshao.cuige.domains.trade.Message;
import com.tianshao.cuige.domains.trade.MessageDTO;
import com.tianshao.cuige.domains.trade.Trade;
import com.tianshao.cuige.domains.trade.TradePageDTO;

public interface ITradeService {

	public Trade updateProposedTrade(Trade trade, String side) throws Exception;
	public Trade updateAcceptedTrade(Trade trade, String side) throws Exception;
	public Message addTradeMessage(MessageDTO dto,int tradeid);

	
}