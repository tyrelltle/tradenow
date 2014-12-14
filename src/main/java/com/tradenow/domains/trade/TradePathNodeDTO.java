package com.tradenow.domains.trade;


import com.tradenow.domains.IDTO;
import com.tradenow.domains.product.ProductDTO;

public class TradePathNodeDTO implements IDTO {
    int tradeid;
    ProductDTO product;
    public TradePathNodeDTO(){}

    public int getTradeid() {
        return tradeid;
    }

    public void setTradeid(int tradeid) {
        this.tradeid = tradeid;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}
