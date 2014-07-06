package com.tianshao.cuige.appservice.trade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianshao.cuige.config.SecurityContext;
import com.tianshao.cuige.domains.event.IEventFactory;
import com.tianshao.cuige.domains.notification.Notification;
import com.tianshao.cuige.domains.trade.Trade;
import com.tianshao.cuige.domains.trade.TradeDTO;
import com.tianshao.cuige.domains.trade.TradePageDTO;
import com.tianshao.cuige.domains.trade.Trade.FROM_TO;
import com.tianshao.cuige.domains.user.User;
import com.tianshao.cuige.repository.notification.INotificationRepository;
import com.tianshao.cuige.repository.product.IProductRepository;
import com.tianshao.cuige.repository.trade.ITradeRepository;
import com.tianshao.cuige.services.Event.IEventService;
import com.tianshao.cuige.services.trade.ITradeService;




/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/api/trade")
public class TradeController {

		@Autowired
		private INotificationRepository notificationRepository;
	    @Autowired
	    private ITradeService tradeService;
	    @Autowired
	    private ITradeRepository tradeRepository;
	    @Autowired
	    private IProductRepository productRepository;
		@RequestMapping(method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public @ResponseBody List<TradeDTO> get(HttpServletResponse resp) throws Exception {

			List<Trade> t=tradeRepository.getByUserId(SecurityContext.getCurrentUser().getUserid(), FROM_TO.BOTH);
			List<TradeDTO> ret=new ArrayList<TradeDTO>();
			Iterator<Trade> i=t.iterator();
			while(i.hasNext()){
				ret.add(i.next().toTradeDTO());
			}
			return ret;
	    	
		}

		
		@RequestMapping(value="propose",method = RequestMethod.POST,headers="Accept=*/*",produces="application/json")
	    public @ResponseBody TradePageDTO propose(@RequestBody TradePageDTO dto, 
	    				   HttpServletResponse resp) throws Exception {

			if(dto.getProd1id()==null || dto.getProd1id().equals("")||dto.getProd1id().equals("-1"))
			{
				dto.setErrorMessage("Please choose an item on left hand side!");
				return dto;
			}
	    	Trade trade=null;
    		boolean firsttime=false;
	    	trade=tradeRepository.getByTradeid(Integer.valueOf(dto.getTradeid()));
    		if(trade==null){	
    			firsttime=true;
    			trade=new Trade();
        		trade.setProd1(productRepository.getByProductId(Integer.valueOf(dto.getProd1id())));
        		trade.setProd2(productRepository.getByProductId(Integer.valueOf(dto.getProd2id())));
    		}else{
    			//only from product can be changed
        		trade.setProd1(productRepository.getByProductId(Integer.valueOf(dto.getProd1id())));
    		}
       		trade.setMethodBySide(dto.getMethod(), dto.getSide());	

    		if(firsttime){
    			trade.setDefaultValues();
    			tradeRepository.addNew(trade);
    		}
    		else{
    			trade=tradeService.updateProposedTrade(trade, dto.getSide());
    		}
	    	dto.setTradeid(String.valueOf(trade.getTrade_id()));
	    	trade.setMethodBySide(dto.getMethod(), dto.getSide());
	    	dto.setSuccessMessage("Successfully proposed the item!");
	    	addNotification(trade,dto.getSide());
	        return dto;
	    }
		
		private void addNotification(Trade trade,String side) throws Exception {
			User usr=new User();
			String notifMsg="%s has proposed a new item, go to view it!";
			if(side.equals(Trade.FROM_TO.FROM.name())){
				notifMsg=String.format(notifMsg, trade.getProd1().getOwner().getUserid());
				usr=trade.getProd1().getOwner();
			}
			else if(side.equals(Trade.FROM_TO.TO.name())){
				notifMsg=String.format(notifMsg, trade.getProd2().getOwner().getUserid());
				usr=trade.getProd2().getOwner();
			}
			else 
				throw new Exception("invalid side string: "+side);
			notificationRepository.addNew(notifMsg, "tradepage/"+trade.getTrade_id(), usr.getUserid());;
			
		}


		@RequestMapping(value="accept/tradeid/{tradeid}/side/{side}",method = RequestMethod.POST,headers="Accept=*/*",produces="application/json")
	    public @ResponseBody TradePageDTO accept(@PathVariable String side, @PathVariable int tradeid,
	    				   HttpServletResponse resp) throws Exception {

			TradePageDTO dto=new TradePageDTO();
	    	Trade trade=null;
	    	trade=tradeRepository.getByTradeid(tradeid);
    		if(trade==null){	
    	    	dto.setErrorMessage("Please propose an item first before accet a trade!");
    	    	return dto;
    		}
    		try{
    			trade.setStatusBySide(side, Trade.STATUS.ACCEPTED);
    		}catch(Exception e){
    	    	dto.setErrorMessage(e.getMessage());
    		}
    		trade=tradeService.updateAcceptedTrade(trade, side);
    		//get up to dated 
    		trade=tradeRepository.getByTradeid(trade.getTrade_id());
    		dto.setTradeid(String.valueOf(trade.getTrade_id()));
    		dto.setStatus1(trade.getStatus1());
    		dto.setStatus2(trade.getStatus2());
	    	dto.setSuccessMessage("You have accepted the item!");
	        return dto;
	    }
		
}
