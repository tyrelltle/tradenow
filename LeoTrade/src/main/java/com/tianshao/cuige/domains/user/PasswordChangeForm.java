package com.tianshao.cuige.domains.user;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.tianshao.cuige.shared.FormValidator.FieldMatch;
@FieldMatch.List({
    @FieldMatch(first = "password", second = "password_", message = "The password fields must match")
})
public class PasswordChangeForm {
		@NotEmpty
		@Size(min = 6, max = 30)
    	private String password;
    	
		@NotEmpty
		@Size(min = 6, max = 30)
		private String password_;
    	
    	
    	public PasswordChangeForm(){
    		
    	}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getPassword_() {
			return password_;
		}


		public void setPassword_(String password_) {
			this.password_ = password_;
		}
    	

		
    	
    
}
