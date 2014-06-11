package com.tianshao.cuige.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianshao.cuige.database.DAO;
import com.tianshao.cuige.models.Category;
import com.tianshao.cuige.models.Profile;

@Service
public class ProfileService extends AbstractService{

	public ProfileService(){
		super();
	}
	
	public Profile create_Profile(String profileId,String firstname, String lastname,String email){
		Profile ret=new Profile();
		ret.setSocial_id(profileId);
		ret.setFirstname(firstname);
		ret.setLastname(lastname);
		ret.setEmail(email);
		this.add(ret);
		
		return ret;
	}
	
	public Profile getByProfid(String profileId){
		return (Profile) this.get("social_id", profileId);
	}
	
	
	@Override
	public String getTableName() {
		return "Profile";
	}

}
