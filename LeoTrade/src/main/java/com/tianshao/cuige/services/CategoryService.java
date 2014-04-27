package com.tianshao.cuige.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianshao.cuige.database.DAO;
import com.tianshao.cuige.models.Category;

@Service
public class CategoryService {
	@Autowired
	DAO dao;

	public CategoryService(){}
	public int addCategory(Category cat)  {
			 dao.addNew(cat);
			 return cat.getCatid();
	}


	public List<Category> getCategories()  {
		return (List<Category>)dao.list("Category");
		
	}


	public Category getCategory(int id) {
		
		return (Category)dao.getByColumn("Category", "catid", String.valueOf(id));
	}


	
	public void removeCategory(int i) {
		dao.remove(Category.class, i);		
	}

	
	public void update(Category e) {

		
			dao.update(e);
	
	}
	


}
