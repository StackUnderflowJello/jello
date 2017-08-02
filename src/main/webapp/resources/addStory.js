/**
 * 
 */

var app = angular.module('myApp', []);

app.controller('myCtrl', function($scope, $http) {
//    var counter = 0;
    $scope.elements = [{value:''}];
    
    var story = {
        "story_name": this.story_name, 
        "points": $scope.points,
        "task": $scope.elements
    }
    
    $scope.addTask = function(){
        $scope.elements.push({value:''});
    }
    
    $scope.submit = function(){
        console.log("Submitted");
        story["story_name"] = $scope.story_name;
        story["points"] = $scope.points;
        console.log(angular.toJson(story));
        
        $http.post("/addStory", story).then(function(){
            console.log("Posting");
        })
        
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