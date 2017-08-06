angular.module('myApp');

app.controller("loginController", function($scope, $http) {

  window.onload = function() {
    var user = getUser();
    if(user != null) {
      $scope.hideModal();
    }
  }
  
  var val_email = "";
  var val_password = "";
  var regUsername = "";
  var regPassword = "";
  var firstname = "";
  var lastname = "";
  
  $scope.username = 'eh';
  $scope.password = 'yeah';


  $scope.login = function() {
    
    	var qeueUser = {
    	    u_email : $scope.username,
    	    u_password : $scope.password
        }
        
    	var config = {
        	headers: {
        		'Content-Type' : 'application/json;'
        	}
        }
        
        $http.post('loginUser', qeueUser, config)
        	.then(
        		function(response) {
        			console.log("Good");
        			$('.login').css('display', 'none');
        			$('.modal-button').css('display', 'none');
        			$scope.hideModal();
        			setUser($scope.username);
        		},
        		function(){
        			console.log("Invalid Credentials!")
        		}
        )
  };

  $scope.register = function() {

    var newUser = {
	    regEmail : $scope.regEmail,
	    regPassword : $scope.regPassword
    }
    
    var config = {
    	headers: {
    		'Content-Type' : 'application/json;'
    	}
    }
    
    $http.post('registerUser', newUser, config)
    	.then(
    		function(response) {
    			console.log("Posting" + response);
    		},
    		function(response){
    			console.log("FAILURE")
    		}
    );
    

    console.log($scope.regEmail + " " + regPassword + " " + firstname + " " + lastname);
    }

  $scope.hideModal = function() {
    $("#loginModal").css("display", "none");
  }

  $scope.showLogin = function() {
    $(".register-body").css("display", "none");
    $("#register-header").css("display", "none");
    $(".login-body").css("display", "block");
    $("#login-header").css("display", "block");
    $("#showRegister").css("display", "block");
    $("#register").css("display", "none");
    $("#login-trigger").css("display", "block");
    $("#showLogin").css("display", "none");
  }

$scope.showRegister = function() {
    $(".register-body").css("display", "block");
    $(".login-body").css("display", "none");
    $("#login-header").css("display", "none");
    $("#register-header").css("display", "block");
    $("#showRegister").css("display", "none");
    $("#register").css("display", "block");
    $("#login-trigger").css("display", "none");
    $("#showLogin").css("display", "block");
  }


});


function setUser(user){

  var funcObject = {"user" : user};
  
  console.log("Storing User in localStorage: " + user);

  // Put the object into storage
  localStorage.setItem('Session', JSON.stringify(funcObject));
}

function getUser() {
  
  var retrievedObject = localStorage.getItem("Session");
  if(retrievedObject != null) {
    var parsed = JSON.parse(retrievedObject);
    console.log(parsed["user"]);
    
    return parsed["user"];
  }
}
