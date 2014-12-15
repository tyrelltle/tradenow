package com.tradenow.domains.mail;

import com.tradenow.domains.user.User;
import org.apache.velocity.VelocityContext;

import java.util.Date;

public class FeedbackMailer extends Mailer {

	@Override
	protected void fillParameters(VelocityContext context,Mail mail) {
		FeedbackMail feedback=(FeedbackMail)mail;
		User user=feedback.getUser();
		context.put("firstName", user.getFirstname());
		context.put("lastName", user.getLastname());
		context.put("time", new Date());
		context.put("email", user.getEmail());
        context.put("message",feedback.getMessage());
	}

	@Override
	protected String getTemplateName() {
		return "feedbackEmailTemplate.vm";
	}

}
