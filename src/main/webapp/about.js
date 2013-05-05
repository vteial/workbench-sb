var app = angular.module('myworkbench', [ 'ui.bootstrap' ]);

app.controller('aboutController', function($scope, $log, $http) {
	$scope.name = 'aboutController';

	$scope.requestProps = [];
	$http.get('about/request').success(function(data) {
		$scope.requestProps = data;
	});

	$scope.contextProps = [];
	// $http.get('about/context').success(function(data) {
	// $scope.contextProps = data;
	// });

	$scope.systemProps = [];
	$http.get('about/system').success(function(data) {
		$scope.systemProps = data;
	});

	$scope.jvmProps = [];
	$http.get('about/jvm').success(function(data) {
		$scope.jvmProps = data;
	});

	$log.info('aboutController...');
});
