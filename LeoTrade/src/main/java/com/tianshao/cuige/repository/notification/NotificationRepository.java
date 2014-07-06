package com.tianshao.cuige.repository.notification;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tianshao.cuige.domains.IEntity;
import com.tianshao.cuige.domains.notification.Notification;
import com.tianshao.cuige.domains.product.Category;
import com.tianshao.cuige.domains.product.Product;
import com.tianshao.cuige.repository.BaseRepository;
import com.tianshao.cuige.repository.user.IUserRepository;
@Repository("notificationRepository")
public class NotificationRepository extends BaseRepository 
									implements INotificationRepository 
									{
	@Autowired
	IUserRepository userRepository;
	
	@Override
	@Transactional
	public void addNew(String msg, String url, int userid) {
		Notification notif=new Notification();
		notif.setUser(userRepository.getByUserid(userid));
		notif.setMsg(msg);
		notif.setUrl(url);
		notif.setIsnew(1);
		notif.setCreate_date(new Date());
		super.addNew(notif);
	}
	
	@Transactional
	@Override
	public List<Notification> getByUserId(int uid) {
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Notification b where b.user.userid = "+ uid);
		return query.list();
		
	}
	
	@Transactional
	@Override
	public List<Notification> getUnreadByUserId(int userid) {
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Notification b where b.isnew = 1 and b.user.userid = "+ userid + "order by b.create_date");
		return query.list();
	}
	
	@Transactional
	@Override
	public void remove(int id) {

		Session session = sessionFactory.getCurrentSession();
	    String hql = String.format("delete from Notification where noti_id= %d",id);
	    Query query = session.createQuery(hql);
		query.executeUpdate();
		
	}

	

}
