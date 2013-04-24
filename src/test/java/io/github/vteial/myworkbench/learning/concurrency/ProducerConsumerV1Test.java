package io.github.vteial.myworkbench.learning.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// http://javarevisited.blogspot.in/2012/02/producer-consumer-design-pattern-with.html

public class ProducerConsumerV1Test {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " is started");

		BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>();
		ProducerV2 producer = new ProducerV2(blockingQueue);
		Thread producerThread = new Thread(producer, "Producer");
		ConsumerV2 consumer = new ConsumerV2(blockingQueue);
		Thread consumerThread = new Thread(consumer, "Consumer");

		producerThread.start();
		consumerThread.start();

		System.out.println(Thread.currentThread().getName() + " is finished");
	}

}
