/**
 * AngularJS App
 */

var app = angular.module('myApp', ['ngRoute']) //[] tells angular to create a project with the name passed in
											//not providing the [] will tell angular one already exists



app.config(function($routeProvider){
	
	$routeProvider
		.when("/", {
			templateUrl: "static/fragments/stand.html"
		})
		
		.when("/standup", {
			templateUrl: "static/fragments/stand.html"
		
		})
		
		.when("/burndown", {
			templateUrl: "static/fragments/burndown.html"
			
		})
		
		.when("/members", {
			templateUrl: "static/fragments/members.html"
			
		})
		
		.otherwise({
			redirectTo: "/"
		});
		
				
	
	
});