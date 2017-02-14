<!DOCTYPE HTML>

<html ng-app="eEB">
<head>
<base href="../../html/">

<title>Page Redirection</title>

<script src="static/plugin/angular.min.js"></script>
<script src="static/plugin/angular-route.js"></script>
<script src="static/plugin/angular-cookies.js"></script>
<script src="static/plugin/angular-resource.js"></script>
<!-- translate -->
<script src="static/plugin/angular-translate.js" type="text/javascript"></script>

<script src="static/js/lib/ui-grid-unstable.js" type="text/javascript" ></script>
<script src="static/js/lib/smart-table.js" type="text/javascript" ></script>
<script src="static/js/lib/ui-bootstrap-tpls-0.13.0.js" type="text/javascript"></script>
<script src="static/js/lib/loading-bar.min.js"></script>
<script src="static/js/lib/angular-animate.min.js"></script>
<script src="static/js/eEB.js"></script>
<script src="static/js/register-validate.js"></script>
<script src="static/js/lib/ng-file-upload-shim.js"></script>
<script src="static/js/lib/ng-file-upload.js"></script>
 
<script type="text/javascript">

app.controller('RouterController', function($scope,$http,$rootScope,$location,$window) {
	$scope.init = function() {
		// clear all sessionStorage after display
		
    	if ($rootScope.isLocalStorageAvailable()) {
			// registration error message
			$window.sessionStorage.setItem("errMsg", "<%=request.getAttribute("error")%>");
			// do memebership registration
			$window.sessionStorage.setItem("token", "<%=request.getAttribute("token")%>");
			$window.sessionStorage.setItem("clientCode", "<%=request.getAttribute("client_code")%>");
			// other if have
    	} else {
    		alert('Your web browser does not support storing settings locally. In Safari, the most common cause of this is using "Private Browsing Mode". Some settings may not save or some features may not work properly for you.');
        }
		// redirect
		$window.location.href= "<%=request.getContextPath() + request.getAttribute("route_target")%>"; 
	}
	$scope.init();
    $scope.register = function() {
    };
});

</script> 

</head>
<body>
    
<section class="content"  ng-controller="RouterController">
</section>

</body>
</html>
