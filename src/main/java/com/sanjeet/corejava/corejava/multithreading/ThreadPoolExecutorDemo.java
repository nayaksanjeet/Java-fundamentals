package com.sanjeet.corejava.corejava.multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorDemo {

	public static void main(String[] args) {
		Runnable task=()->{
			//for (int i = 0; i < 5; i++) {
				System.out.println("do the task ");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//}
		};
		ThreadPoolExecutor executor=(ThreadPoolExecutor)Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			System.out.println("A new task has been added "+i);
			executor.execute(task);
		}
		System.out.println("Thread pool size"+executor.getPoolSize());
		executor.shutdown();
	
}
	
}
/* ThreadpoolExecutor executor=(ThreadPoolExecutor) Excecutors.newCachedThreadPool();
 * executor.execute(task);
 * executor.shutdown();*/
 