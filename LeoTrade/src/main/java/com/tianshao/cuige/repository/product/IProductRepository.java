package com.tianshao.cuige.repository.product;

import java.util.List;

import com.tianshao.cuige.domains.IEntity;
import com.tianshao.cuige.domains.product.Category;
import com.tianshao.cuige.domains.product.Image;
import com.tianshao.cuige.domains.product.Product;

public interface IProductRepository{

	public abstract Image getProductImageByImgId(int img_id);

	public abstract long countProductImage(int prod_id);

	public abstract List<Product> getByUserId(int userid);

	public abstract Product getByProductId(int prodid);

	public abstract Product getProductWithImages(int prod_id);

	public abstract List<Product> getAllButMe(int userid, int limitL, int limitR)
			throws Exception;

	public abstract void update(IEntity ownerPro);

	public abstract Category getCategory(int catid);

	public abstract List<Category> getCategories();

	public abstract void addNew(IEntity prod);

	public abstract void remove(IEntity prod);

	void addImage_(Image obj);


	List<Product> getAllMine(int userid, int limitL, int limitR)
			throws Exception;

	List<Product> getByCatId(int catid, int myuid, int st, int ct);
	
	List<Product> searchByTitle(String tit);
	public int truncateTable(String tab);
}
