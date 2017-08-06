/**
 * 
 */

app.controller('logoutController', function($scope, $http) {
	$scope.logout = function() {
			  
		        
		$http.post("logoutUser")
			.then(
					function(response) {
		        		console.log("Logged Out");
		        		localStorage.clear();
		        	    console.log("Storage cleared.");
		        	    alert("Successfully logged out.");
		        	    location.reload();
		        	},
		        	function(){
		        		console.log("Not Logged Out");
		        	})
			}
	});