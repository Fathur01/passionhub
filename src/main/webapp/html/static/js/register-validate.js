var RegisterValidateController;
app.controller('RegisterValidateController', 
		     [ '$scope', '$http', '$timeout', '$compile', 'Upload', 
		       '$rootScope', '$location', '$window',
		       function($scope, $http, $timeout, $compile, Upload, $rootScope, $location, $window) 
{		

	$scope.init = function() {
		if($window.sessionStorage.getItem("errMsg") != null){
			$scope.errMsg = $window.sessionStorage.getItem("errMsg");
		}
		$window.sessionStorage.removeItem("errMsg");
		//$window.sessionStorage.clear();
	}
	$scope.init();
	
    $scope.validate = function() {
    	if (!$scope.request) {
    		alert("Invalid Information");
    		return false;
    	}
    	 var config = { 
	     			headers: {
	     				'language': $rootScope.language
	         	}
	     	};

	 	$scope.request.dateOfBirth = $rootScope.getDateFromInputString($('#dateOfBirth').val());
    	 var responsePromise = $http.post(endPoint + "user/validate",$scope.request,config);
         responsePromise.success(function(data, status, headers, config) {
        	 if (data.status == "ok") {
              	$location.path("/register_before_activate");
        	 } else {
        		alert ($rootScope.getTranslateMsg(data.errMsg));
        	 }
         });
         responsePromise.error(function(data, status, headers, config) {
        	 // alert("AJAX Fail!");
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

	    var formats = ['dd/MM/yyyy', 'dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
	    method.format = formats[0];
	   
	    return method;
	}());
	
} ]);

