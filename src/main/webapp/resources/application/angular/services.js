/* Services */

var tradePathServices = angular.module('tradePathServices', ['ngResource']);
tradePathServices.factory('TradePath', function($q, $resource) {
    var tradepaths=[];
    var service={};
    service.getAll=function() {
        var itemsDefer=$q.defer();
        if(tradepaths.length >0)
            itemsDefer.resolve(tradepaths);
        else
        {
            $resource('api/tradepath').query({},function(data) {
                tradepaths=data;
                itemsDefer.resolve(data)
            });
        }
        return itemsDefer.promise;
    }

    service.getOne=function(i) {
        var itemsDefer=$q.defer();
        itemsDefer.resolve(tradepaths[i]);
        return itemsDefer.promise;
    }
    return service;
});
