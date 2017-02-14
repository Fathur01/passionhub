var endPoint = "../";
var version = '4.0.0';

var app = angular.module('eEB', [ 'ngRoute', 'ngCookies', 'ngFileUpload',
		'ui.grid', 'ui.grid.edit', 'ui.grid.rowEdit', 'ui.bootstrap',
		'ui.grid.cellNav', 'ui.grid.pagination', 'pascalprecht.translate',
		'smart-table', 'ngAnimate' ]);

app.directive('datepickerPopup', function() {
	return {
		restrict : 'EAC',
		require : 'ngModel',
		link : function(scope, elem, attrs, ngModel) {
			ngModel.$parsers.push(function toModel(date) {
				// /return date.getFullYear() + '-' + (date.getMonth() + 1) +
				// '-' + date.getDate();
				if (date != null && date != "") {
					return date.getDate().toString().zp(2) + '/'
							+ (date.getMonth() + 1).toString().zp(2) + '/'
							+ date.getFullYear().toString();
				}
			});
		}
	}
});
String.prototype.zp = function(n) {
	return '0'.times(n - this.length) + this;
}
String.prototype.times = function(n) {
	var s = '';
	for (var i = 0; i < n; i++)
		s += this;

	return s;
}

// ajax timer, interceptor - vincent wong
var timestampMarker;
app.factory('timestampMarker', [ function() {
	var timestampMarker = {
		request : function(config) {
			console.log('request URL: ' + config.url);

			config.requestTimestamp = new Date().getTime();
			return config;
		},
		response : function(response) {
			response.config.responseTimestamp = new Date().getTime();

			var time = response.config.responseTimestamp
					- response.config.requestTimestamp;
			console.log('request time: ' + time / 1000 + ' seconds');

			return response;
		}
	};
	return timestampMarker;
} ]);

// ajax error handling, interceptor - vincent wong
var responseErrHandler;
app.factory('responseErrHandler', [ '$q', '$injector', '$location', '$window',
		'$rootScope', function($q, $injector, $location, $window, $rootScope) {
			var responseErrHandler = {
				responseError : function(response) {
					console.log('re: response.status ' + response.status);
					console.log('re: go to home');

					if ($rootScope.isLocalStorageAvailable()) {
						delete $window.sessionStorage.userName;
						delete $window.sessionStorage.token;
						delete $window.sessionStorage.showMenu;
					}
					$location.path("/login");

					return $q.reject(response);
				}
			};
			return responseErrHandler;
		} ]);

var loadingPage = 0;
app.factory('loadingPage', [ '$q', '$injector', '$location', '$window',
		function($q, $injector, $location, $window) {
			return {
				'request' : function(config) {
					loadingPage += 1;
					$('#loadingImage').show();
					return config;
				},

				'requestError' : function(rejection) {
					loadingPage -= 1;
					if (loadingPage <= 0) {
						$('#loadingImage').hide();
					}
					// if (canRecover(rejection)) {
					// return responseOrNewPromise
					// }

					return $q.reject(rejection);
				},

				'response' : function(response) {
					loadingPage -= 1;
					if (loadingPage <= 0) {
						$('#loadingImage').hide();
					}
					return response;
				},

				'responseError' : function(rejection) {
					loadingPage -= 1;
					if (loadingPage <= 0) {
						$('#loadingImage').hide();
					}
					// if (canRecover(rejection)) {
					// return responseOrNewPromise
					// }
					return $q.reject(rejection);
				}
			};
		} ]);

