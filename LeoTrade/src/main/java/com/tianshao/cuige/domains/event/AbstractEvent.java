package com.tianshao.cuige.domains.event;

import java.util.ArrayList;
import java.util.List;

import com.tianshao.cuige.domains.Notification.Notification;
import com.tianshao.cuige.repository.notification.INotificationRepository;

public abstract class AbstractEvent implements IEvent{
	private List<Integer> listeneruserids=new ArrayList<Integer>();
	private Object defresobj=null;
	protected INotificationRepository notificationRepository;
	protected Notification notification;
	
	public AbstractEvent(INotificationRepository notif, Notification notification){
		this.notificationRepository=notif;
		this.notification=notification;
	}


	@Override
	public void setListenerUserIds(List<Integer> lis) {
		listeneruserids=lis;
	}

	@Override
	public Object getDeferredResultObj() {
		return defresobj;
	}

	@Override
	public void setDeferredResultObj(Object o) {
		defresobj=o;
	}

	@Override
	public void nonhitOperation(List<Integer> nonhituserids) {
		for(int i:nonhituserids){
			notificationRepository.addNew(notification.getMsg(),
										  notification.getUrl(),
										  i);
		}
		
	}

	
}
