/**
 * 
 */

app.service('remUserService', function($http){
	
	this.getChart = function(callback){
		$http.get('removeUser')
		.then(callback)
	}
	
});