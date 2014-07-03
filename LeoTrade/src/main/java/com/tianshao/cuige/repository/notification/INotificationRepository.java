package com.tianshao.cuige.repository.notification;

import com.tianshao.cuige.domains.IEntity;

public interface INotificationRepository {
	
	public void addNew(IEntity obj);
	
	public void remove(IEntity obj);

	
	public void update(IEntity obj);

	
	public int truncateTable(String tab);

	public void addNew(String msg, String url, int userid);
}
