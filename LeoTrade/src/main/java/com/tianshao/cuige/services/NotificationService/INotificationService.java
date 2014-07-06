package com.tianshao.cuige.services.NotificationService;

import com.tianshao.cuige.domains.trade.Trade;

public interface INotificationService {

	void createTradeProposalNotif(Trade trade,String side) throws Exception;
	
}
