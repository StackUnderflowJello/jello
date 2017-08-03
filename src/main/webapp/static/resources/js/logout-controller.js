/**
 * 
 */

app.controller('logoutController', function($scope) {
	$scope.logout = function() {
	    localStorage.clear();
	    console.log("Storage cleared.");
	    alert("Successfully logged out.");
	     location.reload();
	  }
});