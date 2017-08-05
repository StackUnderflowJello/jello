/**
 * AngularJS App
 */

var app = angular.module('myApp', ['ngRoute', 'demo']) //[] tells angular to create a project with the name passed in
											//not providing the [] will tell angular one already exists
 

app.config(function($routeProvider){
	
	$routeProvider
		.when("/", {
			templateUrl: "static/fragments/scrumboard.html"
		})
		
		.when("/scrumboard", {
			templateUrl: "static/fragments/scrumboard.html"
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

var dragApp = angular.module('ExampleApp', ['btford.dragon-drop']).
controller('dragCtrl', function ($scope) {
  $scope.things = ['one', 'two', 'three'];
  $scope.otherThings = [];
});