/*dyo created*/
var InputMemberController;
app.controller('InputMemberController', function($scope, $route, $routeParams,
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
				firstName : $scope.request_firstName,
				middleName : $scope.request_middleName,
				lastName : $scope.request_lastName,
				surveyDate : $scope.request_surveyDate,
				email : $scope.request_email,
				address : $scope.request_address,
				mobileNo : $scope.request_mobileNo,
				entryDate : $scope.request_entryDate,
				dOB : $scope.request_dOB,
				isPolicyHolder : $scope.request_isPolicyHolder,
				isEmployee : $scope.request_isEmployee,
				isAgent : $scope.request_isAgent,
				groupCode : $scope.request_groupCode,
				isCorpCare : $scope.request_isCorpCare,
				clientCode : $scope.request_clientCode,
				agentCode : $scope.request_agentCode,
				memberStatus : $scope.request_memberStatus,
				useridFk : $scope.request_userDrop,
				password : $scope.request_password
				
		};
		var responsePromise = $http.post(endPoint + "/member/save",request,config);

		 responsePromise.success(function(data, status, headers, config) {
	    	 if (data.status == "ok") {
	 			/*$location.path("/viewMember");*/
				location.reload();
	    	 } else {
	     		alert ($rootScope.getTranslateMsg(data.errMsg));
	     	 }
	     });
			
			responsePromise.error(function(data, status, headers, config) {
				alert("Fail to connect to server!");
			});
	};
	
	$scope.datePicker = (function () 
			{
			    var method = {};
			    method.instances = [];

			    method.open = function ($event, instance) 
			    {
			        $event.preventDefault();
			        $event.stopPropagation();
			        
			        method.instances[instance] = true;
			    };

			    method.options = 
			    {
			        'show-weeks': false,
			        startingDay: 0
			    };

			    var formats = ['dd/MM/yyyy', 'dd-MMMM-yyyy', 'yyyy-MM-dd', 'dd.MM.yyyy', 'shortDate'];
			    method.format = formats[0];
			   
			    return method;
			}());
	
	$scope.init = function() {

		if ($rootScope.userName === undefined || $rootScope.userName == "" || $rootScope.token === undefined || $rootScope.token == ""   ) {
			$location.path("/login");
			return;
		}


		$scope.isFinish = false;
		
	
	};
	    
	$scope.init();
});


