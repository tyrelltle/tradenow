package com.tradenow.services.Event;

public class MapKey{

	int listeneruid;
	Class eventclass;

	public MapKey(int a, Class b){
		listeneruid=a;
		eventclass=b;
	}
	
	public MapKey() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((eventclass == null) ? 0 : eventclass.hashCode());
		result = prime * result + listeneruid;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MapKey other = (MapKey) obj;
		if (eventclass == null) {
			if (other.eventclass != null)
				return false;
		} else if (!eventclass.equals(other.eventclass))
			return false;
		if (listeneruid != other.listeneruid)
			return false;
		return true;
	}
}
