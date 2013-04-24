// To live run use online java script console from here http://repl.it/
 
// Uncomment below commented block if you are going to run in browser
/*
var println = function(message) {
  console.log(message);
};
*/
// Comment the above commented block if you are going to run in Eclipse JEE

var reverseString0 = function(word) {
	return word.split('').reverse().join('');
};

var reverseString1 = function(word) {
	if (word === '')
		return word;
	return reverseString1(word.substr(1)) + word.charAt(0);
};

var reverseString2 = function(word) {
	return word.length === 0 ? word : reverseString2(word.substr(1))
			+ word.charAt(0);
};

var reverseString3 = function(word) {
	var result = [];
	for ( var i = word.length - 1; i >= 0; i--) {
		result.push(word.charAt(i));
	}
	return result.join('');
};

var reverseString4 = function(word) {
	if (word.length < 2) {
		return word;
	}
	var halfIndex = word.length / 2;
	return reverseString4(word.substr(halfIndex))
			+ reverseString4(word.substr(0, halfIndex));
};

var word = "0123456789";
println("Given Word = " + word);

word = reverseString0(word);
println("Reverse Version 0 : " + word);

word = reverseString1(word);
println("Reverse Version 1 : " + word);

word = reverseString2(word);
println("Reverse Version 2 : " + word);

word = reverseString3(word);
println("Reverse Version 3 : " + word);

word = reverseString4(word);
println("Reverse Version 4 : " + word);
