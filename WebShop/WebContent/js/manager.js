(function(angular) {
	var manager = angular.module("manager", ["ui.bootstrap", "authentication", "ngResource" ]);
	var managerController = function($scope, AuthenticationService) {
		$scope.currentUser = AuthenticationService.getCurrentUser();
	};
	var managerBuyerCategoriesController = function($scope, $resource) {
		var BuyerCategories = $resource('webshop/managers/buyerCategories',
				null, {
					update : {
						method : "PUT"
					}
				});
		var loadEntries = function() {
			$scope.buyerCategories = BuyerCategories.query();
		};
		loadEntries();
		$scope.remove = function(buyerCategory, bonus) {
			buyerCategory.paymentPointsBonuses.splice(
					buyerCategory.paymentPointsBonuses.indexOf(bonus), 1);
		};
		$scope.add = function(buyerCategory) {
			buyerCategory.paymentPointsBonuses.push({
				min : 0,
				max : 0,
				percent : 0
			});
		};
		$scope.sendNewBonuses = function(buyerCategory) {
			buyerCategory.$update(loadEntries);
		};
	};
	var managerArticleCategoriesController = function($scope, $resource) {
		$scope.newArticleCategory = {};
		var ArticleCategories = $resource('webshop/managers/articleCategories',
				null, {
					update : {
						method : "PUT"
					}
				});
		var loadEntries = function() {
			$scope.articleCategories = ArticleCategories.query();
		};
		loadEntries();
		$scope.create = function() {
			ArticleCategories.save(null, $scope.newArticleCategory, function(
					response) {
				var error = response.data;
				if (!error) {
					loadEntries();
				} else {
					// TODO
				}
			});
			$scope.newArticleCategory = {};
		};
		$scope.change = function(articleCategory) {
			articleCategory.$update(loadEntries);
		};
	};
	var managerSaleEventsController = function($scope, $resource) {
		$scope.dateFromOpened = {};
		$scope.dateToOpened = {};
		$scope.newSaleEvent = {};
		var ArticleCategories = $resource('webshop/managers/articleCategories');
		var SaleEvents = $resource('webshop/managers/saleEvents', null, {
			update : {
				method : "PUT"
			}
		});
		var loadEntries = function() {
			$scope.articleCategories = ArticleCategories.query();
			$scope.saleEvents = SaleEvents.query();
		};
		loadEntries();
		$scope.create = function() {
			console.log($scope.newSaleEvent);
			SaleEvents.save(null, $scope.newSaleEvent, function(response) {
				var error = response.data;
				if (!error) {
					loadEntries();
					$scope.newSaleEvent = {};
				} else {
					// TODO
				}
			});
		};
		$scope.change = function(saleEvent) {
			saleEvent.$update(loadEntries);
		};

		$scope.dateOptions = {
			formatYear : 'yy',
			startingDay : 1
		};
	};
	manager.controller('managerController', managerController);
	manager.controller('managerBuyerCategoriesController',
			managerBuyerCategoriesController);
	manager.controller('managerArticleCategoriesController',
			managerArticleCategoriesController);
	manager.controller('managerSaleEventsController',
			managerSaleEventsController);
}(angular));