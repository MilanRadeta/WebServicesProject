(function(angular) {
	var buyer = angular.module("buyer", ["authentication", "ngResource"]);
	var buyerController = function($scope, AuthenticationService) {
		$scope.currentUser = AuthenticationService.getCurrentUser();
	};
	buyer.controller('buyerController', buyerController);
	var buyerProfileController = function($scope, $resource) {
	};
	buyer.controller('buyerProfileController', buyerProfileController);
	var buyerPaymentHistoryController = function($scope, $resource) {
	};
	buyer.controller('buyerPaymentHistoryController', buyerPaymentHistoryController);
	var buyerShopController = function($scope, $resource) {
	};
	buyer.controller('buyerShopController', buyerShopController);
}(angular));