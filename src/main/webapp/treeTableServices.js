app.factory('userDaoRemote', function() {

});

app.factory('userDaoLocal', function() {

	var dao = {};

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
		html5sql.process([ 'select * from user' ], function(transaction,
				results, records) {
			callBack(records);
		}, onFailure);
	};

	dao.findById = function(userId, callBack) {
		html5sql.process([ 'select * from user' ], function(transaction,
				results, records) {
			if (records.length == 0) {
				callBack(null);
			} else {
				callBack(records[0]);
			}
		}, onFailure);
	};

	dao.addUser = function(user, callBack) {
		var sql = "insert into user (user_id, password, name, email_id";
		if (user.parent_id) {
			sql += ", parent_id";
		}
		sql += ") values ('" + user.user_id + "', '" + user.password + "', '";
		sql += user.name + "', '" + user.email_id + "'";
		if (user.parent_id) {
			sql += ", '" + user.parent_id + "'";
		}
		sql += ")";
		// console.log("sql = " + sql);
		html5sql.process([ sql ], callBack, onFailure);
	};

	dao.updateUser = function(user, callBack) {
		var sql = "update user set password = '" + user.password
				+ "', name = '";
		sql += user.name + "', email_id = '" + user.email_id + "'";
		if (user.parent_id) {
			sql += ", parent_id = '" + user.parent_id + "'";
		}
		sql += " where user_id = '" + user.user_id + "'";
		// console.log("sql = " + sql);
		html5sql.process([ sql ], callBack, onFailure);
	};

	dao.deleteUser = function(user, callBack) {
		var sql = "delete from user where user_id = '";
		sql += user.user_id + "'";
		// console.log("sql = " + sql);
		html5sql.process([ sql ], callBack, onFailure);
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