var SearchService;
app.service('SearchService', function($window, $http, $rootScope) {

	this.getMemberNames = function(val) {
		var config = {
			headers : {
				'userName' : $rootScope.userName,
				'token' : $rootScope.token,
				'language' : $rootScope.language
			}
		};

		var raw = {
			memberName : val
		};

		return $http.post(endPoint + "member/search/memberName", raw, config)
				.then(function(response) {
					return response.data.resultList;
				});
	};

	this.getEmployeeNames = function(val) {
		var config = {
			headers : {
				'userName' : $rootScope.userName,
				'token' : $rootScope.token,
				'language' : $rootScope.language
			}
		};

		var raw = {
			employeeName : val
		};

		return $http.post(endPoint + "member/search/employeeName", raw, config)
				.then(function(response) {
					return response.data.resultList;
				});
	};

	this.getPolicyholderNames = function(val) {
		var config = {
			headers : {
				'userName' : $rootScope.userName,
				'token' : $rootScope.token,
				'language' : $rootScope.language
			}
		};

		var raw = {
			policyHolder : val
		};

		return $http.post(endPoint + "policy/search/policyHolderName", raw,
				config).then(function(response) {
			return response.data.resultList;
		});
	};

});

// ajax error handling, interceptor
var appConfig;
app.config([ '$httpProvider', function($httpProvider) {
	$httpProvider.interceptors.push('responseErrHandler');
	$httpProvider.interceptors.push('timestampMarker');
	$httpProvider.interceptors.push('loadingPage');
} ]);
// ajax error handling, interceptor

app.config(function($routeProvider) {
	$routeProvider.when('/home', {
		controller : 'BaseController',
		templateUrl : 'home.html'
	}).when('/uploadAffinityMoment', {
		controller : 'UploadAffinityMomentController',
		templateUrl : '../page/uploadAffinityMoment'
	}).when('/inputActivity', {
		controller : 'InputActivityController',
		templateUrl : '../page/inputActivity'
	}).when('/viewActivity', {
		controller : 'ViewActivityController',
		templateUrl : '../page/viewActivity'
	}).when('/inputContent', {
		controller : 'InputContentController',
		templateUrl : '../page/inputContent'
	}).when('/inputGift', {
		controller : 'InputGiftController',
		templateUrl : '../page/inputGift'
	}).when('/inputHistory', {
		controller : 'InputHistoryController',
		templateUrl : '../page/inputHistory'
	}).when('/viewHistory', {
		controller : 'ViewHistoryController',
		templateUrl : '../page/viewHistory'
	}).when('/inputMember', {
		controller : 'InputMemberController',
		templateUrl : '../page/inputMember'
	}).when('/inputNews', {
		controller : 'InputNewsController',
		templateUrl : '../page/inputNews'
	}).when('/inputPassion', {
		controller : 'InputPassionController',
		templateUrl : '../page/inputPassion'
	}).when('/viewPassion', {
		controller : 'ViewPassionController',
		templateUrl : '../page/viewPassion'
	}).when('/inputPoint', {
		controller : 'InputPointController',
		templateUrl : '../page/inputPoint'
	}).when('/inputTrBalance', {
		controller : 'InputTrBalanceController',
		templateUrl : '../page/inputTrBalance'
	}).when('/viewTrBalance', {
		controller : 'ViewTrBalanceController',
		templateUrl : '../page/viewTrBalance'
	}).when('/inputTrPoint', {
		controller : 'InputTrPointController',
		templateUrl : '../page/inputTrPoint'
	}).when('/inputTrRedeem', {
		controller : 'InputTrRedeemController',
		templateUrl : '../page/inputTrRedeem'
	}).when('/inputUsers', {
		controller : 'InputUsersController',
		templateUrl : '../page/inputUsers'
	}).when('/viewUsers', {
		controller : 'ViewUsersController',
		templateUrl : '../page/viewUsers'
	}).when('/registerValidate', {
		controller : 'RegisterValidateController',
		templateUrl : 'register_validate.html'
	}).when('/login', {
		controller : 'LoginController',
		templateUrl : 'login.html'
	}).when('/logout', {
		controller : 'LogoutController',
		templateUrl : 'home.html'
	}).otherwise({
		redirectTo : '/home'
	});
});

var ErrorController;
app.controller('ErrorController', function($scope, $http, $rootScope,
		$location, $window) {
	$scope.init = function() {
		if ($rootScope.userName && $rootScope.token) {
			while (loadingPage > 0) {
				sleep(1);
			}
			$location.path("/login");
			location.reload();
			console.log("Reload");
		}

	};
	$scope.init();
});

