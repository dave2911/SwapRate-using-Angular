
myApp.factory('mainInfo', function($http,$q) { 
    
    var factory = {}; 
  
    factory.readCurrent = function($link) {
        var deferred = $q.defer();
        $http({
            method: 'get', 
            url: $link
        })
        .then(function (response) 
        {
            console.log(response, 'res');
            data = response.data;
            deferred.resolve(data);
        }/*,function (error){
            console.log(error, 'can not get data.');
        }*/);
        return deferred.promise;   
    }                           
     return factory;
});
