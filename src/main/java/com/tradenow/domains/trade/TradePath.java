package com.tradenow.domains.trade;

import com.tradenow.domains.product.Product;
import com.tradenow.domains.product.ProductDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * encapsulate the product list of a trade path, for future possible
 * change of the datastructure (other than arraylist)
 */
public class TradePath {
    List<Product> mProdList=new ArrayList<Product>();

    public TradePath() {

    }
    public TradePath(List prodlis) {
        mProdList=prodlis;
    }

    public void addProduct(Product prod) {
        mProdList.add(prod);
    }

    public Product getProduct(int i) {
        return mProdList.get(i);
    }

    public int size(){return mProdList.size();}
    
    public List<ProductDTO> to_DTO(){
    	//List
    	return null;
    }
}
