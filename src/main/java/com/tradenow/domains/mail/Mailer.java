package com.tradenow.domains.mail;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.tradenow.domains.mail.Mail;


public abstract class Mailer {

	 private MailSender mailSender;
	 private VelocityEngine velocityEngine;

	 public void setMailSender(MailSender mailSender) {
	  this.mailSender = mailSender;
	 }

	 public void setVelocityEngine(VelocityEngine velocityEngine) {
	  this.velocityEngine = velocityEngine;
	 }


    /**
     *send email to the user specified in mail.sendto
     * @param mail  the mail object containing the recieptient user information, and specific domain information
     */
	 public void sendMail(Mail mail) {
	  SimpleMailMessage message = new SimpleMailMessage();
	  message.setFrom(((JavaMailSenderImpl) mailSender).getUsername());
	  message.setTo(mail.getMailTo().getEmail());
      configurateMessage(mail, message);
	  mailSender.send(message);
	 }


    /**
     *send email to the site admin email account configuraed in MailSender.
     * @param mail  the mail object containing specific domain information. NOTE! mail.sendto is not used, since the TO user is the site admin email itself
     */
    public void sendMailAdmin(Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(((JavaMailSenderImpl) mailSender).getUsername());
        message.setTo(((JavaMailSenderImpl) mailSender).getUsername());
        configurateMessage(mail, message);
        mailSender.send(message);
    }



    private void configurateMessage(Mail mail, SimpleMailMessage message) {
        message.setSubject(mail.getMailSubject());

        Template template = velocityEngine.getTemplate("./templates/" + getTemplateName());

        VelocityContext velocityContext = new VelocityContext();
//	  velocityContext.put("firstName", "Yashwant");
//	  velocityContext.put("lastName", "Chavan");
//	  velocityContext.put("location", "Pune");
        fillParameters(velocityContext,mail);

        StringWriter stringWriter = new StringWriter();

        template.merge(velocityContext, stringWriter);

        message.setText(stringWriter.toString());
    }

    protected abstract String getTemplateName();
	 protected abstract void fillParameters(VelocityContext context,Mail mail );
	 
}