package com.tradenow.domains.mail;

import org.apache.velocity.VelocityContext;

import com.tradenow.domains.user.User;

public class RegconfirmMailer extends Mailer {

	@Override
	protected void fillParameters(VelocityContext context,Mail mail) {
		RegconfirmMail rm=(RegconfirmMail)mail;
		
		User to=mail.getMailTo();
		context.put("firstName", to.getFirstname());
		context.put("lastName", to.getLastname());
		context.put("addr", rm.getUrl()+"/regcon/"+rm.getRegcon().getId());
	}

	@Override
	protected String getTemplateName() {
		return "testEmailTemplate.vm";
	}

}
