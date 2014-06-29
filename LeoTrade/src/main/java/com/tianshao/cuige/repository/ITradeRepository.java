package com.tianshao.cuige.repository;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tianshao.cuige.models.IEntity;
import com.tianshao.cuige.models.Trade;
import com.tianshao.cuige.shared.Pair;

public interface ITradeRepository{

	public Trade getTradeWithGivenItem(int myuserid,int prod2_id);

	public List<Trade> getByUserId(int profid,Trade.FROM_TO fromto);
	public abstract Trade getByTradeid(int id);
		
	public void remove(IEntity obj);

	public void update(IEntity obj);

	public int truncateTable(String tab);
	
	public void addNew(IEntity obj);

	Trade update(int trade_id, List<Pair<String, Object>> columns)
			throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException;
}
