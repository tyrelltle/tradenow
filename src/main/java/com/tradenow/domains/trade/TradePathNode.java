package com.tradenow.domains.trade;

import com.tradenow.domains.IDTO;
import com.tradenow.domains.IEntity;
import com.tradenow.domains.product.Product;
import com.tradenow.domains.product.ProductDTO;

public class TradePathNode implements IEntity {
    Trade trade=null;
    Product product=null;
    public TradePathNode(){}
    public TradePathNode(Trade t,Product p){
        trade=t;
        product=p;
    }
    @Override
    public TradePathNodeDTO toDTO() {
        TradePathNodeDTO dto=new TradePathNodeDTO();
        dto.setTradeid(trade.getTrade_id());
        dto.setTradedate(trade.getTrans_date().toString());
        ProductDTO proddto=new ProductDTO();
        proddto.setCatid(product.getCategory().getCatid());
        proddto.setDetail(product.getDetail());
        proddto.setPrice(product.getPrice());
        proddto.setProd_id(product.getProd_id());
        proddto.setTitle(product.getTitle());
        proddto.setThumurl(product.getThumurl());
        dto.setProduct(proddto);
        return dto;
    }
    public Trade getTrade() {
        return trade;
    }
    public void setTrade(Trade trade) {
        this.trade = trade;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}
