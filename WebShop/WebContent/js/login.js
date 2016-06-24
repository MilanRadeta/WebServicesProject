(function(angular) {
	var login = angular.module("login", ["ngStorage", "authentication"]);
	var loginController = function($scope, $localStorage, AuthenticationService) {
		$scope.username = null;
		$scope.password = null;
		$scope.loggingIn = false;
		$scope.loginFailed = false;
		
		$scope.login = function() {
			if ($scope.username && $scope.password) {
				$scope.loginFailed = false;
				$scope.loggingIn = true;
				AuthenticationService.login(
						$scope.username,
						$scope.password,
						function(success) {
							console.log(success);
							if (!success) {
								$scope.loginFailed = true;
								$scope.loggingIn = false;
							}
							else {
								// TODO
								switch ($localStorage.currentUser.role) {
								case "BUYER":
									break;
								case "MANAGER":
									break;
								case "SELLER":
									break;
								}
							}
						}
				);
			}
			else {
				$scope.loggingIn = false;
				$scope.loginFailed = true;
			}
		};
	};
	login.controller('loginController', loginController);
}(angular));