var AccesssDeniedController;
app.controller('AccesssDeniedController', function($scope, $http, $rootScope,
		$location, $window) {
	$scope.init = function() {
		// $location.path("/login");

	};
	$scope.init();
});

var BaseController;
app.controller('BaseController', function($scope, $http, $rootScope, $location,
		$window) {
	$scope.init = function() {
		$rootScope.showSubMenu = false;
	};
	$scope.init();
});

var appRun;
app
		.run(function($rootScope, $location, $window, $http, SearchService,
				$translate) {

			$rootScope.$on('$viewContentLoaded', function(event) {
				$window.ga('send', 'pageview', {
					page : $location.url()
				});
			});

			$rootScope.ContentDropList = [ {
				"key" : "",
				"value" : "Loading..."
			} ];
			$rootScope.NewsDropList = [ {
				"key" : "",
				"value" : "Loading..."
			} ];
			$rootScope.TPassionDropList = [ {
				"key" : "",
				"value" : "Loading..."
			} ];
			$rootScope.UserDropList = [ {
				"key" : "",
				"value" : "Loading..."
			} ];
			$rootScope.TrPointDropList = [ {
				"key" : "",
				"value" : "Loading..."
			} ];
			$rootScope.ActivityDropList = [ {
				"key" : "",
				"value" : "Loading..."
			} ];
			$rootScope.GiftDropList = [ {
				"key" : "",
				"value" : "Loading..."
			} ];
			$rootScope.TrBalanceDropList = [ {
				"key" : "",
				"value" : "Loading..."
			} ];
			$rootScope.HistoryDropList = [ {
				"key" : "",
				"value" : "Loading..."
			} ];
			
			if ($window.sessionStorage.userName != "")
				$rootScope.userName = $window.sessionStorage.userName;
			if ($window.sessionStorage.token != "")
				$rootScope.token = $window.sessionStorage.token;
			if ($window.sessionStorage.language != "")
				$rootScope.language = $window.sessionStorage.language;
			if ($window.sessionStorage.showMenu == "true") {
				$rootScope.showMenu = $window.sessionStorage.showMenu;
			}
			$rootScope.isLocalStorageAvailable = function() {
				try {
					$window.sessionStorage.world = 'hello';
					delete $window.sessionStorage.world;
					return true;
				} catch (ex) {
					return false;
				}
			};

			$rootScope.go = function(path) {
				$location.path(path);
			};

			// get Msg translation
			$rootScope.getAlertMsg = function(msg) {
				if (($rootScope.language == "E" && en_translate[msg] === undefined)
						|| ($rootScope.language == "B" && id_translate[msg] === undefined)) {
					alert(msg);
				} else {
					$translate([ msg ]).then(function(translations) {
						alert(translations[Object.keys(translations)[0]]);
					});
				}
			}

			$rootScope.getTranslateMsg = function(msg) {
				if (($rootScope.language == "E" && en_translate[msg] === undefined)
						|| ($rootScope.language == "B" && id_translate[msg] === undefined)) {
					return msg;
				} else {
					if ($rootScope.language == "E")
						return en_translate[msg];
					if ($rootScope.language == "B")
						return id_translate[msg];
				}
			}

			$rootScope.addTranslateMsg = function(msg, translation) {
				if (en_translate[msg] === undefined) {
					en_translate[msg] = msg;
				}
				if (id_translate[msg] === undefined) {
					id_translate[msg] = translation;
				}

			}

			$rootScope.getContentDropList = function() {

				var config = {
					headers : {
						'userName' : $rootScope.userName,
						'token' : $rootScope.token,
						'language' : $rootScope.language
					}
				};

				var responsePromise = $http.post(endPoint + "/content/list/",
						{}, config);

				responsePromise
						.success(function(data, status, headers, config) {

							if (data.status == "ok") {
								$rootScope.ContentDropList = data.contentDropList;

								if ($rootScope.ContentDropList.length != 1) {
									$rootScope.ContentDropList.splice(0, 0, {
										"key" : "",
										"value" : ""
									});
								}
								$rootScope.request_contentDrop = $rootScope.ContentDropList[0].key;

							} else {
								alert($rootScope.getTranslateMsg(data.errMsg));
							}
						});
				responsePromise.error(function(data, status, headers, config) {
					// alert("Fail to connect to server!");
				});

			};
			
			$rootScope.getNewsDropList = function() {

				var config = {
					headers : {
						'userName' : $rootScope.userName,
						'token' : $rootScope.token,
						'language' : $rootScope.language
					}
				};

				var responsePromise = $http.post(endPoint + "/news/list/",
						{}, config);

				responsePromise
						.success(function(data, status, headers, config) {

							if (data.status == "ok") {
								$rootScope.NewsDropList = data.newsDropList;

								if ($rootScope.NewsDropList.length != 1) {
									$rootScope.NewsDropList.splice(0, 0, {
										"key" : "",
										"value" : ""
									});
								}
								$rootScope.request_newsDrop = $rootScope.NewsDropList[0].key;

							} else {
								alert($rootScope.getTranslateMsg(data.errMsg));
							}
						});
				responsePromise.error(function(data, status, headers, config) {
					// alert("Fail to connect to server!");
				});

			};

			$rootScope.getTPassionDropList = function() {

				var config = {
					headers : {
						'userName' : $rootScope.userName,
						'token' : $rootScope.token,
						'language' : $rootScope.language
					}
				};

				var responsePromise = $http.post(endPoint + "/tPassion/list/",
						{}, config);

				responsePromise
						.success(function(data, status, headers, config) {

							if (data.status == "ok") {
								$rootScope.TPassionDropList = data.passionDropList;

								if ($rootScope.TPassionDropList.length != 1) {
									$rootScope.TPassionDropList.splice(0, 0, {
										"key" : "",
										"value" : ""
									});
								}
								$rootScope.request_tPassionDrop = $rootScope.TPassionDropList[0].key;

							} else {
								alert($rootScope.getTranslateMsg(data.errMsg));
							}
						});
				responsePromise.error(function(data, status, headers, config) {
					// alert("Fail to connect to server!");
				});

			};

			$rootScope.getUserDropList = function() {

				var config = {
					headers : {
						/*'userName' : $rootScope.userName,
						'token' : $rootScope.token,
						'language' : $rootScope.language*/
					}
				};
				var responsePromise = $http.post(endPoint + "/users/list/",
						{}, config);

				responsePromise
						.success(function(data, status, headers, config) {

							if (data.status == "ok") {
								$rootScope.UserDropList = data.resultList;

								if ($rootScope.UserDropList.length != 1) {
									$rootScope.UserDropList.splice(0, 0, {
										"key" : "",
										"value" : ""
									});
								}
								$rootScope.request_userDrop = $rootScope.UserDropList[0].key;
							} else {
								alert($rootScope.getTranslateMsg(data.errMsg));
							}
						});
				responsePromise.error(function(data, status, headers, config) {
					// alert("Fail to connect to server!");
				});

			};

			$rootScope.getTrPointDropList = function() {

				var config = {
					headers : {
						'userName' : $rootScope.userName,
						'token' : $rootScope.token,
						'language' : $rootScope.language
					}
				};

				var responsePromise = $http.post(endPoint + "/trPoint/list/",
						{}, config);

				responsePromise
						.success(function(data, status, headers, config) {

							if (data.status == "ok") {
								$rootScope.TrPointDropList = data.trPointDropList;

								if ($rootScope.TrPointDropList.length != 1) {
									$rootScope.TrPointDropList.splice(0, 0, {
										"key" : "",
										"value" : ""
									});
								}
								$rootScope.request_trPointDrop = $rootScope.TrPointDropList[0].key;

							} else {
								alert($rootScope.getTranslateMsg(data.errMsg));
							}
						});
				responsePromise.error(function(data, status, headers, config) {
					// alert("Fail to connect to server!");
				});

			};

			$rootScope.getActivityDropList = function() {

				var config = {
					headers : {
						'userName' : $rootScope.userName,
						'token' : $rootScope.token,
						'language' : $rootScope.language
					}
				};

				var responsePromise = $http.post(endPoint + "/activity/list/",
						{}, config);

				responsePromise
						.success(function(data, status, headers, config) {

							if (data.status == "ok") {
								$rootScope.ActivityDropList = data.activityDropList;

								if ($rootScope.ActivityDropList.length != 1) {
									$rootScope.ActivityDropList.splice(0, 0, {
										"key" : "",
										"value" : ""
									});
								}
								$rootScope.request_activityDrop = $rootScope.ActivityDropList[0].key;

							} else {
								alert($rootScope.getTranslateMsg(data.errMsg));
							}
						});
				responsePromise.error(function(data, status, headers, config) {
					// alert("Fail to connect to server!");
				});

			};

			$rootScope.getGiftDropList = function() {

				var config = {
					headers : {
						'userName' : $rootScope.userName,
						'token' : $rootScope.token,
						'language' : $rootScope.language
					}
				};

				var responsePromise = $http.post(endPoint + "/gift/list",
						{}, config);

				responsePromise
						.success(function(data, status, headers, config) {

							if (data.status == "ok") {
								$rootScope.GiftDropList = data.giftDropList;

								if ($rootScope.GiftDropList.length != 1) {
									$rootScope.GiftDropList.splice(0, 0, {
										"key" : "",
										"value" : ""
									});
								}
								$rootScope.request_giftDrop = $rootScope.GiftDropList[0].key;

							} else {
								alert($rootScope.getTranslateMsg(data.errMsg));
							}
						});
				responsePromise.error(function(data, status, headers, config) {
					// alert("Fail to connect to server!");
				});

			};

			$rootScope.getTrBalanceDropList = function() {

				var config = {
					headers : {
						'userName' : $rootScope.userName,
						'token' : $rootScope.token,
						'language' : $rootScope.language
					}
				};

				var responsePromise = $http.post(endPoint + "/trBalance/list",
						{}, config);

				responsePromise
						.success(function(data, status, headers, config) {

							if (data.status == "ok") {
								$rootScope.TrBalanceDropList = data.trBalanceDropList;

								if ($rootScope.TrBalanceDropList.length != 1) {
									$rootScope.TrBalanceDropList.splice(0, 0, {
										"key" : "",
										"value" : ""
									});
								}
								$rootScope.request_trBalanceDrop = $rootScope.TrBalanceDropList[0].key;

							} else {
								alert($rootScope.getTranslateMsg(data.errMsg));
							}
						});
				responsePromise.error(function(data, status, headers, config) {
					// alert("Fail to connect to server!");
				});

			};

			$rootScope.getHistoryDropList = function() {

				var config = {
					headers : {
						'userName' : $rootScope.userName,
						'token' : $rootScope.token,
						'language' : $rootScope.language
					}
				};

				var responsePromise = $http.post(endPoint + "/history/list",
						{}, config);

				responsePromise
						.success(function(data, status, headers, config) {

							if (data.status == "ok") {
								$rootScope.HistoryDropList = data.historyDropList;

								if ($rootScope.HistoryDropList.length != 1) {
									$rootScope.HistoryDropList.splice(0, 0, {
										"key" : "",
										"value" : ""
									});
								}
								$rootScope.request_historyDrop = $rootScope.HistoryDropList[0].key;

							} else {
								alert($rootScope.getTranslateMsg(data.errMsg));
							}
						});
				responsePromise.error(function(data, status, headers, config) {
					// alert("Fail to connect to server!");
				});

			};

			$rootScope.getUserDropList();
			
			$rootScope.getDateFromInputString = function(dtp) {
				if (typeof dtp.split === 'function') {
					var bDate = dtp.split("/");
					if (bDate.length == 3) {
						var date = new Date(bDate[2], bDate[1] - 1, bDate[0]);
						if (bDate[0] == date.getDate().toString().zp(2)
								&& bDate[1] == (date.getMonth() + 1).toString()
										.zp(2)
								&& bDate[2] == date.getFullYear().toString()) {
							return bDate[0] + "/" + bDate[1] + "/" + bDate[2];
						} else {
							return "";
						}
					} else {
						return "";
					}
				}
			}
			
		});