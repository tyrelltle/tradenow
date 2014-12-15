package com.tradenow.services.trade;

import com.tradenow.domains.trade.Message;
import com.tradenow.domains.trade.MessageDTO;
import com.tradenow.domains.trade.Trade;

public interface ITradeService {

	public Trade updateProposedTrade(Trade trade, String side) throws Exception;
	public Trade updateAcceptedTrade(Trade trade, String side) throws Exception;
	public Message addTradeMessage(MessageDTO dto,int tradeid);

	
}