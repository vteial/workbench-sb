Command = function(newId) {
	var id = newId;

	this.getId = function() {
		return id;
	};

	this.toString = function() {
		return 'Command[ id = ' + id + ']';
	};
};

var cmd = new Command('abs');
println(cmd);

ProduceCommand = function() {
};
ProduceCommand.prototype = new Command();
ProduceCommand.prototype.perform = function() {
	println(this.getId() + ' performend');
};

var prdCmd = new ProduceCommand('prd');
println(prdCmd);
println(prdCmd.perform());