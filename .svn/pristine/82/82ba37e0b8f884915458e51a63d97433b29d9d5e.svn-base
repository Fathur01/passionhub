/*dyo created*/
var InputUsersController;
app.controller('InputUsersController', function($scope, $route, $routeParams,
		$location, $http, $rootScope, $window) {
	$rootScope.showSubMenu = true;
	$scope.submit = function() {
		var config = {
			headers : {
				'userName' : $rootScope.userName,
				'token' : $rootScope.token,
				'language' : $rootScope.language

			}
		};
		var request = {
				userId : $scope.request_userId,
				roleCode : $scope.request_roleCode,
				status : $scope.request_status
				
		};
		var responsePromise = $http.post(endPoint + "/users/save",request,config);

		 responsePromise.success(function(data, status, headers, config) {
	    	 if (data.status == "ok") {
	 			$location.path("/viewUsers");
				location.reload();
	    	 } else {
	     		alert ($rootScope.getTranslateMsg(data.errMsg));
	     	 }
	     });
			
			responsePromise.error(function(data, status, headers, config) {
				alert("Fail to connect to server!");
			});
	};
	
	$scope.init = function() {

		if ($rootScope.userName === undefined || $rootScope.userName == "" || $rootScope.token === undefined || $rootScope.token == ""   ) {
			$location.path("/login");
			return;
		}


		$scope.isFinish = false;
		
	
	};
	    
	$scope.init();
});


