// default logic
var factorial1 = function(number) {
	var factValue = 1;
	for ( var i = 1; i <= number; i++) {
		factValue = factValue * i;
	}
	return factValue;
};
// recursive logic
var factorial2 = function(number) {
	if (number < 1) {
		return 1;
	}
	var factValue = factorial2(number - 1) * number;
	return factValue;
};
// performance improvement
var factDb = {};
var factorial3 = function(number) {
	if (number < 1) {
		return 1;
	}
	if (factDb[number]) {
		return factDb[number];
	}
	factDb[number] = factorial3(number - 1) * number;
	return factDb[number];
};

var value = 3;
println('Factoiral[' + value + '] = ' + factorial1(value));
value = 4;
println('Factoiral[' + value + '] = ' + factorial2(value));
value = 5;
println('Factoiral[' + value + '] = ' + factorial3(value));
value = 3;
println('Factoiral[' + value + '] = ' + factorial3(value));
