app.controller('footerController', function($scope) {

});

app.controller('alertController', function($rootScope, alertService) {

	$rootScope.closeAlert = alertService.closeAlert;

});
