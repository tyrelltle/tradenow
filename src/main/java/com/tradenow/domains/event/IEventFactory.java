package com.tradenow.domains.event;

public interface IEventFactory {

	IEvent getTradeProposalEvent(String msg, String url, int touid);
}
