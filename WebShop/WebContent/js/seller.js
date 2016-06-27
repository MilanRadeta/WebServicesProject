(function(angular) {
	var seller = angular.module("seller", ["authentication", "ngResource"]);
	var sellerController = function($scope, AuthenticationService) {
		$scope.currentUser = AuthenticationService.getCurrentUser();
	};
	seller.controller('sellerController', sellerController);
	var sellerArticlesController = function($scope, $resource) {
		var Articles = $resource('webshop/sellers/articles',
				null, {
					update : {
						method : "PUT"
					}
				});
		var loadEntries = function() {
			$scope.neededArticles = Articles.query();
		};
		loadEntries();
		$scope.order = function(article) {
			Articles.update({count: article.count}, article, loadEntries);
		};
	};
	seller.controller('sellerArticlesController', sellerArticlesController);
	var sellerBillsController = function($scope, $resource) {
		var Bills = $resource('webshop/sellers/bills',
				null, {
					update : {
						method : "PUT"
					}
				});
		var loadEntries = function() {
			$scope.orderedBills = Bills.query();
		};
		loadEntries();
		$scope.process = function(bill) {
			bill.$update(loadEntries);
		};
		$scope.cancel = function(bill) {
			bill.$delete(loadEntries);
		};
	};
	seller.controller('sellerBillsController', sellerBillsController);
}(angular));