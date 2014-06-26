package com.tianshao.cuige.services;


import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianshao.cuige.models.Trade;
import com.tianshao.cuige.repository.ITradeRepository;


@Service("tradeService")
public class TradeService implements ITradeService{
	@Autowired
	ITradeRepository tradeRepository;


	
	@Override
	public boolean addNewTrade(Trade t) {
		t.setTrans_date(new Date());
		tradeRepository.addNew(t);
		return true;
	}


	

}
