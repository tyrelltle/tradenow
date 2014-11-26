package com.tradenow.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tradenow.domains.mail.Regconfirm;
import com.tradenow.domains.user.User;
import com.tradenow.domains.mail.Mailer;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:servlet-context.xml"})
public class Mailtest {
	@Autowired
	Repo repo;
	@Autowired
	Mailer mailer;
//	@Test
//	public void testMailer() throws IOException{
//		  Mail mail = new Mail();
//		  mail.setMailTo("tyrelltle@gmail.com");
//		  mail.setMailSubject("Subject - Send Email using Spring Velocity Template");
//		  mail.setTemplateName("testEmailTemplate.vm");
//		  mailer.sendMail(mail);
//	}
//	
	@Test
	public void testRegconfirm(){
		User u=new User();
		repo.addNew(u);
		
		Regconfirm rc=new Regconfirm();
		rc.setUser(u);
		rc.setUser(u);
		repo.addNew(rc);
		
	}
}
