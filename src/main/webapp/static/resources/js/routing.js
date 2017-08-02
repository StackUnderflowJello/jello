/**
 * AngularJS App
 */

var app = angular.module('myApp', ['ngRoute']) //[] tells angular to create a project with the name passed in
											//not providing the [] will tell angular one already exists
app.config(function($routeProvider){
	
	$routeProvider
		.when("/", {
			templateUrl: "features/fragments/stand.html"
		})
		
		.when("/standup", {
			templateUrl: "features/fragments/stand.html"
		
		})
		
		.when("/burndown", {
			templateUrl: "features/fragments/burndown.html"
			
		})
		
		.when("/members", {
			templateUrl: "features/fragments/members.html"
			
		})
		
		.otherwise({
			redirectTo: "/"
		});
	
});
