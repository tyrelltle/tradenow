package com.tianshao.cuige.repository.product;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
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
	public List<Product> getByCatId(int catid, int myuid,int st, int ct) {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Product where category.catid = %d and owner.userid != %d";
		hql=String.format(hql, catid,myuid);
		Query query= session.createQuery(hql);
		query.setFirstResult(st);
		query.setMaxResults(ct);
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
	
	@Transactional
	@Override
	public List<Product> searchByTitle(String tit) {
		Session session = sessionFactory.getCurrentSession();
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Product.class).get();
		org.apache.lucene.search.Query luceneQuery = queryBuilder.keyword().onFields("title").matching(tit).createQuery();
		// wrap Lucene query in a javax.persistence.Query
        org.hibernate.Query fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery, Product.class);
        List<Product> ret=fullTextQuery.list();
        fullTextSession.clear();
		return ret;
	}





	
	
	
	

}
