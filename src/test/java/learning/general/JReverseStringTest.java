package learning.general;


public class JReverseStringTest {

	public static void main(String args[]) {
		String word = "Eialarasu";
		System.out.println("Given Word = " + word);
		StringBuffer sb = new StringBuffer(word);
		word = sb.reverse().toString();
		System.out.println("Reverse Version 0 : " + word);
		word = reverseString1(word);
		System.out.println("Reverse Version 1 : " + word);
		word = reverseString2(word);
		System.out.println("Reverse Version 2 : " + word);
		word = reverseString3(word);
		System.out.println("Reverse Version 3 : " + word);
		word = reverseString4(word);
		System.out.println("Reverse Version 3 : " + word);
	}

	static String reverseString1(String word) {
		if (word.length() == 0)
			return word;
		return reverseString1(word.substring(1))
				+ Character.toString(word.charAt(0));
	}

	static String reverseString2(String word) {
		return word.length() == 0 ? word : reverseString1(word.substring(1))
				+ Character.toString(word.charAt(0));
	}

	static String reverseString3(String word) {
		if (word.length() < 2)
			return word;
		int halfIndex = word.length() / 2;
		return reverseString1(word.substring(halfIndex))
				+ reverseString2(word.substring(0, halfIndex));
	}

	static String reverseString4(String word) {
		String result = "";
		for (int i = word.length() - 1; i >= 0; i--) {
			result += Character.toString(word.charAt(i));
		}
		return result;
	}
}
