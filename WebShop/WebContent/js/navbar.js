(function(angular) {
	var navbar = angular.module("navbar", ["authentication", "ui.router"]);
	var navbarController = function($scope, AuthenticationService, $state, $rootScope) {
		$scope.options = [];
		var currentUser = AuthenticationService.getCurrentUser();
		if (currentUser) {
			switch(currentUser.role) {
    		case "BUYER":
    			$scope.options =
    				[
 				 	{
				 		name: "Home",
				 		state: "buyer"
				 	},
				 	{
				 		name: "Logout",
				 		onClick: $rootScope.logout
				 	}
				 	];
    			break;
    		case "MANAGER":
    			$scope.options =
    				[
 				 	{
				 		name: "Home",
				 		state: "manager"
				 	},
 		            {
 		            	name: "Kupci",
 		            	state: "manager.buyerCategories"
 		            },
 		            {
 		            	name: "Artikli",
 		            	state: "manager.articleCategories"
 		            },
 		            {
 		            	name: "Akcije",
 		            	state: "manager.saleEvents"
 		            },
				 	{
				 		name: "Logout",
				 		onClick: $rootScope.logout
				 	}
				 	];
    			break;
    		case "SELLER":
    			$scope.options =
    				[
 				 	{
				 		name: "Home",
				 		state: "seller"
				 	},
				 	{
				 		name: "Logout",
				 		onClick: $rootScope.logout
				 	}
				 	];
    			break;
    		}
		}
		
		$scope.isActive = function (option) {
			if (option.state) {
				return option.state == $state.current.name;
			}
			return false;
		};
		
		$scope.isLoggedIn = function() {
			return $rootScope.isLoggedIn();
		};
		
	};
	navbar.controller('navbarController', navbarController);
}(angular));