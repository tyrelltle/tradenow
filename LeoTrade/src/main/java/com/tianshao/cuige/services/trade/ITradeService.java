package com.tianshao.cuige.services.trade;

import java.lang.reflect.InvocationTargetException;

import com.tianshao.cuige.domains.trade.Trade;

public interface ITradeService {

	public Trade updateProposedTrade(Trade trade, String side) throws Exception;
	public Trade updateAcceptedTrade(Trade trade, String side) throws Exception;


}