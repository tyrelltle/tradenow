package com.tianshao.cuige.services.Admin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("adminService")
public class AdminService implements IAdminService{
	@Autowired
	protected SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public void doSearchIndex() throws InterruptedException {
		
			Session session = sessionFactory.getCurrentSession();
			FullTextSession fullTextSession = Search.getFullTextSession(session);
	        fullTextSession.createIndexer().startAndWait();
		
		
	}	

}
