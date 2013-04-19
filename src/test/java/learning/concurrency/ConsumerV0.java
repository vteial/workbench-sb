package learning.concurrency;

import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerV0 implements Runnable {

	private static final Logger logger = LoggerFactory
			.getLogger(ProducerV0.class);

	private final Vector<Integer> sharedQueue;
	private final int queueSize;

	public ConsumerV0(final Vector<Integer> sharedQueue, final int queueSize) {
		this.sharedQueue = sharedQueue;
		this.queueSize = queueSize;
	}

	@Override
	public void run() {
		while (true) {
			try {
				logger.info("Consumed : {}", this.get());
				Thread.sleep(50);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

	private int get() throws InterruptedException {
		while (sharedQueue.isEmpty()) {
			synchronized (sharedQueue) {
				logger.info("CQueue is full and i am waiting, queueSize = {}",
						sharedQueue.size());
				sharedQueue.wait();
//				logger.info("CQueue is full and i am waiting, queueSize = {}",
//						sharedQueue.size());
			}
		}
		synchronized (sharedQueue) {
			int val = sharedQueue.remove(0);
			sharedQueue.notifyAll();
			return val;
		}
	}
}
