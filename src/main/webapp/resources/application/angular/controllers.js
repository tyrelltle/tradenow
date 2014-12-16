/* Controllers */

var tradePathControllers = angular.module('tradePathControllers', []);

tradePathControllers.controller('TradePathListCtrl', ['$scope', 'TradePath',
    function($scope, TradePath) {
        TradePath.getAll().then(function(data){
            $scope.tradepaths = data;
        });
    }]);

tradePathControllers.controller('TradePathDetailCtrl', ['$scope', '$routeParams', 'TradePath',
    function($scope, $routeParams, TradePath) {
        TradePath.getOne($routeParams.tradepathid).then(function(data){
            $scope.tradepath = data;
        });
    }]);