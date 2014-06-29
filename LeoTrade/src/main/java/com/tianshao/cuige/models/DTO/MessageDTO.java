package com.tianshao.cuige.models.DTO;

public class MessageDTO {
	
    
    	 String msg="";
    	 String msgtype="";//suc err
    	 
    	public MessageDTO(){}
    	
    	
    	public String getMsgtype() {
			return msgtype;
		}


		public void setMsgtype(String msgtype) {
			this.msgtype = msgtype;
		}


		public void setErrorMessage(String msg){
    		msgtype="err";
    		this.msg=msg;
    	}
    	public void setSuccessMessage(String msg){
    		msgtype="suc";
    		this.msg=msg;
    	}
    	public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}


	
    	 
    	 
    	
}	