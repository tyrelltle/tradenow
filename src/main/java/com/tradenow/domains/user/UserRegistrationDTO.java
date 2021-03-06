package com.tradenow.domains.user;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserRegistrationDTO {
		@NotEmpty
		@Size(min = 6, max = 30)
    	private String password;

    	private String lat;
    	private String lng;
    	@NotEmpty
    	private String location;
    	@NotEmpty @Email
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
