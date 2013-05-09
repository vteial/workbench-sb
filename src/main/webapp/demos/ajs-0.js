var app = angular.module('myworkbench', []);

app.constant("developedBy", 'Eialarasu');

app.config(function($routeProvider) {
	$routeProvider.when('/:slug', {
		templateUrl : 'partials/page.html',
		controller : 'routeController'
	}).otherwise({
		redirectTo : '/home'
	});
});

function appController($scope, $rootScope, $http, developedBy) {

	$http.get('views.json').success(function(views) {
		$rootScope.views = views;
	});

	$scope.$on('routeLoaded', function(event, args) {
		$scope.slug = args.slug;
	});
	
	$scope.developedBy = developedBy;
}

function routeController($scope, $rootScope, $routeParams) {
	var slug = $routeParams.slug;
	$scope.$emit('routeLoaded', {
		slug : slug
	});
	$scope.view = $rootScope.views[slug];
}