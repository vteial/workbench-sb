var app = angular.module('aboutService', [ 'ngResource' ]);
app.factory('requestProps', function($resource) {
	return $resource('about/request', {}, {
		get : {
			method : 'GET',
			isArray : true
		}
	});
});

app.factory('systemProps', function($resource) {
	return $resource('about/system', {}, {
		get : {
			method : 'GET',
			isArray : true
		}
	});
});

app.factory('jvmProps', function($resource) {
	return $resource('about/jvm', {}, {
		get : {
			method : 'GET',
			isArray : true
		}
	});
});

angular.module('myworkbench', [ 'ui.bootstrap', 'aboutService' ]);

app.controller('aboutController', function($scope, requestProps, systemProps,
		jvmProps) {

	$scope.requestProps = requestProps.get();

	$scope.contextProps = [];

	$scope.systemProps = systemProps.get();

	$scope.jvmProps = jvmProps.get();

});
