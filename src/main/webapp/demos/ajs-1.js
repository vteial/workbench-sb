var app = angular.module("myworkbench", []);

app.controller('appController', function($scope) {

	try {
		html5sql.openDatabase("html5sqlConsoleDb", "HTML5SQL Console Database",
				1 * 1024 * 1024);
		html5sql.logInfo = true;
		html5sql.logErrors = true;
		html5sql.putSelectResultsInArray = true;
		$scope.message = 'Database initialized...';
	} catch (error) {
		$scope.message = 'Unable to initialize database['
				+ error.message + ']';
	}
	
	$scope.query = "select * from user";
	
	$scope.run = function() {
		
		html5sql.process([ $scope.query ], onSuccess, onFailure);
		console.log("query triggered...");
	}
	
	function onSuccess(transaction, results, records) {
		var message = 'Success : recordCount = ' + records.length;
		$scope.message = message;
		$scope.$apply();
		console.log($scope.message);
	}
	
	function onFailure(error, statement) {
		var message = 'Error : ' + error.message + " when processing "
		+ statement;
		$scope.message = message;
		$scope.$apply();
		console.log($scope.message);
	}
	
});
