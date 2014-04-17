package com.tianshao.cuige;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianshao.cuige.database.DAO;
import com.tianshao.cuige.models.Product;
import com.tianshao.cuige.models.Event;
import com.tianshao.cuige.services.ProductService;
import com.tianshao.cuige.services.EventService;
import com.tianshao.cuige.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService prodService;
	
	public ProductController(){
		
	}

	@RequestMapping( method = RequestMethod.GET,produces="application/json")
	public @ResponseBody List<ProductService.SimplizedForm> getevents() {
		
		//transform product list to simplified product list
		List<Product> prod=prodService.getProducts();
		List<ProductService.SimplizedForm> ret =new ArrayList<ProductService.SimplizedForm>();
		for(int i=0;i<prod.size();i++)
			ret.add(prodService.toSimplified(prod.get(i)));
		return ret;
    }
	
	
	@RequestMapping(value="/catid/{id}", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody List<ProductService.SimplizedForm> getproductById(@PathVariable long id) {
		
		//transform product list to simplified product list
		List<Product> prod=prodService.getProductsByCat((int)id);
		List<ProductService.SimplizedForm> ret =new ArrayList<ProductService.SimplizedForm>();
		for(int i=0;i<prod.size();i++)
			ret.add(prodService.toSimplified(prod.get(i)));
		return ret;
    }
	
	
	
	@RequestMapping(value="{id}",method = RequestMethod.PUT,headers="Accept=*/*",produces="application/json")
	public @ResponseBody ProductService.SimplizedForm putevents(@RequestBody ProductService.SimplizedForm e,@PathVariable long id, HttpServletResponse resp) throws IOException {
		boolean fail=false;
		Product prod =null;

		try{
			prod=prodService.toFullModel(e);
			this.prodService.update(prod);
		}catch(Exception ex)
		{
			fail=true;
		}
		if(fail)
			resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "error occurred, please contact your system administrator");
		return e;
	}
	
	
	@RequestMapping(value="{id}",method = RequestMethod.DELETE,headers="Accept=*/*")
	public @ResponseBody ProductService.SimplizedForm delevents(@PathVariable long id, HttpServletResponse resp) throws IOException {
		boolean fail=false;
		Product prod=null;
		ProductService.SimplizedForm ret=null;
		try{
			Product e=this.prodService.getProduct((int)id);
			this.prodService.removeProduct((int)id);
			ret=prodService.toSimplified(e);
			return ret;
		}catch(Exception ex)
		{
			fail=true;
		}
		if(fail)
			resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "error occurred, please contact your system administrator");
		return ret;
	}
	
	@RequestMapping(method = RequestMethod.POST,headers="Accept=*/*")
	public @ResponseBody ProductService.SimplizedForm createEvent(@RequestBody ProductService.SimplizedForm e,HttpServletResponse resp) throws IOException {
		boolean fail=false;
		
		try{
			Product prod=prodService.toFullModel(e);
			long id= this.prodService.addProduct(prod);
			e.setId((int)id);
			return e;
		}catch(Exception ex)
		{
			fail=true;
		}
		if(fail)
			resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "error occurred, please contact your system administrator");
		return e;
	}
	
	@ExceptionHandler
	@ResponseBody
	void handleException(MethodArgumentNotValidException ex) {
	   System.out.print(ex.getMessage());
	}
}
