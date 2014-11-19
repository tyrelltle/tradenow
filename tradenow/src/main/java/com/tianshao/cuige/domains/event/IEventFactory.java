package com.tianshao.cuige.domains.event;

import com.tianshao.cuige.domains.notification.Notification;

public interface IEventFactory {

	IEvent getTradeProposalEvent(String msg, String url, int touid);
}
