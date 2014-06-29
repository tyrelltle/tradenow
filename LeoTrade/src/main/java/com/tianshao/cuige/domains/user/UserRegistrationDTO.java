package com.tianshao.cuige.domains.user;

public class UserRegistrationDTO {
	
    	private String password;
    	private String lastname;
    	private String firstname;
    	private String email;
    	
    	
    	public UserRegistrationDTO(){
    		
    	}
    	

		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}



		public String getPassword() {
			return password;
		}



		public void setPassword(String password) {
			this.password = password;
		}

		
    	
    
}
