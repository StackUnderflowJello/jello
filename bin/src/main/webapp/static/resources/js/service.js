app.service('chartService', function($http){
	
	this.getChart = function(callback){
		$http.get('static/chart')
		.then(callback)
		.catch(function(error){
			
			return errorService.handleError(error);
			
		})
	}
	
});

/*app.service('addJelloService', function(){
	this.
})*/