var toString = function(objectName, object) {
	var result = objectName + '[ ';

	for (var prop in object) {
		result += prop + ' = ' + object[prop] + ', ';
	}
	result += ']';

	return result;
};

var a = {
	a : 'a',
	b : 'b'
};
var b = {
	a : 'a',
	b : 'b'
};
var aa = a;

println(a == b);
println(a === b);
println(a == aa);
println(a === aa);

println(toString('a', a));
delete a['b'];
println(toString('a', a));

println(a instanceof Object);
println(a.constructor === Object);
