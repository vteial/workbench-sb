var reverseString1 = function(word) {
	return word.split('').reverse().join('');
}

var reverseString2 = function(word) {
	if (word === '')
		return word;
	return reverseString1(word.substr(1)) + word.charAt(0);
};

var reverseString3 = function(word) {
	var result = [];
	for(var i = word.length-1; i >= 0; i--) {
		result.push(word.charAt(i));
	}
	return result.join('');
};

println(reverseString1("Eialarasu"));
println(reverseString2("Eialarasu"));
println(reverseString3("Eialarasu"));