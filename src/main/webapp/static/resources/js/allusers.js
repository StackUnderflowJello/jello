angular.module('myApp')

.controller('alluserscontroller', function($scope, $http) {

$scope.GetAllUsers = function() {

    $http.get('getAllUsers')
      .then(function(users) {
        console.log(users);
      });
  };
});