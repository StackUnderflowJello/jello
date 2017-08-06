app.controller('remUserCtrl', function($scope, $http) {
	//Remove User from board
	
	var user = {
			"email": "tom"
	}
	
	$scope.removeUser = function(){
		console.log("Remove User")
//		email["email"] = $scope.email;
		console.log(angular.toJson(user));
		
		 var config = {
		    headers: {
			    'Content-Type': 'application/json;'
		    }
		 }
		 
		 $http.post('removeUser', user, config)
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
		$scope.remUser = true;
		//document.getElementById('rmUserBtn').style.display = block;
	} else if (r_id == 1){
		
		$scope.remUser = false;
		//document.getElementById('rmUserBtn').style.display = none;
	}*/
	
	
});