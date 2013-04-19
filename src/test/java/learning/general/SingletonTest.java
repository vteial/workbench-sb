package learning.general;

public final class SingletonTest {

	public static void main(String[] args) {
		SingletonTest singletonTest = SingletonTest.getInstance();
		System.out.println("SingletonTest = " + singletonTest);
	}

	private static volatile SingletonTest singletonTest;

	private SingletonTest() {
		if (singletonTest != null) {
			throw new RuntimeException(
					"SingletonTest is already initialized...");
		}
	}

	public static SingletonTest getInstance() {
		if (singletonTest == null) {
			synchronized (SingletonTest.class) {
				if (singletonTest == null) {
					singletonTest = new SingletonTest();
				}
			}
		}
		return singletonTest;
	}
}
