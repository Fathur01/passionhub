/*dyo created*/
var UploadAffinityMomentController;
app.controller('UploadAffinityMomentController', function($scope, $route, $routeParams,
		$location, $http, $rootScope, $window,Upload) {
	$scope.submitFiles = [];
	$scope.submitFileMap = {};
	$rootScope.showSubMenu = true;
	$scope.submitShow = false;
	$scope.choiceFiles = function() {
		$scope.submitShow = true;
    };
	$scope.uploadFiles = function(fileId, file/*, errFiles*/) {
        $scope.files = file;
/*        $scope.errFiles = errFiles;*/
        file.upload = Upload.upload({
            	url: endPoint + "affinity/upload",// + $scope.getReqParams(),
    			method: 'POST',
    			headers: {
    				'userName' : $rootScope.userName,
    				'token' : $rootScope.token,
    				'language': $rootScope.language
    			},
    			file: file,
    			fileFormDataName: 'file'
            });
            
        file.upload.success(function(data, status, headers, config) {
				if (data.status == "ok") {
					alert("Upload Sukses");
				} else {
					alert($rootScope.getTranslateMsg(data.errMsg));
				}
			});
        file.upload.error(function(data, status, headers, config) {
				// alert("AJAX failed!");
				alert("Please Login Again");
			});

            /*file.upload.then(function (response) {
            	alert("masuk");
                $timeout(function () {                	
                	file.result = response.data;
    				$scope.submitFiles.push( {
    					fileId : fileId,
    					fileRefNo : file.result.fileId
    				});
    				$scope.submitFileMap[fileId] = file.name;
                });
            }, function (response) {
            	alert("masuk salah");
                if (response.status > 0)
                    $scope.errorMsg = response.status + ': ' + response.data;
            }, function (evt) {
            	alert(evt.loaded + " "+evt.total);
                file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
            });*/
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


