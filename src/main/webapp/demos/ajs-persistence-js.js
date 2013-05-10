var app = angular.module("myworkbench", []);

app.factory('persistencejsService', function() {
	var persistencejsService = {};

	persistence.store.websql.config(persistence, 'todoDbb', 'To Do database',
			5 * 1024 * 1024);
	var ToDo = persistence.define('todo', {
		content : 'TEXT',
		done : 'BOOL'
	});
	persistence.schemaSync();

	persistencejsService.findAll = function(callBack) {
		ToDo.all().list(function(items) {
			var toDos = [];
			items.forEach(function(item) {
				toDos.push({
					content : item.content,
					done : item.done
				});
				console.log(item.content + ', ' + item.done);
			});
			callBack(toDos);
		});
	};

	persistencejsService.add = function(content) {
		var task = new ToDo();
		task.content = content;
		task.done = false;
		persistence.add(task);
		persistence.flush();
	};

	return persistencejsService;
});

app.controller('appController', function($scope, persistencejsService) {

	$scope.toDos = [];
	$scope.content = '';

	$scope.addTask = function() {
		persistencejsService.add($scope.content);
		$scope.content = '';
		loadToDos();
	};

	$scope.deleteTask = function(toDo) {
	};

	function loadToDos() {
		persistencejsService.findAll(function(newTodos) {
			$scope.toDos = newTodos;
			$scope.$apply();
		});
	}

	loadToDos();
});