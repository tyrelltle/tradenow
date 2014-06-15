package com.tianshao.cuige.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianshao.cuige.models.Category;
import com.tianshao.cuige.models.Image;
import com.tianshao.cuige.models.Product;
import com.tianshao.cuige.models.User;
import com.tianshao.cuige.repository.IProductRepository;

@Service("ProductService")
public class ProductService implements IProductService{
	
	@Autowired
	IProductRepository productRepository;
	
	/* (non-Javadoc)
	 * @see com.tianshao.cuige.services.IProductService#addProductImage(com.tianshao.cuige.models.Image)
	 */
	@Override
	public int addProductImage(Image img){
	
		productRepository.addImage_(img);
		
		if(productRepository.countProductImage(img.getProduct().getProd_id())==1){
			//this is the first image uploaded for the product. make it thumbail
			Product ownerPro=img.getProduct();
			ownerPro.setThumurl("http://localhost:8080/cuige/api/product/img/"+img.getImg_id());
			productRepository.update(ownerPro);
		}
		return img.getImg_id();
	}

}
