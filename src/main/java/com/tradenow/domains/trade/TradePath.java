package com.tradenow.domains.trade;

import com.tradenow.domains.IEntity;
import com.tradenow.domains.product.Product;
import com.tradenow.domains.product.ProductDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * encapsulate the product list of a trade path, for future possible
 * change of the datastructure (other than arraylist)
 */
public class TradePath implements IEntity{

    //the product that initiates the tradepath
    Product mInitialProduct =null;

    //list of the products that have been traded alone the tradepath
    List<TradePathNode> mNodeList=new ArrayList<TradePathNode>();

    public TradePath(Product tfor) {
        mInitialProduct =tfor;
    }



    public TradePath(Product pfor,List<TradePathNode> nodelis) {
        mNodeList=nodelis;
        mInitialProduct =pfor;
    }


    public Product getInitialProduct(){return mInitialProduct;}

    public void addNode(Product prod, Trade t) {
        mNodeList.add(new TradePathNode(t,prod));
    }


    public TradePathNode getNode(int i) {
        return mNodeList.get(i);
    }

    public int size(){return mNodeList.size();}


    @Override
    public TradePathDTO toDTO() {
        TradePathDTO dto=new TradePathDTO();

        //tradefor dto
        ProductDTO initProd=new ProductDTO();
        initProd.setCatid(mInitialProduct.getCategory().getCatid());
        initProd.setDetail(mInitialProduct.getDetail());
        initProd.setPrice(mInitialProduct.getPrice());
        initProd.setProd_id(mInitialProduct.getProd_id());
        initProd.setTitle(mInitialProduct.getTitle());
        initProd.setThumurl(mInitialProduct.getThumurl());
        dto.setInitialProduct(initProd);
        //node list
        ArrayList<TradePathNodeDTO> nodelis=new ArrayList<TradePathNodeDTO>();
        for(TradePathNode n:mNodeList){
            nodelis.add(n.toDTO());
        }
        dto.setNodes(nodelis);
        return dto;
    }



}
