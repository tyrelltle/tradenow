package com.tianshao.cuige;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianshao.cuige.config.SecurityContext;
import com.tianshao.cuige.models.Trade;
import com.tianshao.cuige.models.Trade.FROM_TO;
import com.tianshao.cuige.models.DTO.TradeDTO;
import com.tianshao.cuige.repository.ITradeRepository;
import com.tianshao.cuige.services.ITradeService;




/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/api/trade")
public class TradeController {

	    @Autowired
	    private ITradeService tradeService;
	    @Autowired
	    private ITradeRepository tradeRepository;
	  
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

		

}
