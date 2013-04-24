// To live run use online groovy console from here http://groovyconsole.appspot.com/

package io.github.vteial.myworkbench.general

def reverseString0 = { String word ->
	return word.reverse();
}

def reverseString1 = {}
reverseString1 = { String word ->
	if(word.length() == 0) {
		return word;
	}
	return reverseString1(word.substring(1)) + word.charAt(0);
}

def reverseString2 = {}
reverseString2 = { String word ->
	return word.length() == 0 ? word : reverseString2(word.substring(1)) + word.charAt(0);
}

def reverseString3 = {}
reverseString3 = { String word ->
	if(word.length() < 2) {
		return word;
	}
	int halfIndex = word.length() / 2;
	return reverseString3(word.substring(halfIndex)) + reverseString3(word.substring(0, halfIndex));
}

def reverseString4 = { String word ->
	StringBuilder result = new StringBuilder();
	for(int i = word.length()-1; i >= 0 ; i--) {
		result.append(word.charAt(i));
	}
	return result.toString();
}

String word = "0123456789"
println("Given Word = " + word)

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