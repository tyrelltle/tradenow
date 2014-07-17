package com.tianshao.cuige.repository.product;

import java.util.List;

import org.apache.lucene.search.Sort;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.search.query.dsl.Unit;
import org.hibernate.search.spatial.DistanceSortField;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tianshao.cuige.domains.product.Category;
import com.tianshao.cuige.domains.product.Image;
import com.tianshao.cuige.domains.product.Product;
import com.tianshao.cuige.domains.user.User;
import com.tianshao.cuige.repository.BaseRepository;

@Repository("productRepository")

public class ProductRepository extends BaseRepository implements IProductRepository{
	private static final int locationrange = 100;
	
	@Override
	@Transactional
	public List<Product> getAllButMe(User curuser, int limitL, int limitR) throws Exception{
	//	public List<Product> getNearBy(int st, int ct, User centraluser, SimpleExpression... exps) 
		
		Session session = sessionFactory.getCurrentSession();

		Criteria c = session.createCriteria(Product.class, "prod");
		c.createAlias("prod.owner", "owner"); // inner join by default
		c.add(Restrictions.ne("owner.userid", curuser.getUserid()));
		
		return this.getNearBy(limitL, limitR, curuser, c);		
	}
	
	@Override
	@Transactional
	public List<Product> getByCatId(User curuser, int catid,int st, int ct) {
		Session session = sessionFactory.getCurrentSession();

		Criteria c = session.createCriteria(Product.class, "prod");
		c.createAlias("prod.owner", "owner");
		c.createAlias("prod.category", "category");

		c.add(Restrictions.ne("owner.userid", curuser.getUserid()));
		
		c.add(Restrictions.eq("category.catid",catid));
		return this.getNearBy(st, ct, curuser, c);		
	}
	
	@Transactional
	@Override
	public List<Product> searchByTitle(String tit,int st,int ct) {
		Session session = sessionFactory.getCurrentSession();
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Product.class).get();
		org.apache.lucene.search.Query luceneQuery = queryBuilder.keyword().onFields("title").matching(tit).createQuery();
		// wrap Lucene query in a javax.persistence.Query
        org.hibernate.Query fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery, Product.class);
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
	


	

	@Override
	@Transactional
	public List<Product> getNearBy(int st, int ct, User centraluser, Criteria criteria) {
		double centerLatitude = centraluser.getLatitude();
		double centerLongitude = centraluser.getLongitude();
		FullTextSession fullTextSession = Search.getFullTextSession(sessionFactory.getCurrentSession());

		QueryBuilder builder = fullTextSession.getSearchFactory()
		   .buildQueryBuilder().forEntity( User.class ).get();
		org.apache.lucene.search.Query luceneQuery = builder.spatial()
			  .onCoordinates("location")
			  .within(locationrange, Unit.KM)
		      .ofLatitude(centerLatitude)
		      .andLongitude(centerLongitude)
		   .createQuery();

		FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery, Product.class);
		Sort distanceSort = new Sort(
		    new DistanceSortField(centerLatitude, centerLongitude, "location"));
		fullTextQuery.setSort(distanceSort);
		
		
		//criteria create
		if(criteria !=null)
			fullTextQuery.setCriteriaQuery(criteria);	
		fullTextQuery.setFirstResult(st);
		fullTextQuery.setMaxResults(ct);
		List<Product> ret=fullTextQuery.list();
		fullTextSession.clear();
		return ret;
	}


	
	
	
	

}
