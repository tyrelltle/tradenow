package com.tradenow.services.NotificationService;

import com.tradenow.domains.trade.Message;
import com.tradenow.domains.trade.Trade;

public interface INotificationService {
	public static enum TRADE_ACTION{
		APPROVAL,
		PROPOSAL
	}
	void createTradeProposal_Approval_Notif(Trade trade,String side, TRADE_ACTION action) throws Exception;
	void createTradeCompleteNotif(Trade trade) throws Exception;
	void createTradeMessageNotif(Message msg);
}
