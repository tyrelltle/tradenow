package com.tianshao.cuige.repository;

import java.util.List;

import com.tianshao.cuige.models.Category;
import com.tianshao.cuige.models.IEntity;
import com.tianshao.cuige.models.Image;
import com.tianshao.cuige.models.Product;

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

}
