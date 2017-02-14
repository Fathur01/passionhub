/*dyo created*/
var ViewPassionController;
app.controller('ViewPassionController', function($scope, $route, $routeParams,
		$location, $http, $rootScope, $window) {
	$scope.passionList = [];
	$rootScope.showSubMenu = true;
	$scope.search = function() {
		var config = {
			headers : {
				'userName' : $rootScope.userName,
				'token' : $rootScope.token,
				'language' : $rootScope.language
			}
		};
		
			var responsePromise = $http.post(endPoint + "/passion/view", null,
					config);

			responsePromise.success(function(data, status, headers, config) {
				if (data.status == "ok") {
					$scope.passionListSrc = data.passionList;
					$scope.passionList = [].concat($scope.passionListSrc);
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


