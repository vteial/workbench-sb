package io.github.vteial.myworkbench.learning.concurrency;

import java.util.Vector;

// http://java67.blogspot.in/2012/12/producer-consumer-problem-with-wait-and-notify-example.html

public class ProducerConsumerV0Test {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " is started");

		Vector<Integer> sharedQueue = new Vector<Integer>();
		int queueSize = 4;
		ProducerV0 producer = new ProducerV0(sharedQueue, queueSize);
		Thread producerThread = new Thread(producer, "Producer");
		ConsumerV0 consumer = new ConsumerV0(sharedQueue, queueSize);
		Thread consumerThread = new Thread(consumer, "Consumer");

		producerThread.start();
		consumerThread.start();

		System.out.println(Thread.currentThread().getName() + " is finished");
	}

}
