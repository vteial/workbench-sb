package learning.concurrency;

import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerV0 implements Runnable {

	private static final Logger logger = LoggerFactory
			.getLogger(ProducerV0.class);

	private final Vector<Integer> sharedQueue;
	private final int queueSize;

	public ProducerV0(final Vector<Integer> sharedQueue, final int queueSize) {
		this.sharedQueue = sharedQueue;
		this.queueSize = queueSize;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				logger.info("Produced : {}", i);
				this.put(i);
				// logger.info("PQueue Size : {}", blockingQueue.size());
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

	private void put(int i) throws InterruptedException {
		while (sharedQueue.size() == queueSize) {
			synchronized (sharedQueue) {
				logger.info("PQueue is full and i am waiting, queueSize = {}",
						sharedQueue.size());
				sharedQueue.wait();
//				logger.info("PQueue is full and i am waiting, queueSize = {}",
//						sharedQueue.size());
			}
		}
		synchronized (sharedQueue) {
			sharedQueue.add(i);
			sharedQueue.notifyAll();
		}
	}
}
