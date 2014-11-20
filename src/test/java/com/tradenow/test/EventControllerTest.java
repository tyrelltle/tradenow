package com.tradenow.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.async.DeferredResult;

import com.tradenow.domains.event.AbstractEvent;
import com.tradenow.domains.event.TradeProposalEvent;
import com.tradenow.services.Event.EventService;
import com.tradenow.services.Event.MapKey;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:servlet-context.xml"})
public class EventControllerTest {

	@Autowired
	EventService eventService;
	
	public class MockEvent extends AbstractEvent{
		

		public MockEvent(){}
		public MockEvent(String msg, String url) {
			super(msg, url);
			// TODO Auto-generated constructor stub
		}

		List<String> msgs=new ArrayList<String>();
		@Override
		public Object getDeferredResultObj() {
			msgs.add("getDeferredResultObj");
			return new Object();
		}




		
	}
	
	
	
	
	@Test
	public void testmockeventfire2(){
		List<Integer> listenerids=new ArrayList<Integer>();
		listenerids.add(1);
		listenerids.add(2);
		listenerids.add(3);

		eventService.registerListener(2, MockEvent.class, new DeferredResult());
		eventService.registerListener(3, MockEvent.class, new DeferredResult());

		MockEvent e = new MockEvent();
		e.setListenerUserIds(listenerids);
		eventService.fireEvent(e);
		assertTrue(e.msgs.size()!=0);
		assertEquals(e.msgs.get(0),"getDeferredResultObj");
		assertEquals(e.msgs.get(1),"getDeferredResultObj");
		assertEquals(e.msgs.get(2),"nonhit:1");
		eventService.registerListener(1, MockEvent.class, new DeferredResult());
		e = new MockEvent();
		e.setListenerUserIds(listenerids);
		eventService.fireEvent(e);
		assertEquals(e.msgs.get(0),"getDeferredResultObj");
		assertEquals(e.msgs.get(1),"nonhit:2");
		assertEquals(e.msgs.get(2),"nonhit:3");
	}	
	@Test
	public void testmockeventfire1(){
		List<Integer> listenerids=new ArrayList<Integer>();
		listenerids.add(1);
		listenerids.add(2);
		listenerids.add(3);

		eventService.registerListener(1, MockEvent.class, new DeferredResult());
		MockEvent e = new MockEvent();
		e.setListenerUserIds(listenerids);
		eventService.fireEvent(e);
		assertTrue(e.msgs.size()!=0);
		assertEquals(e.msgs.get(0),"getDeferredResultObj");
		assertEquals(e.msgs.get(1),"nonhit:2");
		assertEquals(e.msgs.get(2),"nonhit:3");

	}
	
	@Test
	public void testhashequal() throws Exception{
		MapKey k1=new MapKey(123, TradeProposalEvent.class);
		MapKey k2=new MapKey(456, TradeProposalEvent.class);
		MapKey k3=new MapKey(123, TradeProposalEvent.class);

		assertTrue(k1.hashCode()!=k2.hashCode());
		assertTrue(!k1.equals(k2));
		assertTrue(k1.hashCode()==k3.hashCode());
		assertTrue(k1.equals(k3));

	}

}