'use strict';

// Declare app level module which depends on views, and components
angular.module('tradeNow', [
  'ngRoute',
  'myApp.view1',
  'myApp.view2',
  'myApp.version',
  'tradeNow.userCenter',
  'tradeNow.landing'

  //'myApp.dataServices'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/signin'});
}]);

angular.module('tradeNow').controller('HeaderCtrl', ['$scope', '$location', '$route',
  function ($scope, $location, $route) {
    $scope.location = $location;

    $scope.home = function () {
        $location.path('/homepage');
    };

    $scope.userCenter = function () {
      $location.path('/usercenter');
    };
  }]);