package learning.concurrency;

//	http://javarevisited.blogspot.in/2013/02/how-to-join-multiple-threads-in-java-example-tutorial.html

public class ThreadJoinMethodTest {

	public static void main(String... args) throws InterruptedException {

		System.out.println(Thread.currentThread().getName() + " is started");

		Thread exampleThread = new Thread() {
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName()
							+ " is started");
					Thread.sleep(2000);
					System.out.println(Thread.currentThread().getName()
							+ " is completed");
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		};

		exampleThread.start();
		//exampleThread.join();

		System.out.println(Thread.currentThread().getName() + " is completed");
	}

}