package io.github.vteial.myworkbench.learning.general;

public class JReverseListTest {

	public static void main(String args[]) {
		int items[] = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("Given Items = " + toPrintString(items));

		// System.out.println("Reverse Version 0 : ");

		System.out.println("Reverse Version 1 : "
				+ toPrintString(reverse1(items)));
		reverse2(items);
		System.out.println("Reverse Version 2 : " + toPrintString(items));

		reverse3(items);
		System.out.println("Reverse Version 3 : " + toPrintString(items));
	}

	static int[] reverse1(int[] items) {
		int[] nItems = new int[items.length];
		for (int i = 0, j = nItems.length - 1; i < items.length; i++, j--) {
			nItems[i] = items[j];
		}
		return nItems;
	}

	static void reverse2(int[] items) {
		int e = items.length / 2;
		for (int i = 0, j = items.length - 1; i < e; i++, j--) {
			int t = items[i];
			items[i] = items[j];
			items[j] = t;
		}
	}

	static void reverse3(int[] items) {
		reverse(items, 0, items.length - 1);
	}

	private static void reverse(int[] items, int i, int j) {
		if (i < j) {
			int t = items[i];
			items[i] = items[j];
			items[j] = t;
			reverse(items, ++i, --j);
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
}
