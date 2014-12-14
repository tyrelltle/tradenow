package com.tradenow.domains.trade;

import com.tradenow.domains.IDTO;
import com.tradenow.domains.product.ProductDTO;

import java.util.ArrayList;

public class TradePathDTO implements IDTO {
    ProductDTO initialProduct;
    ArrayList<TradePathNodeDTO> nodes;

    public TradePathDTO(){}

    public ProductDTO getInitialProduct() {
        return initialProduct;
    }

    public void setInitialProduct(ProductDTO initialProduct) {
        this.initialProduct = initialProduct;
    }

    public ArrayList<TradePathNodeDTO> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<TradePathNodeDTO> nodes) {
        this.nodes = nodes;
    }
}
