package com.tianshao.cuige.domains.mail;

import java.util.Date;

import com.tianshao.cuige.domains.user.User;

public class Mail {

	 protected User mailTo;

	 protected String mailCc;

	 protected String mailBcc;

	 protected String mailSubject;

	 protected String mailContent;

	 protected String contentType;

	 public Mail() {
	  contentType = "text/html";
	 }

	 public String getContentType() {
	  return contentType;
	 }

	 public void setContentType(String contentType) {
	  this.contentType = contentType;
	 }

	 public String getMailBcc() {
	  return mailBcc;
	 }

	 public void setMailBcc(String mailBcc) {
	  this.mailBcc = mailBcc;
	 }

	 public String getMailCc() {
	  return mailCc;
	 }

	 public void setMailCc(String mailCc) {
	  this.mailCc = mailCc;
	 }

	 public String getMailSubject() {
	  return mailSubject;
	 }

	 public void setMailSubject(String mailSubject) {
	  this.mailSubject = mailSubject;
	 }

	 public User getMailTo() {
	  return mailTo;
	 }

	 public void setMailTo(User mailTo) {
	  this.mailTo = mailTo;
	 }

	 public Date getMailSendDate() {
	  return new Date();
	 }

	 public String getMailContent() {
	  return mailContent;
	 }

	 public void setMailContent(String mailContent) {
	  this.mailContent = mailContent;
	 }

	 @Override
	 public String toString() {
	  StringBuilder lBuilder = new StringBuilder();
	  lBuilder.append("Mail To:- ").append(getMailTo());
	  lBuilder.append("Mail Cc:- ").append(getMailCc());
	  lBuilder.append("Mail Bcc:- ").append(getMailBcc());
	  lBuilder.append("Mail Subject:- ").append(getMailSubject());
	  lBuilder.append("Mail Send Date:- ").append(getMailSendDate());
	  lBuilder.append("Mail Content:- ").append(getMailContent());
	  return lBuilder.toString();
	 }
}
