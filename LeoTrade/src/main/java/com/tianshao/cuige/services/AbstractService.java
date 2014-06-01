package com.tianshao.cuige.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tianshao.cuige.database.DAO;

public abstract class AbstractService {
	@Autowired
	DAO dao;
	
	public void add(Object obj)  {
				 dao.addNew(obj);
	}
	
	
	public List<? extends Object> get()  {
		return dao.list(this.getTableName());
		
	}


	public Object get(String column, String val) {
		
		return dao.getByColumn(this.getTableName(), column, val);
	}

	public Object get(String column, int val) {
		
		return dao.getByColumn(this.getTableName(), column, val);
	}
	
	public void remove(Object obj) {
		dao.remove(obj);
	}

	
	public void update(Object e) {

		
			dao.update(e);
	
	}
	

    public abstract String getTableName();

}
