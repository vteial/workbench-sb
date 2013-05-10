app.controller('aboutController', function($scope, aboutService) {

	$scope.requestProps = [];
	$scope.systemProps = [];
	$scope.jvmProps = [];

	function getAllProps() {
		aboutService.getRequestProps().then(function(data) {
			$scope.requestProps = data;
		}, function(errorMessage) {
			console.log(errorMessage);
		});

		aboutService.getSystemProps().then(function(data) {
			$scope.systemProps = data;
		}, function(errorMessage) {
			console.log(errorMessage);
		});

		aboutService.getJvmProps().then(function(data) {
			$scope.jvmProps = data;
		}, function(errorMessage) {
			console.log(errorMessage);
		});
	}

	getAllProps();
});
