package com.tianshao.cuige.repository.product;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tianshao.cuige.domains.IEntity;
import com.tianshao.cuige.domains.product.Category;
import com.tianshao.cuige.domains.product.Image;
import com.tianshao.cuige.domains.product.Product;
import com.tianshao.cuige.repository.BaseRepository;

@Repository("productRepository")

public class ProductRepository extends BaseRepository implements IProductRepository{

	@Override
	@Transactional
	public List<Product> getAllButMe(int userid, int limitL, int limitR) throws Exception{
	
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Product where owner.userid != "+userid);
		query.setFirstResult(limitL);
		query.setMaxResults(limitR);
		return query.list();		
	}
	
	@Override
	@Transactional
	public List<Product> getAllMine(int userid, int limitL, int limitR) throws Exception{
	
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Product where owner.userid = "+userid);
		query.setFirstResult(limitL);
		query.setMaxResults(limitR);
		return query.list();		
	}
	
	@Override
	@Transactional	
	public Product getProductWithImages(int prod_id){
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Product where prod_id = "+prod_id);
		Product prod=(Product) query.uniqueResult();
		Hibernate.initialize(prod.getImages());
		return prod;
	}
	@Override
	@Transactional
	public Product getByProductId(int prodid){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Product b where b.prod_id = "+ prodid);
		List<Product> list=query.list();
		if(null==list) return null;
		return list.get(0);
	}
	@Override
	@Transactional	
	public List<Product> getByUserId(int userid){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Product b where b.owner.userid= "+ userid);
		return query.list();
		
	}
	
	@Override
	@Transactional
	public long countProductImage(int prod_id){
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("select count(*) from Image i where i.product.prod_id="+prod_id);
		return (Long) query.uniqueResult();
	}
	
	@Override
	@Transactional
	public Image getProductImageByImgId(int img_id){
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Image i where i.img_id="+img_id);
		return (Image) query.uniqueResult();
	}
	
	@Override
	@Transactional
	public void addImage_(Image obj){
		sessionFactory.getCurrentSession().save(obj);
	}



	@Override
	@Transactional
	public Category getCategory(int catid) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Category i where i.catid="+catid);
		return (Category) query.uniqueResult();
		
	}
	
	@Transactional
	public List<Category> getCategories(){
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Category");
		return query.list();
	}



	
	
	
	

}
