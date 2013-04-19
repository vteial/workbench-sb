// Uncomment below commented block if you are going to run in browser
/*
 var println = function(message) {
 console.log(message);
 }
 */
// Comment the above commented block if you are going to run in Eclipse
var reverse0 = function(number) {
	return number.toString().split('').reverse().join('');
};

var reverse1 = function(number) {
	var reverse = 0;
	while (number !== 0) {
		reverse = reverse * 10 + number % 10;
		number = parseInt(number / 10);
		// println("reverse = " + reverse + " number = " + number);
	}
	return reverse;
};

var checkPalindrome = function(number) {
	var reverse;
	if ((typeof number) == 'number') {
		reverse = reverse1(number);
	} else {
		reverse = reverse0(number);
	}
	return reverse == number;
};

var value = '1234';
println("Reverse0 String : " + value + ' -> ' + reverse0(value));
value = 1234;
println("Reverse0 Number : " + value + ' -> ' + reverse0(value));
value = 4321;
println("Reverse1 Number : " + value + ' -> ' + reverse1(value));
value = 121;
println("Palindrome Number : " + value + ' -> ' + checkPalindrome(value));
value = 1234;
println("Palidrome Number : " + value + ' -> ' + checkPalindrome(value));
value = 'aba';
println("Palindrome String : " + value + ' -> ' + checkPalindrome(value));
value = '"abcd';
println("Palidrome String : " + value + ' -> ' + checkPalindrome(value));
