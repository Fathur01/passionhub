/*dyo created*/
var InputTrPointController;
app.controller('InputTrPointController', function($scope, $route, $routeParams,
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
				point : $scope.request_point,
				activityDate:$scope.request_activityDate
				
		};
		var responsePromise = $http.post(endPoint + "/trPoint/save",request,config);

		 responsePromise.success(function(data, status, headers, config) {
	    	 if (data.status == "ok") {
	 			$location.path("/viewTrPoint");
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


