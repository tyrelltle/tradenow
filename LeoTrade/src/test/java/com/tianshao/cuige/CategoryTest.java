package com.tianshao.cuige;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tianshao.cuige.database.DAO;
import com.tianshao.cuige.models.Category;
import com.tianshao.cuige.models.Profile;
import com.tianshao.cuige.services.ProfileService;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:servlet-context.xml"})
public class CategoryTest {
	@Autowired
	DAO dao;
	
	
	

	
	
	@Test
	/**
	 * test when user first time trying to get a 
	 * profile record but dosent exist, see if profile service
	 * create a new record
	 */
	public void testadd(){
	
		Category cat=new Category();
		cat.setName("cao");
		dao.addNew(cat);
		cat=(Category) dao.getByColumn("Category", "name", "cao");
		assertNotNull(cat);
		assertEquals(cat.getName(),"cao");
		
	}
	
	
}
