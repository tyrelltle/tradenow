package com.tradenow.domains.event;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEvent implements IEvent{
	private List<Integer> listeneruserids=new ArrayList<Integer>();
	private Object defresobj=null;
	protected String msg;
	protected String url;
	public AbstractEvent(){}
	public AbstractEvent(String msg, String url){
		this.msg=msg;
		this.url=url;
	}

	@Override
	public List<Integer> getListenerUserIds(){
		return this.listeneruserids;
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



	
}
