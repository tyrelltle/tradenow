package com.tianshao.cuige.models.DTO;

public class ProfileDTO {
	
    	private String social_id;
    	private String aboutme;
    	private String location;
    	private String lastname;
    	private String firstname;
    	private String email;
    	
    	
    	public ProfileDTO(){
    		
    	}
    	
		public String getSocial_id() {
			return social_id;
		}

		public void setSocial_id(String social_id) {
			this.social_id = social_id;
		}


		public String getAboutme() {
			return aboutme;
		}

		public void setAboutme(String aboutme) {
			this.aboutme = aboutme;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
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
    	
    	
    
}
