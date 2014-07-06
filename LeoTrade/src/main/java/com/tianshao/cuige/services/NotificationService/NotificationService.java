package com.tianshao.cuige.services.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianshao.cuige.domains.trade.Trade;
import com.tianshao.cuige.domains.user.User;
import com.tianshao.cuige.repository.notification.INotificationRepository;

@Service("notificationService")
public class NotificationService implements INotificationService{
	@Autowired
	private INotificationRepository notificationRepository;

	@Override
	public void createTradeProposalNotif(Trade trade, String side) throws Exception {
		User tousr=new User();
		String notifMsg="%s has a new proposal!";
		User owner;
		if(side.equals(Trade.FROM_TO.FROM.name())){
			owner =  trade.getProd1().getOwner();
			notifMsg=String.format(notifMsg,owner.getFirstname()+" "+owner.getLastname());
			tousr=trade.getProd2().getOwner();
		}
		else if(side.equals(Trade.FROM_TO.TO.name())){
			owner =  trade.getProd2().getOwner();
			notifMsg=String.format(notifMsg,owner.getFirstname()+" "+owner.getLastname());
			tousr=trade.getProd1().getOwner();
		}
		else 
			throw new Exception("invalid side string: "+side);
		notificationRepository.addNew(notifMsg, "tradepage/"+trade.getTrade_id(), tousr.getUserid());;		
	}
}
