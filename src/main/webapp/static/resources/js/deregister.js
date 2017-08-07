/**
 * 
 */

angular.module('myApp')

.controller("deregisterController", function($scope, $http, $window) {

 $scope.deRegister = function() {
	  var currentUser = {
			  email : getUser()
	  }
	  
	  var config = {
	        	headers: {
	        		'Content-Type' : 'application/json;'
	        	}
	        }
	  
	  $http.post('deRegister', currentUser, config)
	  	.then(
	  		function(response) {
	  			console.log("Account deleted")
	  			localStorage.clear();
	  			alert("Your account has been deleted.");
        	    location.reload();
	  		},
	  		function(){
	  			console.log("Account not deleted?!")
	  		})
	  		$window.location.href = '#!/home';
  
 
 	}
 
 $scope.redirect = function() {
	 $window.location.href = '#!/home';
 }

});


function getUser() {
	  
	  var retrievedObject = localStorage.getItem("Session");
	  if(retrievedObject != null) {
	    var parsed = JSON.parse(retrievedObject);
	    console.log(parsed["user"]);
	    
	    return parsed["user"];
	  }
	}