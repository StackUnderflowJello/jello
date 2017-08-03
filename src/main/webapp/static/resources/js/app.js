/**
 * AngularJS App
 */

var app = angular.module('myApp', ['ngRoute']) //[] tells angular to create a project with the name passed in
											//not providing the [] will tell angular one already exists
 

app.config(function($routeProvider){
	
	$routeProvider
		.when("/", {
			templateUrl: "fragments/scrumboard.html"
		})
		
		.when("/scrumboard", {
			templateUrl: "fragments/scrumboard.html"
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

var dragApp = angular.module('ExampleApp', ['btford.dragon-drop']).
controller('dragCtrl', function ($scope) {
  $scope.things = ['one', 'two', 'three'];
  $scope.otherThings = [];
});