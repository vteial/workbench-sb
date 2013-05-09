app.factory('userDaoRemote', function() {

});

app.factory('userDaoLocal', function() {

	var dao = {};

	var users = [];

	try {
		html5sql.openDatabase("html5sqlConsoleDb", "HTML5SQL Console Database",
				1 * 1024 * 1024);
		html5sql.logInfo = true;
		html5sql.logErrors = true;
		html5sql.putSelectResultsInArray = true;
		console.log('Database initialized...');
	} catch (error) {
		console.log('Unable to initialize database[' + error.message + ']');
	}

	function onFailure(error, statement) {
		var message = 'Error : ' + error.message + " when processing "
				+ statement;
		console.log(message);
	}

	dao.findAll = function(callBack) {
		var cb = callBack;
		html5sql.process([ 'select * from user' ], function(transaction,
				results, records) {
			users = records;
			cb(users);
		}, onFailure);
	};

	dao.findById = function(userId) {
		var user = null;
		for ( var i = 0; i < users.length; i++) {
			if (users[i].userId === userId) {
				return users[i];
			}
		}
		return user;
	};

	dao.addUser = function(user) {
		users.unshift(user);
		return true;
	};

	dao.updateUser = function(user) {
		for ( var i = 0; i < users.length; i++) {
			if (users[i].userId === user.userId) {
				users[i] = user;
				return true;
			}
		}
		return false;
	};

	dao.deleteUser = function(user) {
		var userRecord = dao.findById(user.userId);
		if (userRecord) {
			users.splice(users.indexOf(userRecord), 1);
			return true;
		}
		return false;
	};

	return dao;
});

app.factory('userDaoMemory', function() {

	var users = [];

	var dao = {};

	dao.findAll = function() {
		return users;
	};

	dao.findById = function(userId) {
		var user = null;
		for ( var i = 0; i < users.length; i++) {
			if (users[i].userId === userId) {
				return users[i];
			}
		}
		return user;
	};

	dao.addUser = function(user) {
		users.unshift(user);
		return true;
	};

	dao.updateUser = function(user) {
		for ( var i = 0; i < users.length; i++) {
			if (users[i].userId === user.userId) {
				users[i] = user;
				return true;
			}
		}
		return false;
	};

	dao.deleteUser = function(user) {
		var userRecord = dao.findById(user.userId);
		if (userRecord) {
			users.splice(users.indexOf(userRecord), 1);
			return true;
		}
		return false;
	};

	return dao;
});
