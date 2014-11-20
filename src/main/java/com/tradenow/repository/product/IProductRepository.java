package com.tradenow.repository.product;

import java.util.List;

import com.tradenow.domains.IEntity;
import com.tradenow.domains.product.Category;
import com.tradenow.domains.product.Image;
import com.tradenow.domains.product.Product;
import com.tradenow.domains.user.User;

public interface IProductRepository{

	public abstract Image getProductImageByImgId(int img_id);

	public abstract long countProductImage(int prod_id);

	public abstract List<Product> getByUserId(int userid);

	public abstract Product getByProductId(int prodid);

	public abstract Product getProductWithImages(int prod_id);
	
	public abstract Product getProductWithLikers(int prod_id);

	public abstract List<Product> getAllButMe(User curuser, int limitL, int limitR)
			throws Exception;

	public abstract List<Product> getAllButMeByAddr(User curuser, Double lat, Double lng, int limitL, int limitR)
			throws Exception;
	
	public abstract void update(IEntity ownerPro);

	public abstract Category getCategory(int catid);

	public abstract List<Category> getCategories();

	public abstract void addNew(IEntity prod);

	public abstract void remove(IEntity prod);

	void addImage_(Image obj);


	List<Product> getAllMine(int userid, int limitL, int limitR)
			throws Exception;

	List<Product> getByCatId(User curuser, int catid, int st, int ct);
	
	



	List<Product> searchByTitle(int myuid, String tit, int st, int ct);
}
