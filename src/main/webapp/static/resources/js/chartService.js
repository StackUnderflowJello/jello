app.service('chartService', function($http){
	
	this.getChart = function(callback, $exceptionHandler){
		$http.get('chart')
		.then(callback)
		.catch(function(error){	
			console.log(error);
		})
	}
	
});