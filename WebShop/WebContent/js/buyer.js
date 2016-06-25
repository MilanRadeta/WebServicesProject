(function(angular) {
	var buyer = angular.module("buyer", ["authentication"]);
	var buyerController = function($scope, AuthenticationService) {
		$scope.currentUser = AuthenticationService.getCurrentUser();
	};
	buyer.controller('buyerController', buyerController);
}(angular));