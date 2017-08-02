app.service('chartService', function($http){
	
	this.getChart = function(callback){
		$http.get('chart').then(callback)
	}
	
});