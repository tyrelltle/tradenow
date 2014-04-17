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
import com.tianshao.cuige.models.CustProduct;
import com.tianshao.cuige.models.Product;
import com.tianshao.cuige.models.Event;
import com.tianshao.cuige.services.CustProductService;
import com.tianshao.cuige.services.ProductService;
import com.tianshao.cuige.services.EventService;
import com.tianshao.cuige.services.ProductService;

@Controller
@RequestMapping("/custproduct")
public class CustProductController {
	@Autowired
	private CustProductService custProdService;
	
	public CustProductController(){
		
	}

	@RequestMapping( method = RequestMethod.GET,produces="application/json")
	public @ResponseBody List<CustProductService.SimplizedForm> getevents() {
		
		//transform product list to simplified product list
		List<CustProduct> prod=custProdService.getCustProducts();
		List<CustProductService.SimplizedForm> ret =new ArrayList<CustProductService.SimplizedForm>();
		for(int i=0;i<prod.size();i++)
			ret.add(custProdService.toSimplified(prod.get(i)));
		return ret;
    }

	//get list of custprods by GUID, each GUID represents a user session
	@RequestMapping( value="{guid}",method = RequestMethod.GET,produces="application/json")
	public @ResponseBody List<CustProductService.SimplizedForm> getbyguid(@PathVariable String guid) {
		return custProdService.getListByGUID(guid);
    }
	
	
	@RequestMapping(value="{id}",method = RequestMethod.PUT,headers="Accept=*/*",produces="application/json")
	public @ResponseBody CustProductService.SimplizedForm putevents(@RequestBody CustProductService.SimplizedForm e,@PathVariable long id, HttpServletResponse resp) throws IOException {
		boolean fail=false;
		CustProduct prod =null;

		try{
			prod=custProdService.toFullModel(e);
			this.custProdService.update(prod);
		}catch(Exception ex)
		{
			fail=true;
		}
		if(fail)
			resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "error occurred, please contact your system administrator");
		return e;
	}
	
	
	@RequestMapping(value="{id}",method = RequestMethod.DELETE,headers="Accept=*/*")
	public @ResponseBody CustProductService.SimplizedForm delevents(@PathVariable long id, HttpServletResponse resp) throws IOException {
		boolean fail=false;
		CustProduct prod=null;
		CustProductService.SimplizedForm ret=null;
		try{
			CustProduct e=this.custProdService.getCustProduct((int)id);
			this.custProdService.removeCustProduct((int)id);
			ret=custProdService.toSimplified(e);
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
	public @ResponseBody CustProductService.SimplizedForm createEvent(@RequestBody CustProductService.SimplizedForm e,HttpServletResponse resp) throws IOException {
		boolean fail=false;
		CustProductService.SimplizedForm ret=null;
		try{
			CustProduct prod=custProdService.toFullModel(e);
			long id= this.custProdService.addCustProduct(prod);
			
			ret= this.custProdService.toSimplified(prod);
		}catch(Exception ex)
		{
			fail=true;
		}
		if(fail)
			resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "error occurred, please contact your system administrator");
		return ret;
	}
	
	@ExceptionHandler
	@ResponseBody
	void handleException(MethodArgumentNotValidException ex) {
	   System.out.print(ex.getMessage());
	}
}
