package com.tradenow.domains.trade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.tradenow.domains.product.Product;
import com.tradenow.domains.trade.Trade.FROM_TO;

public class TradePathGenerator {


    /**
     * Map used to create trade path list.
     * Key: the product id of the last product of the trade path
     * Value: the tradepath associated with the key
     */
    public static class TraverseMap{
        HashMap<Integer,TradePath> map=new HashMap<Integer,TradePath>();

        /**
         * update the traverse map -
         * is this product (mine) the last one in any of the tradepath?
         * if so, change the map key to product id of trade product(tradewith),
         * 		  and added the trade tradewith into the map entry
         * if not, create new map entry and insert both mine and tradewith to the map,
         *        set map key to product id of tradewith.
         */
        public void putOrCreate(Product mine, Product tradewith, Trade trade) {
            TradePath path;
            if(map.containsKey(mine.getProd_id())){
                path=map.get(mine.getProd_id());
                path.addNode(tradewith,trade);
                map.put(tradewith.getProd_id(),map.remove(mine.getProd_id()));
            }else{
                path=new TradePath(mine);
                path.addNode(tradewith,trade);
                map.put(tradewith.getProd_id(), path);
            }
        }

        public ArrayList<TradePath> retrieveTradePaths() {
            ArrayList<TradePath> ret=new ArrayList<TradePath>();
            for(int k : map.keySet()){
                ret.add(map.get(k));
            }
            return ret;
        }

    }

    /**
     * traverses trade list and genreated list of trade paths
     * @param ownerid the userid of the owner of the trade path being generated
     * @param tradelis list of trades
     * @return list of tradepaths
     */
    public static List<TradePath> generatorFromTrades(int ownerid,List<Trade> tradelis) {
        TraverseMap map=new TraverseMap();

        FROM_TO side;
        for(Trade trade : tradelis){
            side=trade.getSideByUserId(ownerid);
            if(null == side)
                continue;
            switch(side){
                case FROM:map.putOrCreate(trade.getProd1(), trade.getProd2(),trade);
                    break;
                case TO:  map.putOrCreate(trade.getProd2(), trade.getProd1(),trade);
                    break;
            }

        }
        return map.retrieveTradePaths();
    }
}
