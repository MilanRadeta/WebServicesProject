(function(angular) {
	var buyer = angular.module("buyer", ["authentication", "ngResource"]);
	var buyerController = function($scope, AuthenticationService) {
		$scope.currentUser = AuthenticationService.getCurrentUser();
	};
	buyer.controller('buyerController', buyerController);
	var buyerProfileController = function($scope, $resource) {
		var BuyerProfile = $resource('webshop/buyers/profile');
		var loadProfile = function() {
			$scope.buyer = BuyerProfile.get();
		};
		loadProfile();
	};
	buyer.controller('buyerProfileController', buyerProfileController);
	var buyerPaymentHistoryController = function($scope, $resource) {
		var PaymentHistory = $resource('webshop/buyers/paymentHistory');
		var loadEntries = function() {
			$scope.paymentHistory = PaymentHistory.query();
		};
		loadEntries();
	};
	buyer.controller('buyerPaymentHistoryController', buyerPaymentHistoryController);
	var buyerShopController = function($scope, $resource) {
		$scope.searchQuery = {};
		var Article = $resource('webshop/buyers/article', null,
				{
					search: {
						method: 'POST',
						isArray: true
					}
				});
		var SaleEvents = $resource('webshop/buyers/saleEvents');
		var search = function() {
			$scope.searchResults = Article.search(null, $scope.searchQuery);
			$scope.saleEvents = {};
			SaleEvents.query(function(data) {
					var saleEvents = data;
					for (var index in saleEvents) {
						var event = saleEvents[index];
						var categories = event.categories;
						for (var cindex in categories) {
							var cat = categories[cindex];
							if (!$scope.saleEvents[cat.id]) {
								$scope.saleEvents[cat.id] = [];
							}
							$scope.saleEvents[cat.id].push(event);
						}
					}
			});
		};
		
		search();
		var Cart = $resource('webshop/buyers/cart', null, 
				{
					update: {
						method: 'PUT'
					}
				});
		var getCart = function() {
			$scope.cart = Cart.get();
		};
		getCart();
		$scope.addToCart = function(article) {
			$scope.cart.items.push(
					{
						article: article,
						unitPrice: article.price,
						units: article.count,
						
					}
			);
			$scope.cart.$update();
		};
		
		$scope.showCart = function() {
			$scope.cartShown = true;
		};
		
		$scope.removeFromCart = function(item) {
			$scope.cart.splice($scope.cart.indexOf(item), 1);
			$scope.cart.$update();
		};
		
		$scope.payBill = function() {
			$scope.bill = Cart.update(null, $scope.cart);
			$scope.cart = Cart.get();
			$scope.cartShown = false;
			$scope.billShown = true;
		};
		
		$scope.showSearch = function() {
			$scope.bill = null;
			$scope.billShown = false;
			$scope.cartShown = false;
		};
		
	};
	buyer.controller('buyerShopController', buyerShopController);
}(angular));