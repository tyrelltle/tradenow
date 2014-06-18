package com.tianshao.cuige.models.DTO;

public class ProviderInfo {

	

		public String justloggedin;
		public String userconid;
		public String providerid;
		public String provideruserid;
		public String email;
		public String firstname;
		public String lastname;
		public String location;
		
		public ProviderInfo(String uid, String provid, String provuid,String justin, String iemail,String ifirstname,String ilastname){
			userconid=uid;
			providerid=provid;
			provideruserid=provuid;
			justloggedin=justin;
			email=iemail;
			firstname=ifirstname;
			lastname=ilastname;
			
		}
		public ProviderInfo(String input) throws Exception{
			String[] lis=input.split("-");
			if(lis==null || lis.length!=7)
				throw new Exception("wrongly formatted providerinfo from cookie");
			userconid=lis[0];
			providerid=lis[1];
			provideruserid=lis[2];
			justloggedin=lis[3];
			email=lis[4];
			firstname=lis[5];
			lastname=lis[6];
	
		}
		
		public String toCookieString() {
			return	userconid+"-"+providerid+"-"+provideruserid+"-"+justloggedin+"-"+email+"-"+firstname+"-"+lastname;
		}
	
}
