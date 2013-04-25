// To live run use online java script console from here http://repl.it/

// Uncomment below commented block if you are going to run in browser
/*
 var println = function(message) {
 console.log(message);
 };
 */
// Comment the above commented block if you are going to run in Eclipse
var reverseArray0 = function(items) {
	return items.reverse();
};

var reverseArray1 = function(items) {
	var nItems = [], j = items.length - 1;
	for ( var i = 0; i < items.length; i++) {
		nItems[i] = items[j--];
	}
	return nItems;
};

var reverseArray2 = function(items) {
	var e = Math.ceil(items.length / 2);
	for ( var i = 0, j = items.length - 1; i < e; i++, j--) {
		var t = items[i];
		items[i] = items[j];
		items[j] = t;
	}
};

var reverseArray3 = function(items) {
	reverseArray33(items, 0, items.length - 1);
};

var reverseArray33 = function(items, i, j) {
	if (i < j) {
		var t = items[i];
		items[i] = items[j];
		items[j] = t;
		reverseArray33(items, ++i, --j);
	}
};

var items = [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ];
println("Given Items = " + items);

items = reverseArray0(items);
println("Reverse Version 0 : " + items);

items = reverseArray1(items);
println("Reverse Version 1 : " + items);

reverseArray2(items);
println("Reverse Version 2 : " + items);

reverseArray3(items);
println("Reverse Version 3 : " + items);