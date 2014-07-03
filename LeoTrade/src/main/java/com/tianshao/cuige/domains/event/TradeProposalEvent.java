package com.tianshao.cuige.domains.event;

import java.util.ArrayList;
import java.util.List;

import com.tianshao.cuige.domains.Notification.Notification;
import com.tianshao.cuige.repository.notification.INotificationRepository;

public class TradeProposalEvent extends AbstractEvent {
	int userid;
	public TradeProposalEvent(	INotificationRepository notif,
								Notification notification,
								int touserid
								) {
		super(notif, notification);
		this.userid=touserid;
	}
	
	@Override
	public List<Integer> getListenerUserIds() {
		List<Integer> ret=new ArrayList<Integer>();
		ret.add(this.userid);
		return ret;
	}

}
