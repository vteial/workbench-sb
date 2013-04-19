package learning.general;

public class EvenOrOddTest {

	public static void main(String args[]) {

		System.out
				.println("Checking if a number is even or odd using division and bitwise operator");
		for (int i = -1; i < 12; i++) {
			isEvenOrOdd(i); // calling division operator method
			isOddOrEven(i); // calling
		}

	}

	/*
	 * checking even and odd number without using modulus or remainder operator,
	 * Instead this method uses division operator.
	 */
	public static void isEvenOrOdd(int number) {
		int quotient = number / 2;

		if (quotient * 2 == number) {
			System.out.println("Using division operator: " + number
					+ " is Even number");

		} else {
			System.out.println("Using division operator: " + number
					+ " is Odd number");
		}
	}

	/*
	 * This method uses bitwise AND (&) operator to check if a number is even or
	 * odd in Java
	 */
	public static void isOddOrEven(int number) {
		if ((number & 1) == 0) {
			System.out.println("Using bitwise operator: " + number
					+ " is Even number");
		} else {
			System.out.println("Using bitwise operator: " + number
					+ " is Odd number");
		}
	}

}