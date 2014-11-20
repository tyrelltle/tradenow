package com.tradenow.domains.event;

import java.util.List;

public interface IEvent {
	List<Integer> getListenerUserIds();
	void setListenerUserIds(List<Integer> lis);
	Object getDeferredResultObj();
	void setDeferredResultObj(Object o);	
}
