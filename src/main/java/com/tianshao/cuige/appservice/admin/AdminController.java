package com.tianshao.cuige.appservice.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianshao.cuige.domains.notification.Notification;
import com.tianshao.cuige.domains.notification.NotificationDTO;
import com.tianshao.cuige.repository.notification.INotificationRepository;
import com.tianshao.cuige.services.Admin.IAdminService;





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
