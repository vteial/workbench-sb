var app = angular.module('myworkbench', [ 'ui.bootstrap' ]);

app.controller('html5sqlConsoleController', function($scope) {

	$scope.columns = [];
	$scope.records = [];
	$scope.query = 'select * from user';
	$scope.queries = [ $scope.query ];
	$scope.message = '';
	$scope.tabs = {
		result : false,
		console : true,
		help : false
	};

	try {
		html5sql.openDatabase("html5sqlConsoleDb", "HTML5SQL Console Database",
				1 * 1024 * 1024);
		html5sql.logInfo = true;
		html5sql.logErrors = true;
		html5sql.putSelectResultsInArray = true;
		message = 'Local storage initialized...';
	} catch (error) {
		message = 'Unable to initialize local storage [' + error.message + ']';
	}
	$scope.message = message;
	console.log(message);

	$scope.run = function() {

		$scope.query = $scope.query.toLowerCase();
		if ($scope.query.match(/^select.*/)) {
			html5sql.process([ $scope.query ], onSuccessSelect, onFailure);
		} else {
			html5sql.process([ $scope.query ], onSuccess, onFailure);
		}

	};

	function onSuccessSelect(transaction, results, records) {
		$scope.queries.push($scope.query);
		message = 'Success : ' + $scope.query + "\n";
		if (records.length > 0) {
			var columns = [];
			for ( var prop in records[0]) {
				columns.push(prop);
			}
			console.log(columns);
			$scope.columns = columns;
			$scope.records = records;
		}
		$scope.message = message;
		$scope.tabs.result = true;
		$scope.$apply();
		console.log($scope.message);
	}

	function onSuccess() {
		$scope.queries.push($scope.query);
		var message = 'Success : ' + $scope.query;
		$scope.message = message;
		$scope.tabs.console = true;
		$scope.$apply();
		console.log($scope.message);
	}

	function onFailure(error, statement) {
		var message = 'Error : ' + error.message + " when processing "
				+ statement;
		$scope.message = message;
		$scope.tabs.console = true;
		$scope.$apply();
		console.log(message);
	}

});
