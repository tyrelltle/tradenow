package com.tianshao.cuige.services.product;

import com.tianshao.cuige.domains.product.Image;

public interface IProductService {

	/**
	 * return: image table record id of the new image 
	 */
	public abstract int addProductImage(Image img);


}