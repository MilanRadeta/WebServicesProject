(function () {
    angular
        .module('authentication',['ngStorage', 'ui.router', 'angular-jwt'])
        .factory('AuthenticationService', Service);

    function Service($http, $localStorage, $log, $state, jwtHelper) {
        var service = {};

        service.login = login;
        service.logout = logout;
        service.getCurrentUser = getCurrentUser;

        return service;

        function login(username, password, callback) {
        	$http({
				method: 'POST',
				url: "webshop/users/login",
				data: {
					username: username,
					password: password
				}
			}).then(
				function (response) {
					if (response.data) {
	                    var currentUser = { username: username, token: response.data };
	                    var tokenPayload = jwtHelper.decodeToken(response.data);

	                    console.log(tokenPayload);
	                    if(tokenPayload.role){
	                        currentUser.role = tokenPayload.role;
	                        currentUser.username = tokenPayload.sub;
	                    }
	                    $localStorage.currentUser = currentUser;
	                    $http.defaults.headers.common.Authorization = response.token;
	                    callback(true);
	                } else {
	                    callback(false);
	                }
				},
				function (error) {
					callback(false);
				}
			);
        }

        function logout() {
            delete $localStorage.currentUser;
            $http.defaults.headers.common.Authorization = '';
            $state.go('login');
        }

        function getCurrentUser() {
            return $localStorage.currentUser;
        }
    }
})();