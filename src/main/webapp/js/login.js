var app = angular.module("app", []);

app.controller("HttpGetController", function($scope, $http) {

  $scope.keyword = '';

  $scope.GetAllData = function() {
    $("#pokemessage").css("display", "block");
    setTimeout(function(){
     $("#pokemessage").css("display", "none");
    }, 2000);
    $http.get('http://pokeapi.co/api/v2/pokemon/' + $scope.keyword)
      .then(function(jaundice) {
        $scope.name = jaundice.data.name;
        $scope.height = jaundice.data.height;
        $scope.id = jaundice.data.id;
      });
  };

  $scope.logout = function() {
    localStorage.clear();
    console.log("Storage cleared.");
    alert("Successfully logged out.");
     location.reload();
  }

});

app.controller("powerController", function($scope) {

  window.onload = function() {
    var user = getUser();
    if(user != null) {
      $scope.hideModal();
      $('.pokesearch').css("display", "block");
    }
  }
  
  var username = "stackunderflow";
  var password = "123";
   var regUsername = "";
    var regPassword = "";
    var firstname = "";
    var lastname = "";
  
  $scope.username = '';
  $scope.password = '';


  $scope.login = function() {
    console.log($scope.username);
    if($scope.username === username && $scope.password === password) {
      $(".pokesearch").css("display", "block");
      $('.login').css('display', 'none');
      $('.modal-button').css('display', 'none');
      $scope.hideModal();
      setUser($scope.username);
    }
  };

  $scope.register = function() {

    regUsername = $scope.regUsername;
    regPassword = $scope.regPassword;
    firstname = $scope.firstname;
    lastname = $scope.lastname;

    console.log($scope.regUsername + " " + regPassword + " " + firstname + " " + lastname);
    } 

  $scope.hideModal = function() {
    $("#myModal").css("display", "none");
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

// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal 
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks anywhere outside of the modal, close it
//window.onclick = function(event) {
  //  if (event.target == modal) {
    //    modal.style.display = "none";
    //}
//}