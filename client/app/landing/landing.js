'use strict';

angular.module('tradeNow.landing', ['ngRoute','firebase'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/signin', {
    templateUrl: 'landing/landing.tpl.html',
    controller: 'LandingController'
  });
}]).
controller('LandingController', ["$scope","$firebase","$location","$route",function($scope,$firebase,$location,$route) {

      //email login
      $scope.email = "";
      $scope.password = "";

      //email authentication
      $scope.emailLogin = function (event) {
        event.preventDefault();
        console.log("email Login");

        var ref = new Firebase("https://tradeNow.firebaseio.com");
        ref.authWithPassword({
              email: "judezhu.hust@gmail.com",
              password: "12345"
            },
            function (error, authData) {
              if (error) {
                console.log("Login Failed!", error);
              } else {
                console.log("Authenticated successfully with payload:", authData);
                  $scope.$apply( function() {
                      $location.path('/homepage');
                  });
              }
            });

      };

      //facebook login
      $scope.facebookLogin = function (event) {
        event.preventDefault();
        var ref = new Firebase("https://tradenow.firebaseio.com/");

        ref.authWithOAuthPopup("twitter", function (error, authData) {
          if (error) {
            console.log("Login Failed!", error);

          } else {
              console.log("Authenticated successfully with payload:", authData);
              $scope.$apply( function() {
                  $location.path('/homepage');
              });
          }
        });
      };

      // toggle sign up and signin
      var ifSignin = true;

      $scope.checkIfSignin = function()
      {
          return ifSignin;
      }

      $scope.toggleSignin = function()
      {
          if(ifSignin)
          {
              ifSignin = false;
          }
          else
          {
              ifSignin = true;
          }
      }
}]);