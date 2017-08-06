ngular.module('myApp');

$scope.GetAllUsers = function() {

    $http.get('getAllUsers')
      .then(function(jaundice) {
        console.log(jaundice);
      });
  };