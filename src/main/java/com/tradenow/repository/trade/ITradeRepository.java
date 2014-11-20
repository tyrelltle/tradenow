package com.tradenow.repository.trade;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.tradenow.domains.IEntity;
import com.tradenow.domains.trade.Message;
import com.tradenow.domains.trade.Trade;
import com.tradenow.shared.Pair;

public interface ITradeRepository{

	public Trade getTradeWithGivenItem(int myuserid,int prod2_id);

	public List<Trade> getByUserId(int profid,Trade.FROM_TO fromto);
	public abstract Trade getByTradeid(int id);
		
	public void remove(IEntity obj);

	public void update(IEntity obj);
	
	public void addNew(IEntity obj);

	public List<Message> getMessageByTradeId(int tradeid);
	
	Trade update(int trade_id, List<Pair<String, Object>> columns)
			throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException;

	public void addNewMessage(Message msg);

}
