package com.sanjeet.corejava.corejava.multithreading;

import java.util.ArrayList;
import java.util.List;

class ProducerDemo implements Runnable {
	private List<Integer> shared;
	private int capacity;

	public ProducerDemo(List<Integer> shared, int capacity) {
		this.shared = shared;
		this.capacity = capacity;
	}
	
	@Override
	public void run() {
		int count = 0;
		while (true) {
			produce(count++);
		}
	}

	private void produce(int count) {
		synchronized (shared) {
			if (shared.size() == capacity) {
				try {
					System.out.println(Thread.currentThread().getName() + "is waiting");
					shared.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			shared.add(count);
			System.out.println("Producer = " + count);

			shared.notifyAll();
		}
	}
}

class ConsumerDemo implements Runnable {
	private List<Integer> shared;

	public ConsumerDemo(List<Integer> shared) {
		this.shared = shared;
	}
	
	@Override
	public void run() {
		while (true) {
			consume();
		}
	}

	private void consume() {
		synchronized (shared) {
			if (shared.isEmpty()) {
				try {
					System.out.println(Thread.currentThread().getName() + "is waiting");
					shared.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Consumer = " + shared.remove(0));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			shared.notifyAll();

		}
	}
}

public class ProducerConsumer {

	public static void main(String[] args) {
		List<Integer> shared = new ArrayList<>();
		Thread t1 = new Thread(new ConsumerDemo(shared), "ConsumerThread");
		Thread t2 = new Thread(new ProducerDemo(shared, 5), "ProducerThread");
		t2.start();
		t1.start();

	}
}
