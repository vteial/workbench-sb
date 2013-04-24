package io.github.vteial.myworkbench.learning.concurrency;

import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerV2 implements Runnable {

	private static final Logger logger = LoggerFactory
			.getLogger(ProducerV2.class);

	private final BlockingQueue<Integer> blockingQueue;

	public ProducerV2(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				logger.info("Produced : {}", i);
				blockingQueue.put(i);
				//logger.info("PQueue Size : {}", blockingQueue.size());
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}
