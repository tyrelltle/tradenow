package com.tradenow.services.Event;

import org.springframework.web.context.request.async.DeferredResult;

import com.tradenow.domains.event.IEvent;
import com.tradenow.domains.product.Product;

public interface IEventService {
	public void registerListener(int listeneruserids,
								 Class eventclass,
								 DeferredResult<Product>  defrest);
	public void fireEvent(IEvent e);

}
