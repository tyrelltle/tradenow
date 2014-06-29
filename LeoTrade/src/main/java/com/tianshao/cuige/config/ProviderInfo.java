package com.tianshao.cuige.config;

public class ProviderInfo {

		private final String sep="~";
		public int userid;
		public String userconid;
		public String providerid;
		public String provideruserid;
		public String email;
		public String firstname;
		public String lastname;
		public String location;
		
		public ProviderInfo(int userid, String uid, String provid, String provuid, String iemail,String ifirstname,String ilastname){
			this.userid=userid;
			userconid=uid;
			providerid=provid;
			provideruserid=provuid;
			email=iemail;
			firstname=ifirstname;
			lastname=ilastname;
			
		}
		public ProviderInfo(String input) throws Exception{
			String[] lis=input.split(sep);
			if(lis==null || lis.length!=7)
				throw new Exception("wrongly formatted providerinfo from cookie");
			userid=Integer.valueOf(lis[0]);
			userconid=lis[1];
			providerid=lis[2];
			provideruserid=lis[3];
			email=lis[4];
			firstname=lis[5];
			lastname=lis[6];
	
		}
		
		public String toCookieString() {
			return	userid+sep+userconid+sep+providerid+sep+provideruserid+sep+email+sep+firstname+sep+lastname;
			
		}
	
}
