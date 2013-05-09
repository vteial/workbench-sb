app.factory('alertService', function($rootScope) {
	var alertService = {};

	$rootScope.alerts = [];

	alertService.add = function(type, msg) {
		$rootScope.alerts.push({
			'type' : type,
			'msg' : msg
		});
	};

	alertService.closeAlert = function(index) {
		$rootScope.alerts.splice(index, 1);
	};

	alertService.closeAll = function() {
		$rootScope.alerts.length = 0;
	};

	return alertService;

});