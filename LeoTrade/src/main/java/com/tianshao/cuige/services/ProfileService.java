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
	
	public Profile getBySocialId(String profileId){
		Profile ret=(Profile) this.get("social_id", profileId);
		if(null == ret){
			/*user first time logon, store his social id 
			 *and create a profile record*/
			ret=new Profile();
			ret.setSocial_id(profileId);
			this.add(ret);
		}
		return ret;
	}
	
	
	@Override
	public String getTableName() {
		return "Profile";
	}

}
