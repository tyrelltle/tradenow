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
import com.tradenow.repository.product.IProductRepository;
import com.tradenow.repository.trade.ITradeRepository;
import com.tradenow.services.NotificationService.INotificationService;
import com.tradenow.services.trade.ITradeService;
import com.tradenow.services.user.IUserService;



@Controller
@RequestMapping("/api/trade")
public class TradeController {
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
		@RequestMapping(method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public @ResponseBody List<TradeDTO> get(HttpServletResponse resp) throws Exception {

			List<Trade> t=tradeRepository.getByUserId(userService.currentUser().getUserid(), FROM_TO.BOTH);
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
	    	notificationService.createTradeProposal_Approval_Notif(trade,dto.getSide(), INotificationService.TRADE_ACTION.PROPOSAL);
	        return dto;
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
	    		notificationService.createTradeCompleteNotif(trade);
	    	}else{
		    	notificationService.createTradeProposal_Approval_Notif(trade,side, INotificationService.TRADE_ACTION.APPROVAL);
	    	}
	        return dto;
	    }
		
}
