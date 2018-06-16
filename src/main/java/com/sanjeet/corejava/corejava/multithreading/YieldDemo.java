
package com.sanjeet.corejava.corejava.multithreading;

public class YieldDemo {
public static void main(String[] args) {
	Runnable task1=()->{
		//System.out.println("runnable run method");
		for(int i=0;i<5;i++){
			System.out.println("Producer "+i);
			Thread.yield();
		}
	};
	Thread t1=new Thread(task1);
	Runnable task2=()->{
		for(int i=0;i<5;i++){
			System.out.println("Consumer "+i);
			Thread.yield();
		}
	};
	Thread t2=new Thread(task2);
	t1.setPriority(Thread.MAX_PRIORITY);
	t2.setPriority(Thread.MIN_PRIORITY);
	t1.start();
	t2.start();
	System.out.println("Completed");
}
}

