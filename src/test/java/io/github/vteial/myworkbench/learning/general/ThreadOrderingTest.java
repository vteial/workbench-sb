package io.github.vteial.myworkbench.learning.general;

public final class ThreadOrderingTest {

	public static void main(String... args) {

		ThreadOrderingTest tot = new ThreadOrderingTest();
		tot.value++;
		System.out.println(tot.value);
	}

	private int value;
}
