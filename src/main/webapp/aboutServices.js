app.factory('aboutService', function($http, $q) {
	var aboutService = {};

	aboutService.getRequestProps = function() {
		var deferred = $q.defer();
		$http.get('about/request').success(function(data) {
			deferred.resolve(data);
		}).error(function() {
			deferred.reject("Unable to fetch request props...");
		});
		return deferred.promise;
	};

	aboutService.getSystemProps = function() {
		var deferred = $q.defer();
		$http.get('about/system').success(function(data) {
			deferred.resolve(data);
		}).error(function() {
			deferred.reject("Unable to fetch request props...");
		});
		return deferred.promise;
	};

	aboutService.getJvmProps = function() {
		var deferred = $q.defer();
		$http.get('about/jvm').success(function(data) {
			deferred.resolve(data);
		}).error(function() {
			deferred.reject("Unable to fetch request props...");
		});
		return deferred.promise;
	};

	return aboutService;

});