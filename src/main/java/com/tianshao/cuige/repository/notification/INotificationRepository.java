package com.tianshao.cuige.repository.notification;

import java.util.List;

import com.tianshao.cuige.domains.IEntity;
import com.tianshao.cuige.domains.notification.Notification;
import com.tianshao.cuige.domains.product.Category;

public interface INotificationRepository {
	
	public void addNew(IEntity obj);
	
	public void remove(IEntity obj);

	public void remove(int id);

	public void update(IEntity obj);

	public void addNew(String msg, String url, int userid);
	
	List<Notification> getByUserId(int uid);

	public List<Notification> getUnreadByUserId(int userid);
}
