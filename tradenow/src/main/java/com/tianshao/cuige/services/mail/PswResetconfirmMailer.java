package com.tianshao.cuige.services.mail;

import java.util.Date;

import org.apache.velocity.VelocityContext;

import com.tianshao.cuige.domains.mail.Mail;
import com.tianshao.cuige.domains.mail.RegconfirmMail;
import com.tianshao.cuige.domains.user.User;

public class PswResetconfirmMailer extends Mailer {

	@Override
	protected void fillParameters(VelocityContext context,Mail mail) {
		RegconfirmMail rm=(RegconfirmMail)mail;
		User to=mail.getMailTo();
		context.put("firstName", to.getFirstname());
		context.put("lastName", to.getLastname());
		context.put("time", new Date());
		context.put("addr", rm.getUrl()+"/pswcon/"+rm.getRegcon().getId());
	}

	@Override
	protected String getTemplateName() {
		return "resetpswEmailTemplate.vm";
	}

}
