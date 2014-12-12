package com.tradenow.appservice.trade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tradenow.domains.trade.Trade;
import com.tradenow.domains.trade.TradeDTO;
import com.tradenow.domains.trade.TradePageDTO;
import com.tradenow.domains.trade.Trade.FROM_TO;
import com.tradenow.domains.trade.TradePath;
import com.tradenow.domains.trade.TradePathGenerator;
import com.tradenow.repository.product.IProductRepository;
import com.tradenow.repository.trade.ITradeRepository;
import com.tradenow.services.NotificationService.INotificationService;
import com.tradenow.services.trade.ITradeService;
import com.tradenow.services.user.IUserService;



@Controller
@RequestMapping("/api/tradepath")
public class TradePathController {
		@Autowired
		private IUserService userService;
		@Autowired
		private INotificationService notificationService;
	    @Autowired
	    private ITradeService tradeService;
	    @Autowired
	    private ITradeRepository tradeRepository;
	    @Autowired
	    private IProductRepository productRepository;
	    
	    
	    
	    /*
	     * get trade path of current logged on user
	     */
		@RequestMapping(method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public @ResponseBody List<TradeDTO> getmine(HttpServletResponse resp) throws Exception {

			List<Trade> t=tradeRepository.getByUserId(userService.currentUser().getUserid(), FROM_TO.BOTH);
			List<TradePath> tradepaths=TradePathGenerator.generatorFromTrades(userService.currentUser().getUserid(), t);
			
			
			List<TradeDTO> ret=new ArrayList<TradeDTO>();
			Iterator<Trade> i=t.iterator();
			while(i.hasNext()){
				ret.add(i.next().toDTO());
			}
			return ret;
	    	
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
	    	if(trade.bothAccepted())
	    	{
                tradeService.closeTradeAndPersist(trade);
	    		notificationService.createTradeCompleteNotif(trade);
	    	}else{
		    	notificationService.createTradeProposal_Approval_Notif(trade,side, INotificationService.TRADE_ACTION.APPROVAL);
	    	}
	        return dto;
	    }
		
}
