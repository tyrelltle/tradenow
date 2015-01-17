'use strict';

angular.module('tradeNow.userCenter', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/usercenter', {
    templateUrl: 'userCenter/userCenter.tpl.html',
    controller: 'UserCenterCtrl'
  });
}])

.controller('UserCenterCtrl', function($scope) {

      $scope._items =
      [
        {"Item": {
            "title": "apple",
            "description": "7",
            "status": "1",
            "imgAddr": "http://lorempixel.com/850/850/?random=124"
          }},
        {"Item": {
            "title": "pear",
            "description": "7",
            "status": "1",
            "imgAddr": "http://lorempixel.com/850/850/?random=125"
          }},

        {"Item": {
          "title": "peach",
          "description": "7",
          "status": "1",
          "imgAddr": "http://lorempixel.com/850/850/?random=128"
        }}
      ];

      //$scope.isActive = function(item) {
      //  for(var i=0; i < user.User.Stats.length; i++){
      //    return user.User.Stats[i].active === "1";
      //  }
      //};

      $scope.name = 'World';
      $scope.getName = function() {
        return $scope.name;
      };
});