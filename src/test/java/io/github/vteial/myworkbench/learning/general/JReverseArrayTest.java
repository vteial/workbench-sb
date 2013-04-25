package io.github.vteial.myworkbench.learning.general;

public class JReverseArrayTest {

	static int[] reverseArray0(int[] items) {
		// yet to figure out sdk library's method to reverse array items
		return items;
	}

	static int[] reverseArray1(int[] items) {
		int[] nItems = new int[items.length];
		for (int i = 0, j = nItems.length - 1; i < items.length; i++, j--) {
			nItems[i] = items[j];
		}
		return nItems;
	}

	static void reverseArray2(int[] items) {
		int e = items.length / 2;
		for (int i = 0, j = items.length - 1; i < e; i++, j--) {
			int t = items[i];
			items[i] = items[j];
			items[j] = t;
		}
	}

	static void reverseArray3(int[] items) {
		reverseArray3(items, 0, items.length - 1);
	}

	private static void reverseArray3(int[] items, int i, int j) {
		if (i < j) {
			int t = items[i];
			items[i] = items[j];
			items[j] = t;
			reverseArray3(items, ++i, --j);
		}
	}

	static String toPrintString(int[] items) {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < items.length; i++) {
			sb.append(items[i] + ",");
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String args[]) {
		int items[] = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("Given Items = " + toPrintString(items));

		System.out.println("Reverse Version 0 : "
				+ toPrintString(reverseArray0(items)));

		System.out.println("Reverse Version 1 : "
				+ toPrintString(reverseArray1(items)));

		reverseArray2(items);
		System.out.println("Reverse Version 2 : " + toPrintString(items));

		reverseArray3(items);
		System.out.println("Reverse Version 3 : " + toPrintString(items));
	}
}
