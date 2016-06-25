(function(angular) {
	var manager = angular.module("manager", ["authentication", "ngResource"]);
	var managerController = function($scope, AuthenticationService) {
		$scope.currentUser = AuthenticationService.getCurrentUser();
	};
	var managerBuyerCategoriesController = function($scope, $resource) {
		var BuyerCategories = $resource('webshop/managers/getBuyerCategories');
		var loadEntries = function () {
			$scope.buyerCategories  = BuyerCategories.query();
		};
		loadEntries();
	};
	manager.controller('managerController', managerController);
	manager.controller('managerBuyerCategoriesController', managerBuyerCategoriesController);
}(angular));