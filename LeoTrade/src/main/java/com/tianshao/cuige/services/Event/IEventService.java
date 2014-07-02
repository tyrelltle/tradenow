package com.tianshao.cuige.services.Event;

import java.util.List;

import org.jboss.logging.Message;
import org.springframework.web.context.request.async.DeferredResult;

import com.tianshao.cuige.domains.event.IEvent;
import com.tianshao.cuige.domains.product.Product;

public interface IEventService {
	public void registerListener(int listeneruserids,
								 Class eventclass,
								 DeferredResult<Product>  defrest);
	public void fireEvent(IEvent e);

}
