package com.tianshao.cuige.domains.mail;

public class RegconfirmMail extends Mail{
	private Regconfirm regcon;
	private String url;

	public RegconfirmMail(Regconfirm rec,String rooturl){
		regcon=rec;
		url=rooturl;
	}
	
	public String getUrl(){
		return url;
	}
	public Regconfirm getRegcon() {
		return regcon;
	}

	public void setRegcon(Regconfirm regcon) {
		this.regcon = regcon;
	}
	
}
