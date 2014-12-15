package com.tradenow.appservice.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tradenow.services.Admin.IAdminService;





/**
	deals with administration tasks like initialize search index
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	    @Autowired
	    private IAdminService adminService;
	   
	    
		@RequestMapping(value="doSearchIndex",method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public String get( HttpServletResponse resp) throws IOException, InterruptedException {
			adminService.doSearchIndex();
			return "success";
	    	
		}
	 
	
}
