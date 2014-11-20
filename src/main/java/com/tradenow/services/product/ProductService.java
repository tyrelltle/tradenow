package com.tradenow.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradenow.domains.product.Image;
import com.tradenow.domains.product.Product;
import com.tradenow.repository.product.IProductRepository;

@Service("ProductService")
public class ProductService implements IProductService{
	
	@Autowired
	IProductRepository productRepository;
	
	/* (non-Javadoc)
	 * @see com.tradenow.services.IProductService#addProductImage(com.tradenow.models.Image)
	 */
	@Override
	public int addProductImage(Image img){
	
		productRepository.addImage_(img);
		
		if(productRepository.countProductImage(img.getProduct().getProd_id())==1){
			//this is the first image uploaded for the product. make it thumbail
			Product ownerPro=img.getProduct();
			ownerPro.setThumurl("api/product/img/"+img.getImg_id());
			productRepository.update(ownerPro);
		}
		return img.getImg_id();
	}

}
