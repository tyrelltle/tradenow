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

import com.tianshao.cuige.config.SecurityContext;
import com.tianshao.cuige.domains.notification.Notification;
import com.tianshao.cuige.domains.notification.NotificationDTO;
import com.tianshao.cuige.repository.notification.INotificationRepository;





/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/api/notification")
public class NotificationController {
	    @Autowired
	    private INotificationRepository notificationRepository;
	   
	    
		@RequestMapping(method = RequestMethod.GET,headers="Accept=*/*",produces="application/json")
		public @ResponseBody List<NotificationDTO> get( HttpServletResponse resp) throws IOException {
			List<Notification> lis=notificationRepository.getUnreadByUserId(SecurityContext.getCurrentUser().getUserid());
			List<NotificationDTO> ret= new ArrayList<NotificationDTO>();
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
