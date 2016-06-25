(function(angular) {
	var app = angular.module("app", ["navbar", "login", "ui.router", "authentication"]);
	app.config(function config($stateProvider, $urlRouterProvider) {
		$urlRouterProvider.otherwise("/login");
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
				"buyer",
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
		$rootScope.$state = $state;
        if ($localStorage.currentUser) {
            $http.defaults.headers.common.Authorization = $localStorage.currentUser.token;
        }
        else {
        	$state.go("login");
        }

        $rootScope.checkState = function(toState) {
        	var currentUser = AuthenticationService.getCurrentUser();
        	if(currentUser){
        		switch(currentUser.role) {
        		case "BUYER":
        			if (!toState.name.startsWith("buyer")) {
        				$state.go("buyer");
        			}
        			break;
        		case "MANAGER":
        			if (!toState.name.startsWith("manager")) {
            			$state.go("manager");
        			}
        			break;
        		case "SELLER":
        			if (!toState.name.startsWith("seller")) {
            			$state.go("seller");
        			}
        			break;
        		}
        		return;
            }
            $state.go('login');
        };
        
        $rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {
          $rootScope.checkState(toState);
        });

        $rootScope.logout = function () {
            AuthenticationService.logout();
            return true;
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