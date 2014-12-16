package com.tradenow.domains.trade;


import com.tradenow.domains.IDTO;
import com.tradenow.domains.product.ProductDTO;

import java.util.Date;

public class TradePathNodeDTO implements IDTO {
    int tradeid;
    ProductDTO product;
    String tradedate;
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

    public String getTradedate() {
        return tradedate;
    }

    public void setTradedate(String tradedate) {
        this.tradedate = tradedate;
    }
}
