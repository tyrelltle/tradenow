package com.tianshao.cuige.services.mail;

import org.apache.velocity.VelocityContext;

import com.tianshao.cuige.domains.mail.Mail;
import com.tianshao.cuige.domains.mail.RegconfirmMail;
import com.tianshao.cuige.domains.user.User;

public class RegconfirmMailer extends Mailer {

	@Override
	protected void fillParameters(VelocityContext context,Mail mail) {
		RegconfirmMail rm=(RegconfirmMail)mail;
		User to=mail.getMailTo();
		context.put("firstName", to.getFirstname());
		context.put("lastName", to.getLastname());
		context.put("addr", rm.getfullurl());
	}

	@Override
	protected String getTemplateName() {
		return "testEmailTemplate.vm";
	}

}
