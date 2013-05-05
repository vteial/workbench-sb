var app = angular.module('myworkbench', [ 'ui.bootstrap' ]);

app.controller('html5sqlConsoleController', function($scope) {

	var columns = [], records = [], query = 'select * from example';
	var message = 'Query : ' + query;

	$scope.columns = columns;
	$scope.records = records;
	$scope.query = query;
	$scope.message = message;

	try {
		html5sql.openDatabase("html5sqlConsoleDb", "HTML4SQL Console Database",
				1 * 1024 * 1024);
		html5sql.logInfo = true;
		html5sql.logErrors = true;
		html5sql.putSelectResultsInArray = true;
		message = 'Database initialized...';
	} catch (error) {
		message = 'Unable to initialize database['
				+ error.message + ']';
	}
	$scope.message = message;
	console.log(message);
	
	$scope.run = function() {

		columns = [];
		records = [];
		query = $scope.query.toLowerCase();
		message = 'Query : ' + query;
		//console.log(message);
		
		if (query.match(/^select.*/)) {
			html5sql.process([ query ],
					function(transaction, results, records) {
						var columns = [], message = 'Success : ' + query
								+ "\n";
						if (records.length > 0) {
							for ( var prop in records[0]) {
								columns.push(prop);
							}
							console.log(columns);
						}
						for ( var i = 0; i < records.length; i++) {
							for ( var j = 0; j < columns.length; j++) {
								message += records[i][columns[j]];
								message += ',';
							}
							message += '\n';
						}
						$scope.$apply(function() {
							$scope.message = message;
							$scope.columns = columns;
							$scope.records = records;
						});
						console.log($scope.message);
						
					}, function(error, statement) {
						
						var message = 'Error : ' + error.message
								+ " when processing " + statement;
						$scope.$apply(function() {
							$scope.message = message;
						});
						console.log($scope.message);
						
					});

		} else {

			html5sql.process([ query ], function() {
				
				var message = 'Success : ' + query;
				$scope.$apply(function() {
					$scope.message = message;
				});
				console.log($scope.message);
				
			}, function(error, statement) {
				
				var message = 'Error : ' + error.message + " when processing "
						+ statement;
				$scope.$apply(function() {
					$scope.message = message;
				});
				console.log($scope.message);
				
			});

		}
	};

});
