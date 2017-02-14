/*dyo created*/
var InputTrRedeemController;
app.controller('InputTrRedeemController', function($scope, $route, $routeParams,
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
				redeemDate : $scope.request_redeemDate,
				giftId : $scope.request_giftId,
				redeemPoint : $scope.request_redeemPoint,
				balanceId : $scope.request_balanceId,
				historyId : $scope.request_historyId
				
		};
		var responsePromise = $http.post(endPoint + "/trRedeem/save",request,config);

		 responsePromise.success(function(data, status, headers, config) {
	    	 if (data.status == "ok") {
	 			$location.path("/viewTrRedeem");
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


