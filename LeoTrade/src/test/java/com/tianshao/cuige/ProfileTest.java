package com.tianshao.cuige;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tianshao.cuige.models.Profile;
import com.tianshao.cuige.services.ProfileService;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:servlet-context.xml"})
public class ProfileTest {
	@Autowired
	ProfileService serv;
	
	
	

	
	
	@Test
	/**
	 * test when user first time trying to get a 
	 * profile record but dosent exist, see if profile service
	 * create a new record
	 */
	public void testInit(){
	
		String fackFacebookId="helloworld";
		Profile p=(Profile) serv.get("social_id",fackFacebookId);
		assertTrue(p==null);
		p=(Profile)serv.get_create_Profile(fackFacebookId);
		assertTrue(p!=null);
		//see the new record has same social id
		assertEquals(p.getSocial_id(),fackFacebookId);
		//see the new record's profile_id(the primary key) is updated
		assertTrue(p.getProf_id()!=0);
		//cleanup
		serv.remove(p);
		assertTrue(serv.get("social_id",fackFacebookId)==null);
		
	}
	
	@Test
	/**
	 * test get profile by social id
	 */
	public void testget(){
	
		String fackFacebookId="helloworld";
		Profile p=(Profile) serv.get("social_id",fackFacebookId);
		assertTrue(p==null);
		p=(Profile)serv.get_create_Profile(fackFacebookId);
		assertTrue(p!=null);
		//see the new record has same social id
		assertEquals(p.getSocial_id(),fackFacebookId);
		//see the new record's profile_id(the primary key) is updated
		assertTrue(p.getProf_id()!=0);
		
		//remember old facebook/profile id. assert calling 'get' dosent create new record but retrieves existing record
		String fid=p.getSocial_id();
		int pid=p.getProf_id();
		p=(Profile)serv.get_create_Profile(fackFacebookId);
		assertEquals(p.getSocial_id(),fid);
		assertEquals(p.getProf_id(),pid);

		//cleanup
		serv.remove(p);
		assertTrue(serv.get("social_id",fackFacebookId)==null);
		
	}
}
