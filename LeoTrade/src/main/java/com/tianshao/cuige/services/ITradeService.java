package com.tianshao.cuige.services;

public interface ITradeService {

	public abstract boolean validateAndAddTrade(Object obj);

	boolean addTradeWithoutValidation(Object obj);

}