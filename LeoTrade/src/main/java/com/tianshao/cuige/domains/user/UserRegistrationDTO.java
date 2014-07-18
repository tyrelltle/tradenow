package com.tianshao.cuige.domains.user;

public class UserRegistrationDTO {
	
    	private String password;
    	private String lastname;
    	private String firstname;
    	private String lat;
    	private String lng;
    	private String location;
    	private String email;
    	
    	
    	public UserRegistrationDTO(){
    		
    	}
    	

		public String getLocation() {
			return location;
		}


		public void setLocation(String location) {
			this.location = location;
		}


		public String getLat() {
			return lat;
		}


		public void setLat(String lat) {
			this.lat = lat;
		}


		public String getLng() {
			return lng;
		}


		public void setLng(String lng) {
			this.lng = lng;
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
