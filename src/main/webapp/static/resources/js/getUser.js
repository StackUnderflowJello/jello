/**
 * 
 */

app.controller('getUserCtrl', function($scope, $http) {
	
	$scope.users = [];
	
	$http.get('getAllUsers')
	
    .then(function(info) {
      $scope.email = info.data.email; 
	
    })

	
	
});