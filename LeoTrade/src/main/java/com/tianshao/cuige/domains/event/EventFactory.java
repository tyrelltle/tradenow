package com.tianshao.cuige.domains.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianshao.cuige.domains.notification.Notification;
import com.tianshao.cuige.repository.notification.INotificationRepository;

@Service("eventFactory")
public class EventFactory implements IEventFactory{
	@Autowired
	INotificationRepository notificationRefactory;
	
	@Override
	public IEvent getTradeProposalEvent(String msg, String url, int touid) {
		return new TradeProposalEvent(notificationRefactory, msg,url,touid);
	}

}
