package com.tradenow.services.trade;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradenow.domains.product.Product;
import com.tradenow.domains.trade.Message;
import com.tradenow.domains.trade.MessageDTO;
import com.tradenow.domains.trade.Trade;
import com.tradenow.domains.user.User;
import com.tradenow.repository.product.IProductRepository;
import com.tradenow.repository.trade.ITradeRepository;
import com.tradenow.shared.Pair;


@Service("tradeService")
public class TradeService implements ITradeService{
    @Autowired
    ITradeRepository tradeRepository=null;
    @Autowired
    IProductRepository productRepository=null;
    public Message addTradeMessage(MessageDTO dto,int tradeid){
        Message msg=new Message();
        msg.setCreate_date(new Timestamp(new Date().getTime()));
        msg.setMsg(dto.getMessage());
        msg.setSide(dto.getSide());
        msg.setTrade(tradeRepository.getByTradeid(tradeid));
        tradeRepository.addNewMessage(msg);
        return msg;
    }
    public Trade updateProposedTrade(Trade trade, String side) throws Exception{
        ArrayList<Pair<String,Object>> lis=new ArrayList<Pair<String,Object>>();
        if(side.equals(Trade.FROM_TO.FROM.name())){
            lis.add(new Pair<String,Object>("setProd1",trade.getProd1()));
            lis.add(new Pair<String,Object>("setMethod1",trade.getMethod1()));

        }else if(side.equals(Trade.FROM_TO.TO.name())){

            lis.add(new Pair<String,Object>("setProd1",trade.getProd1()));
            lis.add(new Pair<String,Object>("setMethod2",trade.getMethod2()));

        }else{
            throw new Exception("invalid side string:"+side);

        }

        return tradeRepository.update(trade.getTrade_id(), lis);

    }

    public Trade updateAcceptedTrade(Trade trade, String side) throws Exception{
        ArrayList<Pair<String,Object>> lis=new ArrayList<Pair<String,Object>>();
        if(side.equals(Trade.FROM_TO.FROM.name())){
            lis.add(new Pair<String,Object>("setStatus1",trade.getStatus1()));

        }else if(side.equals(Trade.FROM_TO.TO.name())){
            lis.add(new Pair<String,Object>("setStatus2",trade.getStatus2()));
        }else{
            throw new Exception("invalid side string:"+side);

        }

        return tradeRepository.update(trade.getTrade_id(), lis);

    }
    /**
     * once trade closed, the product owners will be swapped.
     */
    @Override
    public void closeTradeAndPersist(Trade trade) throws Exception {
        Product prod1 = trade.getProd1();
        Product prod2 = trade.getProd2();
        if(!trade.bothAccepted())
            throw new Exception("Trade can not be closed becasue not both sides accepted");
        User u=prod1.getOwner();
        prod1.setOwner(prod2.getOwner());
        prod2.setOwner(u);
        productRepository.update(prod1);
        productRepository.update(prod2);
    }



}
