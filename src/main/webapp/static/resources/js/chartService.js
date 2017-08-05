app.service('chartService', function($http){
	
	this.getChart = function(callback, $exceptionHandler){
		$http.get('static/chart')
		.then(callback)
		.catch(function(error){	
			console.log(error);
		})
	}
	
});