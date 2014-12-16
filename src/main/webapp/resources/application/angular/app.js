/* App Module */

var tradePathApp = angular.module('tradePathApp', [
    'ngRoute',
    'tradePathControllers',
    'tradePathServices'
]);

tradePathApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/tradelis', {
                templateUrl: ctx+'resources/application/angular/partials/tradepathlist.html',
                controller: 'TradePathListCtrl'
            }).
            when('/tradelis/:tradepathid', {
                templateUrl: ctx+'resources/application/angular/partials/tradepathdetail.html',
                controller: 'TradePathDetailCtrl'
            })
    }]);