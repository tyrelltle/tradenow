package com.tianshao.cuige;

import java.io.IOException;
import java.text.DateFormat;
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
import com.tianshao.cuige.models.Category;
import com.tianshao.cuige.services.CategoryService;


@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService catService;
	
	public CategoryController(){
		
	}

	@RequestMapping( method = RequestMethod.GET,produces="application/json")
	public @ResponseBody List<Category> getevents() {
		
        return  catService.getCategories();
    }
	
	@RequestMapping(value="{id}",method = RequestMethod.PUT,headers="Accept=*/*",produces="application/json")
	public @ResponseBody Category putevents(@RequestBody Category e,@PathVariable long id, HttpServletResponse resp) throws IOException {
		boolean fail=false;
		
		try{
			this.catService.update(e);
		}catch(Exception ex)
		{
			fail=true;
		}
		if(fail)
			resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "error occurred, please contact your system administrator");
		return e;
	}
	
	
	@RequestMapping(value="{id}",method = RequestMethod.DELETE,headers="Accept=*/*")
	public @ResponseBody Category delevents(@PathVariable long id, HttpServletResponse resp) throws IOException {
		boolean fail=false;
		Category ret=null;
		try{
			Category e=this.catService.getCategory((int)id);
			this.catService.removeCategory((int)id);
			return e;
		}catch(Exception ex)
		{
			fail=true;
		}
		if(fail)
			resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "error occurred, please contact your system administrator");
		return ret;
	}
	
	@RequestMapping(method = RequestMethod.POST,headers="Accept=*/*")
	public @ResponseBody Category createEvent(@RequestBody Category e,HttpServletResponse resp) throws IOException {
		boolean fail=false;
		Category ret=null;
		try{
			long id= this.catService.addCategory(e);
			e.setCatid((int)id);
			return e;
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
