package com.tradenow.domains.user;

public class UserPageDTO {
	
    	private int userid;
    	private String aboutme;
    	private String location;
    	private String lat;
    	private String lng;
    	private String lastname;
    	private String firstname;
    	private String email;
    	
    	
    	public UserPageDTO(){
    		
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



		public int getUserid() {
			return userid;
		}



		public void setUserid(int userid) {
			this.userid = userid;
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
