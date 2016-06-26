(function(angular) {
	var navbar = angular.module("navbar", ["authentication", "ui.router"]);
    
    var updateNavbar;
	
	var navbarController = function($scope, AuthenticationService, $state, $rootScope) {
		$scope.isActive = function (option) {
			if (option.state) {
				return option.state == $state.current.name;
			}
			return false;
		};
		
		$scope.isLoggedIn = function() {
			return $rootScope.isLoggedIn();
		};
		
		updateNavbar = function() {
			console.log("Setting Navbar");
			var currentUser = AuthenticationService.getCurrentUser();
			if (currentUser) {
				switch (currentUser.role) {
				case "BUYER":
					$scope.options = [ {
						name : "Home",
						state : "buyer"
					}, {
						name : "Profil",
						state : "profile"
					}, {
						name : "Istorijat",
						state : "paymentHistory"
					}, {
						name : "Shop",
						state : "shop"
					}, {
						name : "Logout",
						onClick : $rootScope.logout
					} ];
					break;
				case "MANAGER":
					$scope.options = [ {
						name : "Home",
						state : "manager"
					}, {
						name : "Kupci",
						state : "manager.buyerCategories"
					}, {
						name : "Artikli",
						state : "manager.articleCategories"
					}, {
						name : "Akcije",
						state : "manager.saleEvents"
					}, {
						name : "Logout",
						onClick : $rootScope.logout
					} ];
					break;
				case "SELLER":
					$scope.options = [ {
						name : "Home",
						state : "seller"
					}, {
						name : "Artikli",
						state : "articles"
					}, {
						name : "Računi",
						state : "bills"
					}, {
						name : "Logout",
						onClick : $rootScope.logout
					} ];
					break;
				}
			}
		};
		
		$scope.updateNavbar = updateNavbar;
		updateNavbar();
		
	};
	navbar.controller('navbarController', navbarController);


    navbar.factory('Navbar', Service);
    function Service() {
		var service = {};
		service.update = updateNavbar;
		
		return service;
	};
}(angular));