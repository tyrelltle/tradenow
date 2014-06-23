package com.tianshao.cuige.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tianshao.cuige.models.IEntity;
import com.tianshao.cuige.models.Trade;

public interface ITradeRepository{

	public Trade getTradeWithGivenItem(int myuserid,int prod2_id);

	public List<Trade> getByUserId(int profid,Trade.FROM_TO fromto);
	public abstract Trade getByTradeid(int id);
	
	
	public void addNew(IEntity obj);
	
	public void remove(IEntity obj);

	public void update(IEntity obj);

	public int truncateTable(String tab);
}
