/**
 * 
 */

app.controller('getUserCtrl', function($scope, $http) {
	
	$scope.users = [];
	
	$http.get('getAllUsers')
	
    .then(function(response) {
      $scope.users = response.data; 
	
    })

	
	
});