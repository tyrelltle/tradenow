package com.tianshao.cuige.appservice.notification;

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
import com.tianshao.cuige.domains.user.User;
import com.tianshao.cuige.repository.notification.INotificationRepository;
import com.tianshao.cuige.services.user.IUserService;





/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/api/notification")
public class NotificationController {
	    @Autowired
	    private INotificationRepository notificationRepository;
	   
	    @Autowired
	    private IUserService userService;
	    
		@RequestMapping(method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public @ResponseBody List<NotificationDTO> get( HttpServletResponse resp) throws IOException {
			User curuser=userService.currentUser();
			List<NotificationDTO> ret= new ArrayList<NotificationDTO>();
			if(curuser == null)
				return ret;
			List<Notification> lis=notificationRepository.getUnreadByUserId(curuser.getUserid());
			Iterator<Notification> i=lis.iterator();
			while(i.hasNext()){
				ret.add(i.next().toDTO());
			}
			return  ret;
	    	
		}
	 
		@RequestMapping(value="{id}",method = RequestMethod.DELETE,headers="Accept=*/*")
		public void del(@PathVariable int id, HttpServletResponse resp) throws IOException {
			notificationRepository.remove(id);		
		}
	
}
