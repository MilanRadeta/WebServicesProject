(function(angular) {
	var manager = angular.module("manager", ["authentication", "ngResource"]);
	var managerController = function($scope, AuthenticationService) {
		$scope.currentUser = AuthenticationService.getCurrentUser();
	};
	var managerBuyerCategoriesController = function($scope, $resource) {
		var BuyerCategories = $resource('webshop/managers/buyerCategories',
				null,
				{
					update: {
						method: "PUT"
					}
				});
		var loadEntries = function () {
			$scope.buyerCategories  = BuyerCategories.query();
		};
		loadEntries();
		$scope.remove = function(buyerCategory, bonus) {
			buyerCategory.paymentPointsBonuses.splice(buyerCategory.paymentPointsBonuses.indexOf(bonus), 1);
		};
		$scope.add = function(buyerCategory) {
			buyerCategory.paymentPointsBonuses.push(
					{
						min: 0,
						max: 0,
						percent: 0
					}
			);
		};
		$scope.sendNewBonuses = function(buyerCategory) {
			buyerCategory.$update(loadEntries);
		};
	};
	manager.controller('managerController', managerController);
	manager.controller('managerBuyerCategoriesController', managerBuyerCategoriesController);
}(angular));