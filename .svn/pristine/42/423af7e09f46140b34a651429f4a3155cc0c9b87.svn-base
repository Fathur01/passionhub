/*dyo created*/
var ViewTrPointController;
app.controller('ViewTrPointController', function($scope, $route, $routeParams,
		$location, $http, $rootScope, $window) {
	$scope.trPointList = [];
	$rootScope.showSubMenu = true;
	$scope.search = function() {
		var config = {
			headers : {
				'userName' : $rootScope.userName,
				'token' : $rootScope.token,
				'language' : $rootScope.language
			}
		};
		
			var responsePromise = $http.post(endPoint + "/trPoint/view", null,
					config);

			responsePromise.success(function(data, status, headers, config) {
				if (data.status == "ok") {
					$scope.trPointListSrc = data.trPointList;
					$scope.trPointList = [].concat($scope.trPointListSrc);
				} else {
					alert($rootScope.getTranslateMsg(data.errMsg));
				}
			});
			responsePromise.error(function(data, status, headers, config) {
				// alert("AJAX failed!");
				alert("Please Login Again");
			});
	};
	
	
	$scope.init = function() {

		if ($rootScope.userName === undefined || $rootScope.userName == "" || $rootScope.token === undefined || $rootScope.token == ""   ) {
			$location.path("/login");
			return;
		}

		$scope.search();
	};
	
	$scope.init();
});


