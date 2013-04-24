package io.github.vteial.myworkbench.learning.concurrency;

import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerV2 implements Runnable {

	private static final Logger logger = LoggerFactory
			.getLogger(ConsumerV2.class);

	private final BlockingQueue<Integer> blockingQueue;

	public ConsumerV2(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				int i = blockingQueue.take();
				logger.info("Consumed : {}", i);
				//logger.info("CQueue Size : {}", blockingQueue.size());
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}
