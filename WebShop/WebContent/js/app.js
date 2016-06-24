(function(angular) {
	var app = angular.module("app", ["login", "ui.router", "authentication"]);
	app.config(function config($stateProvider, $urlRouterProvider) {
		$urlRouterProvider.otherwise("/main");
		$stateProvider
			.state(
				"login",
				{
					url: "/login",
					templateUrl: "login.html",
					controller: "loginController"
				}
			)
			.state(
				"main",
				{
					url: "/",
					templateUrl: "buyer.html",
					controller: "buyerController"
				}
			)
			.state(
				"manager",
				{
					url: "/",
					templateUrl: "manager.html",
					controller: "managerController"
				}
			)
			.state(
				"seller",
				{
					url: "/",
					templateUrl: "seller.html",
					controller: "sellerController"
				}
			);
	});
	
	app.run(function($rootScope, $http, $location, $localStorage, AuthenticationService, $state) {
        if ($localStorage.currentUser) {
            $http.defaults.headers.common.Authorization = $localStorage.currentUser.token;
        }

        $rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {
          if(!AuthenticationService.getCurrentUser()){
            $state.go('login');
          }
          else {
        	  // TODO: check user role
          }
        });

        $rootScope.logout = function () {
            AuthenticationService.logout();
        };
        
        $rootScope.getCurrentUserRole = function () {
            if (!AuthenticationService.getCurrentUser()){
              return undefined;
            }
            else{
              return AuthenticationService.getCurrentUser().role;
            }
        };
        $rootScope.isLoggedIn = function () {
            if (AuthenticationService.getCurrentUser()){
              return true;
            }
            else{
              return false;
            }
        };
        $rootScope.getCurrentState = function () {
          return $state.current.name;
        };
	});
	
}(angular));