package com.tianshao.cuige.services.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianshao.cuige.domains.trade.Message;
import com.tianshao.cuige.domains.trade.Trade;
import com.tianshao.cuige.domains.user.User;
import com.tianshao.cuige.repository.notification.INotificationRepository;

@Service("notificationService")
public class NotificationService implements INotificationService{
	@Autowired
	private INotificationRepository notificationRepository;

	
	@Override
	public void createTradeProposal_Approval_Notif(Trade trade, String side, TRADE_ACTION action) throws Exception {
		User tousr=new User();
		String notifMsg="%s has a new %s!";
		User owner;
		if(side.equals(Trade.FROM_TO.FROM.name())){
			owner =  trade.getProd1().getOwner();
			notifMsg=String.format(notifMsg,owner.getFirstname()+" "+owner.getLastname(),
											action.name());
			tousr=trade.getProd2().getOwner();
		}
		else if(side.equals(Trade.FROM_TO.TO.name())){
			owner =  trade.getProd2().getOwner();
			notifMsg=String.format(notifMsg,owner.getFirstname()+" "+owner.getLastname(),
											action.name());
			tousr=trade.getProd1().getOwner();
		}
		else 
			throw new Exception("invalid side string: "+side);
		notificationRepository.addNew(notifMsg, "tradepage/"+trade.getTrade_id(), tousr.getUserid());
	}

	/**
	 * when trade finishes, notify both trade.user1 and user2
	 */
	@Override
	public void createTradeCompleteNotif(Trade trade)
			throws Exception {
		User tousr=new User();
		String notifMsg="Your trade with %s has completed!";
		User owner;
		
		owner =  trade.getProd1().getOwner();
		notifMsg=String.format(notifMsg,owner.getFirstname()+" "+owner.getLastname());
		tousr=trade.getProd2().getOwner();
		notificationRepository.addNew(notifMsg, "tradepage/"+trade.getTrade_id(), tousr.getUserid());	

		owner =  trade.getProd2().getOwner();
		notifMsg=String.format(notifMsg,owner.getFirstname()+" "+owner.getLastname());
		tousr=trade.getProd1().getOwner();
		notificationRepository.addNew(notifMsg, "tradepage/"+trade.getTrade_id(), tousr.getUserid());	
		
	}

	@Override
	public void createTradeMessageNotif(Message msg) {
		String notifMsg="%s has sent you a message!";
		User touser=null;
		User owner=null;
		if(msg.getSide()==0){
			owner=msg.getTrade().getProd1().getOwner();
			notifMsg=String.format(notifMsg, owner.getFirstname()+" "+owner.getLastname());
			touser=msg.getTrade().getProd2().getOwner();
		}else{
			owner=msg.getTrade().getProd2().getOwner();
			notifMsg=String.format(notifMsg, owner.getFirstname()+" "+owner.getLastname());
			touser=msg.getTrade().getProd1().getOwner();
		}
		
		notificationRepository.addNew(notifMsg, "tradepage/"+msg.getTrade().getTrade_id(), touser.getUserid());	

		
	}
}
