package problem.producerConsumer;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

	private List<Integer> inventory = new ArrayList<>();
	private final int LIMIT = 5;
	private final int BASE = 0;
	private int count = 0;

	public void produce() throws InterruptedException {
		synchronized (this) {
			while (true) {
				if (inventory.size() == LIMIT) {
					System.out.println("Waiting for items to be removed from inventory...");
					wait();
				} else {
					System.out.println("Producing items to be added to inventory...");
					inventory.add(count);
					count++;
					notify();
				}
				Thread.sleep(200);

			}

		}

	}

	public void consume() throws InterruptedException {
		synchronized (this) {
			while (true) {
				if (inventory.size() == BASE) {
					System.out.println("Waiting for items to be added to inventory...");
					wait();
				} else {
					System.out.println("Removing items from inventory...");
					inventory.remove(--count);
					notify();
				}
				Thread.sleep(200);
			}
		}

	}

}
