package com.tradenow.domains.trade;

import com.tradenow.domains.product.Product;

import java.util.ArrayList;
import java.util.List;

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
}
