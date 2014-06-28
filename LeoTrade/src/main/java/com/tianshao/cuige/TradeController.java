package com.tianshao.cuige;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianshao.cuige.config.SecurityContext;
import com.tianshao.cuige.models.Product;
import com.tianshao.cuige.models.Trade;
import com.tianshao.cuige.models.Trade.FROM_TO;
import com.tianshao.cuige.models.DTO.TradeDTO;
import com.tianshao.cuige.models.DTO.TradePageDTO;
import com.tianshao.cuige.repository.IProductRepository;
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
    			tradeRepository.addNew(trade);
    		}
    		else{
    			tradeRepository.update(trade);
    		}
	    	dto.setTradeid(String.valueOf(trade.getTrade_id()));
	    	trade.setMethodBySide(dto.getMethod(), dto.getSide());
	    	dto.setSuccessMessage("Successfully proposed the item!");
	        return dto;
	    }
}
