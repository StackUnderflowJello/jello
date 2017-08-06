angular.module('myApp');

app.controller('addStoryCtrl', function($scope, $http) {

	
	$scope.elements = [{value:''}];
	
	
	
//    var story = {
//        "story_name": this.story_name, 
//        "points": $scope.points,
//        "task": $scope.elements
//    }
    
    $scope.addTask = function(){
        $scope.elements.push({value:''});
    }
    
    //adding jello to lane
    $scope.addJello = function(){
    	console.log('Adding jello');
    	
    	//console.log('This is from addJello() - ' + story);
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
        temp = story;
        
        var config = {
        		headers: {
        			'Content-Type': 'application/json;'
        		}
        }
        
        $http.post('addStory', story, config)
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

app.controller('addBoardCtrl', function($scope, $http) {
    
    var board = {
        "board_name": this.story_name
    }
    
    $scope.submit = function(){
        console.log("Submitted");
        board["board_name"] = $scope.board_name;
        console.log(angular.toJson(board));
        
       var config = {
        headers: {
            'Content-Type': 'application/json;'
        }
       }
        
        $http.post('addBoard', board, config)
        	.then(
        		function (response) {
        			console.log("Posting" + response);
        		},
        		function(response){
        	 		console.log("failure");
        		}
        );
        
//        $http({
//            url: '/addStory',
//            method: "POST",
//            data: angular.toJson(story),
//            headers: {'Content-Type': 'application/json'}
//        }).success(function (data, status, headers, config) {
//            console.log("Success");
//        }).error(function (data, status, headers, config) {
//            console.log("Failure");
//        });
    }
})




	app.controller('MainCtrl', function ($scope) {
	    $scope.onDragComplete=function(data,evt){
	       console.log("drag success, data:", data);
	    }
	    $scope.onDropComplete=function(data,evt){
	        console.log("drop success, data:", data);
	    }
	 });

/*Create draggable cards */
app.controller('cardCtrl', function($scope){
	$scope.count = 0;

}
)

//Directive that returns an element which adds buttons on click which show an alert on click
	app.directive("addbuttonsbutton", function(){
	return {
		restrict: "E",
		template: "<button addbuttons>Click to add buttons</button>"
	}
});

//Directive for adding buttons on click that show an alert on click
	app.directive("addbuttons", function($compile){
	return function(scope, element, attrs){
		element.bind("click", function(){
			scope.count++;
			angular.element(document.getElementById('space-for-buttons')).append($compile("<div class='draggable' ng-drag='true' ng-drag-data='{obj}' ng-drag-success='onDragComplete($data,$event)' ng-center-anchor='true' draggable='true'> Draggable div</div>")(scope));
			console.log('it worked');
		});
	};
});
	







