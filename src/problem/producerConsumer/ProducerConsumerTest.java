package problem.producerConsumer;

public class ProducerConsumerTest {

	public static void main(String[] args) {

		ProducerConsumer producerConsumer = new ProducerConsumer();

		Thread producerThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					producerConsumer.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		Thread consumerThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					producerConsumer.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		producerThread.start();
		consumerThread.start();

	}

}
