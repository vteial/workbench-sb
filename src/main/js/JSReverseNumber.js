// Uncomment below commented block if you are going to run in browser
/*
 var println = function(message) {
 console.log(message);
 }
 */
// Comment the above commented block if you are going to run in Eclipse

var reverseNumber0 = function(number) {
	return number.toString().split('').reverse().join('');
};

var reverseNumber1 = function(number) {
	var reverse = 0;
	while (number != 0) {
		reverse = reverse * 10 + number % 10;
		number = parseInt(number / 10);
		// println("reverse = " + reverse + " number = " + number);
	}
	return reverse;
};

println(reverseNumber0(1234));

println(reverseNumber1(123));
