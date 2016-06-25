(function(angular) {
	var login = angular.module("login", ["ngStorage", "authentication", "ui.router", "navbar"]);
	var loginController = function($rootScope, $scope, $localStorage, AuthenticationService, $state, Navbar) {
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
							if (!success) {
								$scope.loginFailed = true;
								$scope.loggingIn = false;
							}
							else {
								console.log("successful login");
								Navbar.update();
								$rootScope.checkState($state.current);
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