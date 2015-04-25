package threads;

import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumer {

	static Object lock = new Object();
	static LinkedList<Integer> linkedList = new LinkedList<Integer>();
	public static int LIMIT = 10;

	public static void main(String[] args) {
		Thread producer = new Thread(new Producer());
		Thread consumer = new Thread(new Consumer());

		producer.start();
		consumer.start();
	}

	static class Producer implements Runnable {
		public void run() {

			while (true) {
				try {
					Random random = new Random();
					Thread.sleep(random.nextInt(500));
					synchronized (lock) {

						while (LIMIT == linkedList.size()) {
							lock.wait();

						}
						int num = random.nextInt(1000);
						linkedList.add(num);
						System.out.println("List size: " + linkedList.size() + " number added: " + num);
						lock.notify();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	static class Consumer implements Runnable {
		public void run() {
			while (true) {
				try {
					Random random = new Random();
					Thread.sleep(random.nextInt(500));
					synchronized (lock) {
						while (linkedList.size() == 0) {
							lock.wait();
						}
						System.out.println("List size: " + linkedList.size() + " number removed: "
								+ linkedList.removeFirst());
						lock.notify();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
