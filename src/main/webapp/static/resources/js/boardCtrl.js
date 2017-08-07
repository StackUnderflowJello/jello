app.controller('boardsCtrl', function($scope, $http){
	$scope.chooseBoard = true;
	$scope.boards = {};
	$http.get('getBoards')
	.then(function(response){
		$scope.boards = response.data;
	})
})