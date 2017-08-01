var app = angular.module('myApp', []);

app.controller('myCtrl', function($scope, $http) {

	$scope.elements = [{value:''}];
    
//    var story = {
//        "story_name": this.story_name, 
//        "points": $scope.points,
//        "task": $scope.elements
//    }
    
    $scope.addTask = function(){
        $scope.elements.push({value:''});
    }
    
    $scope.submit = function(){
    	
    	var story = {
    	        "story_name": this.story_name, 
    	        "points": $scope.points,
    	        "task": $scope.elements
    	}
    	
        console.log("Submitted");
        story["story_name"] = $scope.story_name;
        story["points"] = $scope.points;
        console.log(angular.toJson(story));
        
        var config = {
        		headers: {
        			'Content-Type': 'application/json;'
        		}
        }
        
        $http.post('add', story, config)
        	.then(
        		function (response) {
        			console.log("Posting" + response);
        		},
        		function(response){
        	 		console.log("failure");
        		}
        );
        
        //need to reset elements from form
        $scope.elements = [{value:''}];
        
    }
})

//reset modal form after close
$(document).ready(function() {
  $(".modal").on("hidden.bs.modal", function() {
     $(this).find('form').trigger('reset');
  });
});

