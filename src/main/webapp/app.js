/**
 * 
 */

var app = angular.module('myApp', ['ngRoute']); //[] tells angular to create a project with the name passed in
											//not providing the [] will tell angular one already exists



app.config(function($routeProvider){
	console.log('routing');
	$routeProvider
		.when("/", {
			templateUrl: "fragments/stand.html"
		})	
		
		.when("/standup", {
			templateUrl: "fragments/stand.html"
		
		})
		
		.when("/burndown", {
			templateUrl: "fragments/burndown.html"
			
		})
		
		.when("/members", {
			templateUrl: "fragments/members.html"
			
		})
		
		.otherwise({
			redirectTo: "/"
		});
		
				
	
	
});