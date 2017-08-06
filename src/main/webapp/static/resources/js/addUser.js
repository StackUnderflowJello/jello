/**
 * 
 */
app.controller('addUserCtrl', function($scope, $http) {
	//add User to board
	
	var user = {
			"email": "tom"
	}
	
	/*$scope.viewUsers = function(){
		$http.get('users')
	      .then(function(info) {
	        $scope.name = info.data.name;
	        $scope.height = info.data.height;
	        $scope.mass = info.data.mass;
	}*/
	$scope.addUser = function(){
		console.log("Add User")
//		email["email"] = $scope.email;
		console.log(angular.toJson(user));
		
		 var config = {
		    headers: {
			    'Content-Type': 'application/json;'
		    }
		 }
		 
		 $http.post('addUser', user, config)
     	.then(
     		function (response) {
     			console.log("Posting" + response);
     		},
     		function(response){
     	 		console.log("failure");
     		}
     	);
	
	}

	/*
	if(r_id == 2) 
	{
		$scope.addUser = true;
		//document.getElementById('addUserBtn').style.display = block;
	} else if (r_id == 1){
		
		$scope.addUser = false;
		//document.getElementById('addUserBtn').style.display = none;
	}*/
	
	
});