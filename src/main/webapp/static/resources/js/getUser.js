/**
 * getUsers.js
 */

app.controller('getUserCtrl', function($scope, $http) {
	
	
	$scope.users = {};
	
	$http.get('getAllUsers')
	
    .then(function(response) {
      $scope.users = response.data;
    })

    
	

}); 





/*app.controller('MyCtrl', function MyCtrl($scope)

 {
    $scope.items = [{
        Name: "Soap",
        Price: "25",
        Quantity: "10"
    }, {
        Name: "Bag",
        Price: "100",
        Quantity: "15"
    }, {
        Name: "Pen",
        Price: "15",
        Quantity: "13"
    }];
});
*/

