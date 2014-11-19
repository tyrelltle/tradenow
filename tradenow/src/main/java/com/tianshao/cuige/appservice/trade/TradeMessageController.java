package com.tianshao.cuige.appservice.trade;

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

import com.tianshao.cuige.domains.trade.Message;
import com.tianshao.cuige.domains.trade.MessageDTO;
import com.tianshao.cuige.domains.trade.Trade;
import com.tianshao.cuige.domains.trade.TradeDTO;
import com.tianshao.cuige.domains.trade.TradePageDTO;
import com.tianshao.cuige.domains.trade.Trade.FROM_TO;
import com.tianshao.cuige.repository.notification.INotificationRepository;
import com.tianshao.cuige.repository.product.IProductRepository;
import com.tianshao.cuige.repository.trade.ITradeRepository;
import com.tianshao.cuige.services.NotificationService.INotificationService;
import com.tianshao.cuige.services.trade.ITradeService;


@Controller
@RequestMapping("/api/trade/message")
public class TradeMessageController {

		@Autowired
		private INotificationService notificationService;
	    @Autowired
	    private ITradeService tradeService;
	    @Autowired
	    private ITradeRepository tradeRepository;

		@RequestMapping(value="{trade_id}",method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public @ResponseBody List<MessageDTO> get(@PathVariable int trade_id,HttpServletResponse resp) throws Exception {

			List<Message> t=tradeRepository.getMessageByTradeId(trade_id);
			List<MessageDTO> ret=new ArrayList<MessageDTO>();
			Iterator<Message> i=t.iterator();
			while(i.hasNext()){
				ret.add(i.next().toDTO());
			}
			return ret;
	    	
		}

		
		@RequestMapping(value="{trade_id}",method = RequestMethod.POST,headers="Accept=*/*",produces="application/json")
	    public @ResponseBody MessageDTO create(@RequestBody MessageDTO dto, 
	    									  @PathVariable int trade_id,
	    				   HttpServletResponse resp) throws Exception {
			
			Message msg=tradeService.addTradeMessage(dto, trade_id);
			notificationService.createTradeMessageNotif(msg);
			return dto;
	    }
		

		
}
