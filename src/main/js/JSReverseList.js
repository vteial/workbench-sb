// Uncomment below commented block if you are going to run in browser
/*
var println = function(message) {
	console.log(message);
}
*/
// Comment the above commented block if you are going to run in Eclipse
var reverse1 = function(items) {
	var nItems = [], j = items.length-1;
	for(var i = 0; i < items.length; i++) {
		nItems[i] = items[j--];
	}
	return nItems;
};

var reverse2 = function(items) {
	var e = Math.ceil(items.length / 2);
	for(var i = 0, j = items.length-1; i < e; i++, j--) {
		var t = items[i];
		items[i] = items[j];
		items[j] = t;
	}
};

var items = [1, 2, 3, 4, 5, 6, 7];
println("Given Items = " + items);

println("Reverse Version 0 : " + items.reverse());

println("Reverse Version 1 : " + reverse1(items));

reverse2(items);
println("Reverse Version 2 : " + items);