package com.tradenow.domains.event;

import java.util.ArrayList;
import java.util.List;

import com.tradenow.repository.notification.INotificationRepository;

public class TradeProposalEvent extends AbstractEvent {
	int userid;
	public TradeProposalEvent(	INotificationRepository notif,
								String msg,
								String url,
								int touserid
								) {
		super(msg,url);
		this.userid=touserid;
	}
	
	@Override
	public List<Integer> getListenerUserIds() {
		List<Integer> ret=new ArrayList<Integer>();
		ret.add(this.userid);
		return ret;
	}

}
