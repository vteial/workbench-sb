var isArmstrongNumber = function(number) {
	var oNumber = number, result = 0;
	while (number > 0) {
		var remainder = parseInt(number % 10);
		result += remainder * remainder * remainder;
		number = parseInt(number / 10);
	}
	return oNumber === result;
};

var val = 153;
println("IsArmstrongNumber(" + val + ") = " + isArmstrongNumber(val));
val = 321;
println("IsArmstrongNumber(" + val + ") = " + isArmstrongNumber(val));
val = 371;
println("IsArmstrongNumber(" + val + ") = " + isArmstrongNumber(val));