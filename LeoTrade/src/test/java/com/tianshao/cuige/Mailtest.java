package com.tianshao.cuige;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tianshao.cuige.domains.mail.Mail;
import com.tianshao.cuige.domains.product.Category;
import com.tianshao.cuige.domains.product.Image;
import com.tianshao.cuige.domains.product.Product;
import com.tianshao.cuige.domains.user.User;
import com.tianshao.cuige.repository.product.IProductRepository;
import com.tianshao.cuige.repository.product.ProductRepository;
import com.tianshao.cuige.repository.user.IUserRepository;
import com.tianshao.cuige.repository.user.UserRepository;
import com.tianshao.cuige.services.mail.Mailer;
import com.tianshao.cuige.services.product.IProductService;
import com.tianshao.cuige.services.product.ProductService;
import com.tianshao.cuige.services.user.IUserService;
import com.tianshao.cuige.services.user.UserService;
import com.tianshao.cuige.shared.googlegeo.AddressConverter;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:servlet-context.xml"})
public class Mailtest {
	@Autowired
	Mailer mailer;
	@Test
	public void testMailer() throws IOException{
		  Mail mail = new Mail();
		  mail.setMailFrom("tyrelltle@gmail.com");
		  mail.setMailTo("tyrelltle@gmail.com");
		  mail.setMailSubject("Subject - Send Email using Spring Velocity Template");
		  mail.setTemplateName("testEmailTemplate.vm");
		  mailer.sendMail(mail);
	}
}
