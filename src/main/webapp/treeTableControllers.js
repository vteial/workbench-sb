app.controller('treeTableController', function($scope, userDaoLocal) {

	$scope.user = {};
	$scope.action = 'add';

	var userDao = userDaoLocal;

	function findAll() {
		userDao.findAll(function(records) {
			$scope.users = records;
			$scope.$apply();
		});
	}
	
	$scope.refresh = function() {
		findAll();
	};

	$scope.addUser = function() {
		userDao.addUser($scope.user, findAll);
		$scope.user = {};
	};

	$scope.editUser = function(user) {
		$scope.user = angular.copy(user);
		$scope.action = 'update';
	};

	$scope.editUserByUserId = function(userId) {
		userDao.findById(userId, function(user){
			if(user) {
				$scope.editUser(user);	
				$scope.$apply();
			} else {
				console.log(userId + " doesn't exist...");
			}
		});
	};

	$scope.updateUser = function() {
		userDao.updateUser($scope.user, findAll);
		$scope.action = 'add';
		$scope.user = {};
	};

	$scope.deleteUser = function(user) {
		userDao.deleteUser(user, findAll);
	};

	findAll();
});