package com.tradenow.appservice.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tradenow.domains.product.Category;
import com.tradenow.repository.product.IProductRepository;





/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/api/category")
public class CategoryController {
	    @Autowired
	    private IProductRepository productRepository;
	   
	    
		@RequestMapping(method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public @ResponseBody List<Category> get( HttpServletResponse resp) throws IOException {
			
			return  productRepository.getCategories();
	    	
		}
	 
		
	
}
