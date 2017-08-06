/**
 * 
 */

app.service('addUserService', function($http){
	
	this.getChart = function(callback){
		$http.get('addUser')
		.then(callback)
	}
	
});