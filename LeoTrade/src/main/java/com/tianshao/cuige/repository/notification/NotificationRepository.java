package com.tianshao.cuige.repository.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tianshao.cuige.domains.Notification.Notification;
import com.tianshao.cuige.repository.BaseRepository;
import com.tianshao.cuige.repository.user.IUserRepository;
@Repository("notificationRepository")
public class NotificationRepository extends BaseRepository 
									implements INotificationRepository 
									{
	@Autowired
	IUserRepository userRepository;
	
	@Override
	public void addNew(String msg, String url, int userid) {
		Notification notif=new Notification();
		notif.setUser(userRepository.getByUserid(userid));
		notif.setMsg(msg);
		notif.setUrl(url);
		super.addNew(notif);
	}
	
	
	

}
