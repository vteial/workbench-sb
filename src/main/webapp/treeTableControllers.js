app.controller('treeTableController', function($scope, userDaoLocal) {

	$scope.user = {};
	$scope.action = 'add';

	var userDao = userDaoLocal;

	userDao.findAll(function(records) {
		$scope.users = records;
		$scope.$apply();
	});

	$scope.addUser = function() {
		userDao.addUser($scope.user);
		alertService.add('success', $scope.user.userId
				+ ' successfully added...');
		$scope.user = {};
	};

	$scope.editUser = function(user) {
		$scope.user = angular.copy(user);
		$scope.action = 'update';
	};

	$scope.editUserByUserId = function(userId) {
		var user = userDao.findById(userId);
		$scope.editUser(user);
	};

	$scope.updateUser = function() {
		userDao.updateUser($scope.user);
		$scope.action = 'add';
		console.message('success', $scope.user.userId
				+ ' successfully updated...');
		$scope.user = {};
	};

	$scope.deleteUser = function(user) {
		userDao.deleteUser(user);
		console.message('success', $scope.user.userId
				+ ' successfully removed...');
	};

});