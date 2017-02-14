var LoginController;
app.controller('LoginController', function($scope,$http,$rootScope,$location,$window) {

	$rootScope.showMenu = null;
	if ($rootScope.isLocalStorageAvailable()) {
		delete $window.sessionStorage.showMenu;
	}
    $scope.login = function() {
    	var config = { 
    			headers: {
    				'language': $rootScope.language
        	}
    	};
    	if (!$scope.request) {
    		$scope.request = {};
    	}
    	 var responsePromise = $http.post(endPoint + "user/login",$scope.request,config);
         responsePromise.success(function(data, status, headers, config) {
        	 if (data.status == "ok") {
             	$rootScope.userName = $scope.request.userName;
             	$rootScope.token = data.sessionToken;
             	if (!$rootScope.language) {
                 	$rootScope.language = "E";
        	 	}
    			$rootScope.showMenu = true;
    			
            	if ($rootScope.isLocalStorageAvailable()) {
	             	$window.sessionStorage.userName =  $scope.request.userName;
	             	$window.sessionStorage.token =  data.sessionToken;
	                $window.sessionStorage.language = $rootScope.language;
	             	$window.sessionStorage.showMenu = true;
            	}
             	
   	            $location.path("/home");
             	
        	 } else {
        		alert ($rootScope.getTranslateMsg(data.errMsg));
        	 }
         });
         responsePromise.error(function(data, status, headers, config) {
        	 // alert("AJAX Fail!");
         });
    };
    
    
	 
});

var LogoutController;
app.controller('LogoutController', function($rootScope, $scope,$http,$rootScope, $window) {
    $scope.init = function() {
    	$rootScope.showMenu = false;
     	$rootScope.userName = "";
     	$rootScope.token = "";

    	if ($rootScope.isLocalStorageAvailable()) {
			delete $window.sessionStorage.showMenu;
			delete $window.sessionStorage.userName;
			delete $window.sessionStorage.token;
    	}
    };
    $scope.init();
});


