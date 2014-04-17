package com.tianshao.cuige.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianshao.cuige.database.DAO;
import com.tianshao.cuige.models.Event;

@Service
public class EventService {
	@Autowired
	DAO dao;

	public EventService(){}
	public int addEvent(Event event)  {
			 dao.addNew(event);
			 return event.id;
	}


	public List<Event> getEvents()  {
		return (List<Event>)dao.list("Event");
		
	}


	public Event getEvent(int id) {
		
		return (Event)dao.getById("Event", id);
	}


	
	public void removeEvent(int i) {
		dao.remove(Event.class, i);		
	}

	
	public void update(Event e) {

		
			dao.update(e);
	
	}
	


}
