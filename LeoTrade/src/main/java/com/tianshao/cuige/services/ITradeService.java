package com.tianshao.cuige.services;

import com.tianshao.cuige.models.Trade;

public interface ITradeService {


	boolean addNew(Trade trade);

	public abstract boolean update(Trade trade);

}