package com.tianshao.cuige.repository.product;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tianshao.cuige.domains.IEntity;
import com.tianshao.cuige.domains.product.Category;
import com.tianshao.cuige.domains.product.Image;
import com.tianshao.cuige.domains.product.Product;
import com.tianshao.cuige.domains.user.User;
import com.tianshao.cuige.repository.BaseRepository;
import com.tianshao.cuige.shared.googlegeo.AddressConverter;
import com.tianshao.cuige.shared.googlegeo.GoogleResponse;
import com.tianshao.cuige.shared.googlegeo.Location;

@Repository("productRepository")

public class ProductRepository extends BaseRepository implements IProductRepository{
	private static final int locationrange = 200;
	private static final String spatialsql="";
	@Override
	@Transactional
	public List<Product> getAllButMe(User curuser, int limitL, int limitR) throws Exception{
		
		

		Query query = sessionFactory.getCurrentSession()
									.createQuery("from Product where (6371 * 2 * ASIN(SQRT(POWER(SIN((:ulatitude - abs(latitude)) * pi()/180 / 2),2) +" +
																		"COS(:ulatitude * pi()/180 ) * COS(abs(latitude) * pi()/180) *" +
																		"POWER(SIN((:ulongitude - longitude) * pi()/180 / 2), 2))))*1000 < " + locationrange*1000+																	
																		" and owner.userid != "+curuser.getUserid()+" ORDER BY update_date desc");

		query.setParameter("ulongitude", curuser.getLongitude());
		query.setParameter("ulatitude", curuser.getLatitude());
		query.setFirstResult(limitL);
		query.setMaxResults(limitR);

		return (List<Product>) query.list();
	
		
	}
	

	@Override
	@Transactional
	public List<Product> getByCatId(User curuser, int catid,int st, int ct) {

		Query query = sessionFactory.getCurrentSession()
									.createQuery("from Product where (6371 * 2 * ASIN(SQRT(POWER(SIN((:ulatitude - abs(latitude)) * pi()/180 / 2),2) +" +
																		"COS(:ulatitude * pi()/180 ) * COS(abs(latitude) * pi()/180) *" +
																		"POWER(SIN((:ulongitude - longitude) * pi()/180 / 2), 2))))*1000 < " + locationrange*1000+																	
																		" and category.catid="+catid+" and owner.userid != "+curuser.getUserid()+"ORDER BY update_date desc");

		query.setParameter("ulongitude", curuser.getLongitude());
		query.setParameter("ulatitude", curuser.getLatitude());
		query.setFirstResult(st);
		query.setMaxResults(ct);

		return (List<Product>) query.list();
		
			
	}
	
	@Transactional
	@Override
	public List<Product> searchByTitle(int myuid,String tit,int st,int ct) {
		Session session = sessionFactory.getCurrentSession();
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Product.class).get();
		org.apache.lucene.search.Query luceneQuery = queryBuilder.keyword().onFields("title").matching(tit).createQuery();
		// wrap Lucene query in a javax.persistence.Query
		FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery, Product.class);
        Criteria c = session.createCriteria(Product.class, "prod");
		c.createAlias("prod.owner", "owner"); // inner join by default
		c.add(Restrictions.ne("owner.userid",myuid));
		fullTextQuery.setCriteriaQuery(c);
        fullTextQuery.setFirstResult(st);
        fullTextQuery.setMaxResults(ct);
        List<Product> ret=fullTextQuery.list();
        
        fullTextSession.clear();
		return ret;
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
		Query query=session.createQuery("from Product b where b.owner.userid= "+ userid+" ORDER BY update_date desc");
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
	


	

	

	@Override
	@Transactional
	public void addNew(IEntity obj) {
		Product p =(Product)obj;
		p.setUpdate_date(new Timestamp(new Date().getTime()));

		super.addNew(obj);
	}

	@Override
	@Transactional
	public void update(IEntity obj) {
		Product p =(Product)obj;
		p.setUpdate_date(new Timestamp(new Date().getTime()));
		super.update(obj);
	}

	@Override
	@Transactional	
	public Product getProductWithLikers(int prod_id) {
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Product where prod_id = "+prod_id);
		Product prod=(Product) query.uniqueResult();
		Hibernate.initialize(prod.getLikers());
		return prod;
	}



	
	
	
	

}
