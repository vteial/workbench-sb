var app = angular.module('html5sqlConsole', [ 'ui.bootstrap' ]);

app.controller('html5sqlConsoleController', function($scope) {

	$scope.html5sqlConsole = {};
	var html5sqlConsole = $scope.html5sqlConsole;

	html5sqlConsole.query = 'select * from example';
	html5sqlConsole.message = 'Query : ' + $scope.query;

	try {
		html5sql.openDatabase("html5sqlConsoleDb", "HTML4SQL Console Database",
				1 * 1024 * 1024);
		html5sql.logInfo = true;
		html5sql.logErrors = true;
		html5sql.putSelectResultsInArray = true;
		html5sqlConsole.message = 'Database initialized...';
		console.log(html5sqlConsole.message);
	} catch (error) {
		html5sqlConsole.message = 'Unable to initialize database['
				+ error.message + ']';
		console.log(html5sqlConsole.message);
	}

	$scope.run = function() {

		var query = html5sqlConsole.query.toLowerCase();
		html5sqlConsole.message = 'Query : ' + query;
		console.log(html5sqlConsole.message);
		if (query.match(/^select.*/)) {
			html5sql.process([ query ], function(transaction, results,
					rowsArray) {
				var message = 'Success : ' + query + "\n";
				for ( var i = 0; i < rowsArray.length; i++) {
					message += rowsArray[i].id + ", ";
					message += rowsArray[i].data + "\n";
				}
				$scope.$apply(function() {
					$scope.html5sqlConsole.message = message;
				});
				console.log($scope.html5sqlConsole.message);
			}, function(error, statement) {
				var message = 'Error : ' + error.message + " when processing "
						+ statement;
				$scope.$apply(function() {
					$scope.html5sqlConsole.message = message;
				});
				console.log($scope.html5sqlConsole.message);
			});

		} else {

			html5sql.process([ query ], function() {
				var message = 'Success : ' + query;
				$scope.$apply(function() {
					$scope.html5sqlConsole.message = message;
				});
				console.log($scope.html5sqlConsole.message);
			}, function(error, statement) {
				var message = 'Error : ' + error.message + " when processing "
						+ statement;
				$scope.$apply(function() {
					$scope.html5sqlConsole.message = message;
				});
				console.log($scope.html5sqlConsole.message);
			});

		}
	};

});
