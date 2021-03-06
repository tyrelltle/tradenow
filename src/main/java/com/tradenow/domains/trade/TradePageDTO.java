package com.tradenow.domains.trade;

public class TradePageDTO {
	
    	 String tradeid;
    	 String prod1id;
    	 String prod2id;
    	 String side;
    	 String method;
    	 String status1;
    	 String status2;
    	 String msg="";
    	 String msgtype="";//suc err
    	 
    	public TradePageDTO(){}
    	
    	
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
		public String getTradeid() {
			return tradeid;
		}
		public void setTradeid(String tradeid) {
			this.tradeid = tradeid;
		}
		public String getProd1id() {
			return prod1id;
		}
		public void setProd1id(String prod1id) {
			this.prod1id = prod1id;
		}
		public String getSide() {
			return side;
		}
		public void setSide(String side) {
			this.side = side;
		}
		public String getMethod() {
			return method;
		}
		public void setMethod(String method) {
			this.method = method;
		}
		public String getProd2id() {
			return prod2id;
		}
		public void setProd2id(String prod2id) {
			this.prod2id = prod2id;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}


		public String getStatus1() {
			return status1;
		}


		public void setStatus1(String status1) {
			this.status1 = status1;
		}


		public String getStatus2() {
			return status2;
		}


		public void setStatus2(String status2) {
			this.status2 = status2;
		}
    	 
    	 
    	
}	