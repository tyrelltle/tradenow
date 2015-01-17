'use strict';

angular.module('myApp.view1', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/homepage', {
    templateUrl: 'homepage/homepage.tpl.html',
    controller: 'View1Ctrl'
  });
}])

.controller('View1Ctrl', function($scope) {

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