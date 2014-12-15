package com.tradenow.services.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import com.tradenow.domains.event.IEvent;

@Service("eventService")
public class EventService implements IEventService{
	Map<MapKey,DeferredResult> listenermap=new HashMap<MapKey,DeferredResult>();
	

	
	@Override
	public synchronized void registerListener(int listeneruserid,
											  Class eventclass, DeferredResult defrest) {
		
		final MapKey key=new MapKey();
		key.listeneruid=listeneruserid;
		key.eventclass=eventclass;
		listenermap.put(key, defrest);
		
		defrest.onCompletion(new Runnable(){
			@Override
			public void run() {
				listenermap.remove(key);
			}});
		defrest.onTimeout(new Runnable(){

			@Override
			public void run() {
				listenermap.remove(key);				
			}});
		
	}

	@Override
	public void fireEvent(IEvent e) {
		new ArrayList<Integer>();
		MapKey hitkey=null;
		synchronized(listenermap){
			for(Integer i : e.getListenerUserIds()){
				hitkey=new MapKey(i,e.getClass());
				if(listenermap.containsKey(hitkey)){
					listenermap.get(hitkey).setResult(e.getDeferredResultObj());
					listenermap.remove(hitkey);
				}
			}
		}

	}
	
	
	
}
