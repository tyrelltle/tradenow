package com.tianshao.cuige.services;

import com.tianshao.cuige.models.Image;

public interface IProductService {

	/**
	 * return: image table record id of the new image 
	 */
	public abstract int addProductImage(Image img);


}