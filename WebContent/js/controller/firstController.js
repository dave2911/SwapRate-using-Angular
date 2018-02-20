var myApp  =  angular.module('myApp', ["ngRoute"])
.config(function($routeProvider) {
    $routeProvider
.when("/login", {
        templateUrl : "html/login.html",
        controller : "firstCtrl"
    })
 .when("/second",{
 		templateUrl : "html/second.html",
 		controller : "updateController"
 	})
// .when("/link", {
//         templateUrl : "../html/link.html",
//         controller : "thirdCtrl"
//     })
.when("/current", {
        templateUrl : "html/current.html",
        controller : "displayController"
    })
//.when("/create", {
  //      templateUrl : "../html/second.html",
      //  controller : "displayController"
    //})
.when("/update", {
        templateUrl : "html/second.html",
        controller : "displayController"
    })
.when("/view", {
        templateUrl : "html/view.html",
        controller : "formController"
    })
.otherwise({redirectTo:"/login"})
	})
.controller("firstCtrl", function($scope, $location,mainInfo) {
    $scope.basicForm = {};
    $scope.submitForm=function(){
        $location.path('/second');
        }
 $scope.submitForm = function (credentials) {
    var user=credentials.username;
    var pass=credentials.password;
    $link="http://localhost:8002/sim/rest/user/login?username="+user+"&pass="+pass;
    mainInfo.readCurrent($link).then(function(data) {  
        alert(data.status);
    });
    $location.path('/second');
 }
})
.controller('displayController', function($scope,mainInfo){
    console.log('displayController');
   mainInfo.readCurrent('http://localhost:8002/sim/rest/rate/current').then(function(data) {  
        $scope.rss = 
         data; 
        console.log(data);
    });

})
.controller('updateController',function($scope,$window,$location,mainInfo){
	$scope.credentials={};
	 $scope.greeting = 'Updated Successfully';
	$scope.submitForm=function(greeting ){
		
		var dt=moment(Date.parse($scope.credentials.date)).format("YYYY-MM-DD");
		console.log(dt);
		var inr=$scope.credentials.inr;
		var aus=$scope.credentials.aus;
		var eur=$scope.credentials.eur;
		var cad=$scope.credentials.cad;
		$link="http://localhost:8002/sim/rest/rate/update?inr="+inr+"&aus="+aus+"&eur="+eur+"&cad="+cad+"&dt="+dt;
		 $window.alert(greeting);
		mainInfo.readCurrent($link).then(function(data) {
		    $scope.history=data;
		   
		  
		   });
		 document.getElementById("myForm").reset();
		
	   

	}
})
.controller("formController",function($scope,$http,mainInfo){
   mainInfo.readCurrent('http://localhost:8002/sim/rest/rate/allrate').then(function(data) {
    $scope.history=data;
    console.log(data);
    $scope.saveJSON = function () {
		var fileName='history.json';
		var fileToSave=new Blob([JSON.stringify($scope.history)],{
			type:'application.json',
			name:fileName
		});
		saveAs(fileToSave,fileName);
    }
    
    $scope.history=data
   $scope.saveCsv = function () {
           
         $scope.history =data;
         var dataToExport=[];
         $scope.history.forEach(function(dataPt,$index)
        		 {
        	 dataToExport.push({
        		 "Date":dataPt.date,
        		 "Last Updated":dataPt.last_updated,
        		 "INR":dataPt.rates.inr,
        		 "AUS":dataPt.rates.aus,
        		 "EUR":dataPt.rates.eur,
        		 "CAD":dataPt.rates.cad,
        	 })
        	 if($index==$scope.history.length-1)
        		 {
        		 alasql('SELECT * INTO CSV("history.csv",{headers:true,separator:","}) FROM ?',[dataToExport]);
        		 }
        		 });
    
    } });


   
   $scope.jsonDownload=$scope.history;
});
myApp.$inject = ['$scope'];



// .controller("secondCtrl", function ($scope) {
//     $scope.msg = "LINK";

// })
// .controller("thirdCtrl", function ($scope) {
//     $scope.msg = "LINK";

// });