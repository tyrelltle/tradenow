package com.tianshao.cuige.repository;

import com.tianshao.cuige.models.IEntity;
import com.tianshao.cuige.models.Trade;

public interface ITradeRepository{

	public abstract boolean pairexist(int prod1_id, int prod2_id);


	public abstract void addNew(IEntity trade);

}
